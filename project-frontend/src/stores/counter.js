import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useCounterStore = defineStore('counter', () => {
  const count = ref(0)
  const doubleCount = computed(() => count.value * 2)
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment }
})
export const useCountdownStore = defineStore('countdown', {
  state: () => ({
    countdownFinished: false,
    totalSeconds:1800
  }),
  actions: {
    finishCountdown() {
      this.countdownFinished = true;
    },
    resetCountdown() {
      this.countdownFinished = false;
      this.totalSeconds = 1800; // 重置倒计时时间
    },
    startCountdown(seconds = 1800) {
      this.resetCountdown();
      this.totalSeconds = seconds;
    }
  }
});
