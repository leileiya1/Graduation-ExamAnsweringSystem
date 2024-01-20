<script setup>
import {computed, onMounted, reactive} from "vue";
import {customGet} from "@/axios/index.js";


let testData = reactive([])
const pageSize = 3; // 每页显示的数量
onMounted(() => {
  customGet('/api/test-data/user-test-data', handleSuccess)
})
const state = reactive({
  currentPage: 1
});
const displayData = computed(() => {
  const start = (state.currentPage - 1) * pageSize;
  const end = start + pageSize;
  return testData.slice(start, end);
});
const handlePageChange = (newPage) => {
  state.currentPage = newPage;
};

function handleSuccess(data) {
  if (data && data.length > 0) {
    testData.splice(0, testData.length, ...data);
    state.currentPage = 1
  }
}

//格式化时间
const formatTime = (time) => {
  const date = new Date(time);
  return `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()} ${date.getHours()}:${date.getMinutes()}`;
};
const formationTime = (time) => {
  const date = new Date(time);
  return `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()} `;
}
</script>
<template>
  <div style="overflow: hidden">
    <el-timeline>
      <el-timeline-item
          v-for="(item, index) in displayData"
          :key="index"
          :timestamp="formationTime(item.testTime)"
          placement="top"
      >
        <el-card>
          <h4 style="display: inline;">考试分数成绩报告!</h4> <span style="margin-left: 80%">用户昵称: <router-link
            to="/user" style="text-decoration: none"><span
            style="font-family: 'Microsoft YaHei',Arial,sans-serif;font-size: 14px;color: deepskyblue">{{
            item.name
          }}</span> </router-link>  </span>
          <h3 style="padding-right:5% "></h3><span
            style="color: red;margin-left: 92%;font-size: 13px">分数:{{ item.score }}</span>
          <p style="font-size: 10px">提交时间: {{ formatTime(item.testTime) }}</p>
        </el-card>
      </el-timeline-item>
    </el-timeline>
    <div class="pagination-container">
      <el-pagination
          @current-change="handlePageChange"
          :current-page="state.currentPage"
          :page-size="pageSize"
          :total="testData.length"
          layout="prev, pager, next">
      </el-pagination>
    </div>
  </div>
</template>
<style scoped>
.pagination-container {
  display: flex;
  justify-content: center; /* 使子元素居中 */
}
</style>