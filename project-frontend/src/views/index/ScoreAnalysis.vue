<script setup>
import {usersCountdownStore} from "@/stores/counter.js";
import {ref} from "vue";

const testData = usersCountdownStore();
// 使用 trim() 和 split() 处理字符串，并移除空字符串
const rawQuestions = testData.testResult.trim().split("#").filter(q => q);
const activeNames = ref([]); // 用于控制展开的折叠面板
const questions = rawQuestions.map(q => {
  const parts = q.split("@");
  return {
    id: parts[0].split(":")[1],
    question: parts[1],
    answer: parts[2].split(":")[1],
    userAnswer: parts[3].split(":")[1],
    type: parts[4].split(":")[1]
  };
});
//格式化多选题选项
const formatAnswer = (answer) => {
  return answer.split(',').join('.');
};
const isCorrect = (question) => {
  // 检查用户是否未作答
  if (question.userAnswer === '未作答' || question.userAnswer === '') {
    return false;
  }
  if (question.type === 'multiple_choice') {
    const userAnswers = question.userAnswer.split(',').map(s=>s.trim()).sort().join('.');
    const correctAnswers = question.answer.split('.').map(s=>s.trim()).sort().join('.');
    return userAnswers === correctAnswers;
  }
  // 其他题型的答案处理
  return question.userAnswer === question.answer;
};

</script>

<template>
  <el-row :gutter="20">
    <el-col :span="6" v-for="(question, index) in questions" :key="question.id">
      <el-collapse v-model="activeNames" accordion>
        <el-collapse-item :title="'问题 ' + (index + 1)" :name="question.id" >
          <!-- 问题描述 -->
          <div style="color: deepskyblue"><span style="color: black;font-weight: bold">题目:</span>{{question.question }}
          </div>
          <!-- 答案展示 -->
          <div style="color: red" v-if="question.type === 'single_choice' || question.type === 'multiple_choice'">
            <!-- 使用 el-result 展示答案的正确性 -->
            <el-result
                :status="isCorrect(question) ? 'success' : 'error'"
                :icon="isCorrect(question) ? 'success' : 'error'"
            >
              <template #title>
                <span :style="{ color: isCorrect(question) ? 'green' : 'red' }">您的答案: {{
                    formatAnswer(question.userAnswer)
                  }}</span>
              </template>
            </el-result>
            <div class="answer-text"><span style="color: black">答案</span>: {{ question.answer }}</div>
          </div>

          <!-- 填空题和简答题答案 -->
          <div style="color: red" v-if="question.type === 'fill_in_the_blank' || question.type === 'essay'">
            <div class="answer-text"><span style="color: black">答案</span>:{{ question.answer }}</div>
          </div>
        </el-collapse-item>
      </el-collapse>
    </el-col>
  </el-row>
</template>


<style scoped>
.el-result__icon {
  font-size: 30px; /* 缩小图标大小 */
}

.el-result__title,
.el-result__subtitle {
  margin: 5px 0; /* 减小间距 */
}

.answer-text {
  margin-top: 10px; /* 答案文本上方的间距 */
  font-size: 0.9em; /* 答案文本的字体大小 */
}

.el-collapse-item {
  border: 1px solid #ebeef5; /* 折叠面板边框样式 */
}
</style>