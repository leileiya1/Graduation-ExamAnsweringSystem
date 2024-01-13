<script setup>

import {logout} from "@/axios/index.js";
import router from "@/router/index.js";
import Aside from "@/views/index/Aside.vue";
import {Setting} from "@element-plus/icons-vue";
import Main from "@/views/index/Main.vue";

function userLogout() {
  logout(()=>router.push('/'))
}
</script>

<template>
  <div>
  <el-container class="layout-container-demo" style="height: 100%">
    <Aside/>
    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <div class="toolbar">
          <el-dropdown>
            <el-icon style="margin-right: 8px; margin-top: 1px"
            ><setting
            /></el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>View</el-dropdown-item>
                <el-dropdown-item>Add</el-dropdown-item>
                <el-dropdown-item>Delete</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <span>Tom</span>
          <el-button @click="userLogout">退出</el-button>
        </div>
      </el-header>
      <router-view/>
    </el-container>
  </el-container>
  </div>
</template>

<style scoped>

</style>