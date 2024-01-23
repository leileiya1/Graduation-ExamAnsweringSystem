<script setup>
import {ElDivider} from 'element-plus';
import {useCountdownStore} from "@/stores/counter.js";
import {logout} from "@/axios/index.js";
import router from "@/router/index.js";
import {Clock, Message, Share, User} from "@element-plus/icons-vue";
import DownLoadQuestion from "@/views/question/DownLoadQuestion.vue";

const store = useCountdownStore();

function userLogout() {
  logout(() => router.push('/'))
}
const username = store.username
</script>

<template>


  <div class="toolbar" style="display: flex; align-items: center; height: 100%;justify-content: flex-end;">
    <div style="display: flex;margin: 20px;">
      <el-popover
          transition="el-fade-in-linear"
          :width="400"
          popper-style="box-shadow: rgb(14 18 22 / 35%) 0px 10px 38px -10px, rgb(14 18 22 / 20%) 0px 10px 20px -15px; padding: 20px;"
      >
        <template #reference>
          <el-avatar src="/image/sapiece.png"/>
        </template>
        <template #default>
          <div
              class="demo-rich-conent"
              style="display: flex; gap: 16px; flex-direction: column"
          >
            <div style="display: flex;flex-direction: column;align-items: center;">
              <el-avatar
                  :size="60"
                  src="/image/user.png"
                  style="margin-bottom: 8px"
              />
            </div>

            <div style="text-align: center">
              <p
                  class="demo-rich-content__name"
                  style="margin: 0; font-weight: 500"
              >
                <span style="font-weight: bolder">{{ store.username }}</span>
              </p>
              <p
                  class="demo-rich-content__mention"
                  style="margin: 0; font-size: 14px; color: var(--el-color-info)"
              >
                @{{ store.username }}
              </p>
            </div>

            <p class="demo-rich-content__desc" style="margin: 0">

              <div class="menu-container">
                <div class="menu-item">
                  <el-icon>
                    <User/>
                  </el-icon>
                  <span>个人中心</span>
                  <i class="el-icon-arrow-right"></i>
                </div>
                <div class="menu-item">
                  <el-icon>
                    <Message/>
                  </el-icon>
                  <span>投稿管理</span>
                  <i class="el-icon-arrow-right"></i>
                </div>
                <div class="menu-item">
                  <el-icon>
                    <Share/>
                  </el-icon>
                  <span>推荐服务</span>
                  <i class="el-icon-arrow-right"></i>
                </div>
                <el-divider></el-divider>
                <div class="menu-item">
                  <router-link to="/user" style="text-decoration: none;">
                    <span style="color: red">退出登录</span></router-link>
                </div>
              </div>
            </p>
          </div>
        </template>
      </el-popover>
    </div>
    <div class="header-function" style="margin: 10px;display: flex; flex-direction: column; align-items: center;">
      <el-icon style="font-size: 20px;">
        <Message/>
      </el-icon>
      <router-link to="/user" style="text-decoration: none;color: black">消息</router-link>
    </div>
    <div class="header-function" style="margin: 10px;display: flex; flex-direction: column; align-items: center;">
      <el-icon style="font-size: 20px;">
        <Clock/>
      </el-icon>
      <router-link to="/user" style="text-decoration: none;color: black">历史</router-link>
    </div>
    <div class="header-function" style="text-decoration: none;">
      <DownLoadQuestion/>
    </div>
  </div>

</template>

<style scoped>
@keyframes shake {
  0% {
    transform: translateX(0px);
  }
  25% {
    transform: translateX(-5px);
  }
  50% {
    transform: translateX(5px);
  }
  75% {
    transform: translateX(-5px);
  }
  100% {
    transform: translateX(0px);
  }
}

@keyframes shake-vertical {
  0%, 100% {
    transform: translateY(0);
  }
  25% {
    transform: translateY(-5px);
  }
  50% {
    transform: translateY(5px);
  }
  75% {
    transform: translateY(-5px);
  }
}

.el-icon:hover {
  animation: shake-vertical 0.5s; /* 动画持续时间为 0.5 秒 */
  animation-iteration-count: 1; /* 动画播放次数 */
}

.header-function {
  margin: 10px;

}

.menu-container {
  background-color: #fff; /* Or any color you want */
  border-radius: 10px; /* Or as per your design */
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1); /* Optional: for shadow */
  padding: 20px;
}

.menu-item {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-grow: 1;
  padding: 10px 0; /* Adjust the padding as needed */
  font-size: 16px; /* Adjust font-size as needed */
  color: #333; /* Adjust text color as needed */
}

.menu-item i {
  margin-right: 8px; /* Space between icon and text */
}

.menu-item:hover {
  background-color: #f5f5f5; /* 您想要的任何灰色 */
  border-radius: 10px; /* Or as per your design */
  cursor: pointer;
}

.el-icon-arrow-right {
  margin-left: auto; /* Push the arrow to the right */
}

.el-divider {
  margin: 10px 0; /* Adjust the margin as needed */
}
</style>