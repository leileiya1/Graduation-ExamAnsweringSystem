<script setup>

import {logout} from "@/axios/index.js";
import router from "@/router/index.js";

function userLogout() {
  logout(()=>router.push('/'))
}
</script>

<template>
<div style="font-size: 50px">我是主界面 </div>
  <el-button @click="userLogout">退出系统</el-button>
</template>

<style scoped>

</style>