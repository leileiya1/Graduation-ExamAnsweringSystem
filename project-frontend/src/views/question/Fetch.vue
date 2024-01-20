<script setup>
import {onMounted, reactive, ref,nextTick} from "vue";
import {customGet} from "@/axios/index.js";
import {ElButton, ElDialog} from 'element-plus';
import TestPage from "@/views/question/TestPage.vue";
import {CircleCloseFilled} from "@element-plus/icons-vue";
import CountDownTimer from "@/views/question/CountDownTimer.vue";
import {useCountdownStore} from "@/stores/counter.js";

const testPageRef = ref(null)
const dataReady = ref(false)
const dialogVisible = ref(false);
const store = useCountdownStore()
const examStarted = ref(false);  // 跟踪考试是否开始
let questions=reactive([])

//axios成功后的请求处理将获得的data封装到questions里面然后传递给子组件TestPage中
function handleSuccess(data) {
  questions = data
}
function fetch() {
  examStarted.value=true
  customGet('/api/question/fetch', handleSuccess)
}
onMounted(() => {
  fetch();
  setTimeout(() => {
    dataReady.value = true
  }, 60)
})
const handleCountdownFinished = async () => {
  dialogVisible.value = false
  await nextTick()
  if (testPageRef.value && testPageRef.value?.handleSubmit) {
    testPageRef.value.handleSubmit();
  }
  store.resetCountdown()
};
</script>
<template>
  <div >
    <el-button type="primary" @click="dialogVisible = true">开始考试</el-button>
    <el-dialog destroy-on-close v-model="dialogVisible" :fullscreen="true" :show-close="false" @close="dialogVisible=false">
      <template #header="{ close, titleId, titleClass }">
        <div class="my-header">
          <h5 :id="titleId" :class="titleClass">考试中...</h5>
          <CountDownTimer @countdown-finished="handleCountdownFinished"/>
          <el-button type="danger" @click="close">
            <el-icon class="el-icon--left">
              <CircleCloseFilled/>

            </el-icon>
            退出考试
          </el-button>
        </div>
      </template>
      <TestPage ref="testPageRef" v-if="dataReady" :questions="questions"/>
    </el-dialog>
  </div>
</template>

<style scoped>
.my-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>