<script setup>

import {ChatDotRound, House, Message, Promotion, Setting, Tickets} from "@element-plus/icons-vue";
</script>

<template>
  <el-aside width="200px" class="el-aside">
    <el-scrollbar class="scrollbar" style="min-height: 100%">
      <el-menu  router >
        <el-menu-item index="/index/start-test">
          <template #title>
            <el-icon>
              <House/>
            </el-icon>
            试题测验
          </template>
        </el-menu-item>
        <el-menu-item index="/index/score-analysis">
          <template #title>
            <el-icon>
              <Tickets/>
            </el-icon>
            考试分析
          </template>
        </el-menu-item>
        <el-menu-item index="/index/exam-record">
          <template #title>
            <el-icon>
              <Tickets/>
            </el-icon>
            最近考试
          </template>
        </el-menu-item>
        <el-sub-menu index="/index/score-record">
          <template #title>
            <el-icon>
              <setting/>
            </el-icon>
            设置
          </template>
          <el-menu-item-group>
            <el-menu-item index="">
              <template #title>
                <el-icon>
                  <ChatDotRound/>
                </el-icon>
                用户反馈
              </template>
            </el-menu-item>
            <el-menu-item index="">
              <template #title>
                <el-icon>
                  <Promotion/>
                </el-icon>
                加盟
              </template>
            </el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
      </el-menu>
    </el-scrollbar>
  </el-aside>
</template>

<style scoped>

</style>