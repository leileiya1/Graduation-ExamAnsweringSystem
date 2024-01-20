<script setup>

import Aside from "@/views/index/Aside.vue";
import Header from "@/views/index/Header.vue";
</script>

<template>
  <div>
    <el-container class="layout-container-demo" style="height: 100vh">
      <Aside />
    <el-container>
      <el-header>
        <Header/>
      </el-header>
      <el-main >
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
  </div>
</template>

<style scoped>

</style>