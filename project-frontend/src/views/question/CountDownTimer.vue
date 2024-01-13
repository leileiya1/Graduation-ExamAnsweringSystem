<script setup>
import {onMounted, onUnmounted, ref,watch,computed} from "vue";
import {useCountdownStore} from "@/stores/counter.js";


let timer = null;
const store = useCountdownStore();
const formattedTime = ref('');
const totalSeconds = ref(store.totalSeconds); // 总秒数，例如1小时
const emit = defineEmits(['countdown-finished']);
// 格式化时间显示
const formatTime = () => {
  const hours = Math.floor(totalSeconds.value / 3600);
  const minutes = Math.floor((totalSeconds.value % 3600) / 60);
  const seconds = totalSeconds.value % 60;

  formattedTime.value = `${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
};
//小于15分钟时字体样式变成红色
const isLessThanFifteenMinutes = computed(() => {
  return totalSeconds.value <= 900; // 15分钟 = 900秒
});
// 更新倒计时
const updateTimer = () => {
  if (totalSeconds.value > 0) {
    totalSeconds.value--;
    formatTime();
  } else {
    clearInterval(timer);
    store.finishCountdown()
    emit('countdown-finished')
  }
};

onMounted(() => {
  formatTime();
  timer = setInterval(updateTimer, 1000);
});

onUnmounted(() => {
  if (timer) {
    clearInterval(timer);
  }
});
watch(() => store.totalSeconds, (newTime) => {
  totalSeconds.value = newTime;
  clearInterval(timer);
  timer = setInterval(updateTimer, 1000);
});
</script>

<template>
  <div class="countdown" :class="{ 'red': isLessThanFifteenMinutes }">
    {{ formattedTime }}
  </div>
</template>

<style scoped>
.countdown {
  font-size: 2em;
  text-align: center;
}
.red {
  color: red;
}
</style>