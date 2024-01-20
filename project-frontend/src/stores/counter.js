import {defineStore} from 'pinia'

export const useCountdownStore = defineStore('countdown', {
  state: () => ({
    countdownFinished: false,
    totalSeconds: 1800,//考试倒计时设计
    username: null,//当前用户
    userId: null,
  }),
  actions: {
    finishCountdown() {
      this.countdownFinished = true;
    },
    resetCountdown() {
      this.countdownFinished = false;
      this.totalSeconds = 1800; // 重置倒计时时间
    },
    setUsername(username) {
      this.username = username;
    }, setUserId(id) {
      this.userId = id
    }
  }
});
export const usersCountdownStore = defineStore('answerData', {
  state: () => ({
    testResult: ''
  }), actions: {
    setTestResult(testTotal) {
      this.testResult = testTotal
    }
  }
})
export const useProgressStore = defineStore('progress', {
  state: () => ({
    progress: 0,
  }),
  actions: {
    updateProgress(questions, userAnswers) {
      const answeredQuestions = questions.filter(q => userAnswers[q.questionId].toString().trim() !== '').length;
      this.progress = Math.round((answeredQuestions / questions.length) * 100);
    }
  }
});