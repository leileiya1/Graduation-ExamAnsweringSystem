<script setup>
import {Document, Packer, Paragraph, TextRun} from "docx";
import JSZip from "jszip";
import {onMounted, reactive, ref} from "vue";
import {customGet} from "@/axios/index.js";

let questions = reactive([]);
const flag = ref(false);
const visible = ref(false)

function handleSuccess(data) {
  if (Array.isArray(data)) {
    questions.splice(0, questions.length, ...data); // 正确更新响应式数组
    flag.value = true;
  } else {
    console.error('Expected an array of questions, but got:', data);
  }
}

const fetch = () => {
  customGet('/api/question/fetch', handleSuccess);
}
onMounted(fetch);

const generateDocument = (questions, includeAnswers) => {
  // 初始化文档的章节和内容
  const children = [];

  let index = 1; // 初始化题目序号
  let questionCount = 0; // 用于跟踪当前页的题目数量

  questions.forEach((question) => {
    if (questionCount >= 5) {
      // 每五个题目插入一个分页符
      children.push(new Paragraph({children: [new TextRun({text: '', break: 2})]}));
      questionCount = 0; // 重置题目计数
    }
    // 题目段落
    children.push(new Paragraph({
      text: `${index}. ${question.content}`,
      spacing: {after: 200},
    }));

    if (["single_choice", "multiple_choice"].includes(question.type)) {
      question.options.split(',').forEach((option) => {
        children.push(new Paragraph(option.trim()));
      });
    }

    if (includeAnswers) {
      children.push(new Paragraph({
        text: `答案: ${question.answer}`,
        spacing: {before: 200, after: 200},
      }));
    }

    // 题目间隔
    for (let i = 0; i < 5; i++) {
      children.push(new Paragraph(''));
    }
    questionCount++; // 增加题目计数
    index++;
  });

  // 创建文档并直接初始化章节
  return new Document({
    sections: [
      {
        properties: {},
        children: children, // 添加所有的段落到章节
      },
    ],
  });
};

const downloadBlob = (blob, fileName, zip) => {
  zip.file(fileName, blob);
};

const downloadQuestionsAndAnswersAsZip = async () => {
  if (!flag.value || !Array.isArray(questions)) {
    console.error('The data is not ready or not in the correct format.');
    return;
  }
  if (!flag.value) return;
  visible.value = false
  try {
    const zip = new JSZip();
    const questionsDoc = generateDocument(questions, false);
    const answersDoc = generateDocument(questions, true);

    const [questionsBlob, answersBlob] = await Promise.all([
      Packer.toBlob(questionsDoc),
      Packer.toBlob(answersDoc)
    ]);

    downloadBlob(questionsBlob, "questions.docx", zip);
    downloadBlob(answersBlob, "questions-and-answers.docx", zip);

    zip.generateAsync({type: "blob"}).then((content) => {
      // 使用原生JavaScript下载ZIP文件
      const url = window.URL.createObjectURL(content);
      const link = document.createElement('a');
      link.href = url;
      link.download = "questions.zip";
      document.body.appendChild(link);
      link.click();
      link.remove();
      window.URL.revokeObjectURL(url);
    });
  } catch (e) {
    console.error('异常错误', e)
  }
};
</script>

<template>
  <el-popover :visible="visible" placement="top" :width="160">
    <p>确定要下载试题和答案吗</p>
    <div style="text-align: right; margin: 0">
      <el-button size="small" text @click="visible = false">取消</el-button>
      <el-button size="small" type="primary" @click="downloadQuestionsAndAnswersAsZip"
      >确认
      </el-button
      >
    </div>
    <template #reference>
      <el-button @click="visible = true">下载试题</el-button>
    </template>
  </el-popover>
</template>
<style scoped>
</style>