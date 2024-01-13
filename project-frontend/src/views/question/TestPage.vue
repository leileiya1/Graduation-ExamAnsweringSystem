<script setup>
import {computed, reactive, ref, watch} from 'vue'
import {useCountdownStore} from "@/stores/counter.js";
import levenshtein from 'fast-levenshtein'
import router from "@/router/index.js";
const props = defineProps({
  questions: Array
})
//提交时的dialog
let showDialog=ref(false)
const tabs = ['single_choice', 'multiple_choice', 'fill_in_the_blank', 'essay'];
//用于监听CountDownTimer组件倒计时变化
const store = useCountdownStore();
// 将 questions 转换为响应式对象
const reactiveQuestions = reactive(props.questions);
const activeTab = ref('single_choice');
// 创建一个响应式对象来存储用户答案
const userAnswers = reactive({});
const handleTabClick = (tabEvent) => {
  // 从 tabEvent.props 中提取标签页的名称
  const tabName = tabEvent.props.name;
  if (tabName) {
    activeTab.value = tabName;
  }
};
//题目序号
let globalQuestionIndex = 0;
// 当组件初始化时，为每个问题设置一个空字符串作为初始答案
props.questions.forEach(question => {
  if (question.type === 'multiple_choice') {
    userAnswers[question.questionId] = [];
  } else { // 包括 'single_choice', 'fill_in_the_blank', 'essay'
    userAnswers[question.questionId] = '';
  }
});
// 给每个问题添加一个全局索引
reactiveQuestions.forEach((question, index) => {
  question.globalIndex = index + 1;
});
const filteredQuestions = computed(() => {
  return reactiveQuestions.filter(q => q.type === activeTab.value);
});
watch(() => store.countdownFinished, (newValue) => {
  if (newValue) {
    handleSubmit()
    store.resetCountdown();
  }
});

// 检查是否所有问题都被回答
const isAllAnswered = computed(() => {
  return props.questions.every(question => {
    const answer = userAnswers[question.questionId];
    return  question.type === 'multiple_choice' ? answer.length > 0 : answer.trim() !== '';
  });
});

// 计算总分的逻辑
const calculateTotalScore = () => {
  let totalScore = 0;

  props.questions.forEach(question => {
    let userAnswer = userAnswers[question.questionId];
    let correctAnswer = question.answer;
    switch (question.type) {
      case 'single_choice':
        if (userAnswer){
          totalScore += userAnswer === correctAnswer ? 5 : 0;//单选题得分
        }
        break;
      case 'multiple_choice':
        if (userAnswer && userAnswer.length>0){
          const correctOptions = correctAnswer.split('.');
          const isCorrect = userAnswer.sort().toString() === correctOptions.sort().toString();
          totalScore += isCorrect ? 5 : 0;
        }
        break;
      case 'fill_in_the_blank':
        // 使用Levenshtein距离计算填空题的相似度
        if (userAnswer) {
          const distance = levenshtein.get(userAnswer.toLowerCase(), correctAnswer.toLowerCase());
          const similarity = 1 - (distance / Math.max(userAnswer.length, correctAnswer.length));
          totalScore += similarity >= 0.7 ? 6 : 0;
        }
        break;
      case 'essay':
        // 使用Levenshtein距离计算简答题的相似度
        if (userAnswer) {
          const distance = levenshtein.get(userAnswer.toLowerCase(), correctAnswer.toLowerCase());
          const similarity = 1 - (distance / Math.max(userAnswer.length, correctAnswer.length));
          totalScore += similarity >= 0.5 ? 15 : 0;
        }
        break;
    }
  });
  console.log('Total Score:', totalScore); // 用于调试
  return totalScore;
};

// 提交答案
const handleSubmit = () => {
  console.log('User Answers at Submission:', userAnswers); // 用于调试
  if (!isAllAnswered.value) {
    showDialog.value = true;
  } else {
    // 执行提交逻辑，计算总分
    const totalScore = calculateTotalScore();

    // 这里可以添加其他提交逻辑，如发送数据到服务器
    router.push('/index/exam-record')
  }
};

// 强制提交答案（即使有未回答的问题）
const forceSubmit = () => {
  showDialog.value = false;
  const totalScore = calculateTotalScore();
  console.log('总分（强制提交）：', totalScore);
  router.push('/index/exam-record')
  // 这里可以添加将分数发送到服务器的逻辑
};
/*
* 上下页的按钮逻辑
* */
//上一页的逻辑
const showPrevButton = computed(() => {
  return tabs.indexOf(activeTab.value) > 0;
});
//下一页的逻辑
const showNextButton = computed(() => {
  return tabs.indexOf(activeTab.value) < tabs.length - 1;
});
//按钮的逻辑更改
const changeTab = (direction) => {
  const currentIndex = tabs.indexOf(activeTab.value);
  if (direction === 'next' && currentIndex < tabs.length - 1) {
    activeTab.value = tabs[currentIndex + 1];
  } else if (direction === 'prev' && currentIndex > 0) {
    activeTab.value = tabs[currentIndex - 1];
  }
};
const showSubmitButton = computed(() => {
  return activeTab.value === 'essay';
});
const nextPage = () => changeTab('next');
const prevPage = () => changeTab('prev')
</script>
<template>
  <div>
    <div class="tabs-container">
      <el-tabs v-model="activeTab" @tab-click="handleTabClick" type="card">
        <el-tab-pane label="单选题" name="single_choice"></el-tab-pane>
        <el-tab-pane label="多选题" name="multiple_choice"></el-tab-pane>
        <el-tab-pane label="填空题" name="fill_in_the_blank"></el-tab-pane>
        <el-tab-pane label="简答题" name="essay"></el-tab-pane>
      </el-tabs>
    </div>
    <div v-for="question in filteredQuestions" :key="question.questionId" class="content-container">
      <div class="question-container">
        <!-- 添加序号 -->
        <div class="question-number"> {{question.globalIndex }}.</div>
        <!-- 题目内容 -->
        <div class="question-content">
          <!-- 单选题的渲染逻辑 -->
          <div v-if="question.type === 'single_choice'">
            <div style="margin-bottom: 20px;">{{ question.content }}</div>
            <el-radio-group v-model="userAnswers[question.questionId]" style="display: block;">
              <div style="margin-bottom: 10px;" v-for="(option, index) in question.options.split(',')" :key="index">
                <el-radio-button :label="option.split('.')[0]"  :key="index">
                  {{ option }}
                </el-radio-button>
              </div>
            </el-radio-group>
          </div>
          <!-- 多选题的渲染逻辑 -->
          <div v-if="question.type === 'multiple_choice'">
            <div style="margin-bottom: 20px;">{{ question.content }}</div>
            <el-checkbox-group v-model="userAnswers[question.questionId]">
              <el-checkbox-button style="margin-bottom: 10px;display:block;" :label="option.split('.')[0]"
                                  v-for="option in question.options.split(',')" :key="option">
                {{ option }}
              </el-checkbox-button>
            </el-checkbox-group>
          </div>
          <!-- 填空题的渲染逻辑 -->
          <div v-if="question.type === 'fill_in_the_blank'">
            <div style="margin-bottom: 5px;">{{ question.content }}</div>
            <el-input maxlength="100" placeholder="请作答" type="text" clearable
                      v-model="userAnswers[question.questionId]" style="display: block;margin-bottom: 20px;"></el-input>
          </div>
          <!-- 简答题渲染逻辑 -->
          <div v-if=" question.type === 'essay'">
            <div style="margin-bottom: 20px;">{{ question.content }}</div>
            <el-input maxlength="100" placeholder="请作答" type="textarea" clearable
                      v-model="userAnswers[question.questionId]" style="display: block;margin-bottom: 20px;"></el-input>
          </div>
        </div>
      </div>
    </div>
    <!-- “下一页”按钮 -->
    <div style="text-align: center">
      <!-- 上一页按钮 -->
      <el-button type="primary" v-if="showPrevButton" @click="prevPage">上一页</el-button>
      <!-- 下一页按钮 -->
      <el-button type="success" v-if="showNextButton" @click="nextPage">下一页</el-button>
      <!-- 提交按钮 -->
      <el-button type="danger" v-if="showSubmitButton" @click="handleSubmit">提交</el-button>
      <div>
      <!-- 提示对话框 -->
      <el-dialog
          title="提示"
          v-model="showDialog"
          @confirm="handleSubmit"
          width="30%" center
      >
        <p>还有未完成的问题，确定要提交吗？</p>
        <template #footer>
          <el-button @click="showDialog = false">取消</el-button>
          <el-button type="danger" @click="forceSubmit">确认</el-button>
        </template>
      </el-dialog>
    </div>
    </div>
  </div>
</template>
<style scoped>
.tabs-container {
  display: flex; /* 启用 Flexbox */
  flex-direction: column; /* 垂直方向布局 */
  align-items: center; /* 水平居中 */
  width: 100%;
}

.content-container {
  width: 100%; /* content-container 的宽度，根据需要调整 */
  /* 添加其他需要的样式，比如边距、字体等 */
}

.question-container {
  display: flex;
  align-items: flex-start; /* 确保内容在顶部对齐 */
}

.question-number {
  margin-right: 10px; /* 在序号和题目内容之间添加一些间隙 */
  font-weight: bold;
}

.question-content {
  flex-grow: 1;
}
</style>