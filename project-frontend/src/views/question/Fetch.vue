<script setup>
import {reactive, ref} from "vue";
import {customGet} from "@/axios/index.js";
const examStarted = ref(false);  // 跟踪考试是否开始
const question = reactive({
  questionId: null,
  type: null,
  content: null,
  options: null,
  answer: null,
  isSelected: null
})
let questions=reactive([])

function handleSuccess(data) {
  questions.splice(0, questions.length, ...data);
  console.log('Questions received:', questions);
}

function fetch() {
  examStarted.value=true
  customGet('/api/question/fetch', handleSuccess)
}

</script>

<template>

  <div>
    <h1>Quiz</h1>
    <!-- 用户点击此按钮后开始考试 -->
    <el-button v-if="!examStarted" @click="fetch">Start Exam</el-button>
    <div v-if="examStarted">
      <!-- 仅当考试开始后显示题目 -->
      <div v-if="questions.length > 0">
        <div v-for="question in questions" :key="question.questionId">
          <h3>{{ question.content }}</h3>
          <ul>
            <li v-for="(option, index) in question.options.split(',')" :key="index">{{ option }}</li>
          </ul>
        </div>
      </div>
      <p v-else>Loading questions...</p>
    </div>
  </div>
</template>

<style scoped>

</style>