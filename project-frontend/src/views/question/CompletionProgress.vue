<script setup>
import {useProgressStore} from "@/stores/counter.js";

const progressStore = useProgressStore();
</script>

<template>
  <div>
    <el-progress type="circle" :percentage="progressStore.progress" status="success" :width="100" :height="100">
      <template #default="{ percentage }">
        <span class="percentage-value">{{ percentage }}%</span>
        <div><span class="percentage-label">已完成</span></div>
      </template>
    </el-progress>
  </div>
</template>

<style scoped>

</style>