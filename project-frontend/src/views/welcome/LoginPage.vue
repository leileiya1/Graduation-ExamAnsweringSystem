<script setup>

import {Lock, User} from "@element-plus/icons-vue";
import {reactive, ref} from "vue";
import {login} from "@/axios/index.js";
import router from "@/router/index.js";
const form=reactive({
  username:'',
  password:'',
  remember:false
})
const rule={
  username:[
    {
      required:true,message:'请输入账号'
    }
  ],password:[
    {
      required:true,message:'请输入密码'
    }
  ]
}
const formRef=ref()
function userLogin(){
 // console.log("-----------")
  formRef.value.validate((valid)=>{
    if (valid){
      login(form.username,form.password,form.remember,()=>router.push('/index'))

    }
  })
}
</script>

<template>
  <div style="text-align: center;margin: 0 20px">
    <div style="margin-top: 150px;">
      <div style="font-size: 25px;font-weight: bold;">登录</div>
      <div style="font-size: 14px;color: grey">请登录系统</div>
    </div>
    <div style="margin-top: 50px;">
      <el-form :model="form" :rules="rule" ref="formRef">
        <el-form-item prop="username">
          <el-input v-model="form.username" maxlength="10" type="text" placeholder="请输入用户名或邮箱">
            <template #prefix>
              <el-icon><User/></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="form.password" maxlength="20" type="password" placeholder="请输入密码">
            <template #prefix>
              <el-icon><Lock /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-row>
          <el-col :span="12" style="text-align: left;">
            <el-form-item prop="remember">
              <el-checkbox v-model="form.remember" label="记住我"></el-checkbox>
            </el-form-item>
          </el-col>
          <el-col :span="12" style="text-align: right;">
            <el-link @click="router.push('/forget')">忘记密码?</el-link>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <div style="margin-top: 40px;">
      <el-button @click="userLogin()" style="width: 270px;" type="success" plain>登录</el-button>
    </div>
    <div>
      <el-divider >
        <span style="font-size: 12px;color: grey">没有账号,立即注册</span>
      </el-divider>
      <div>
        <el-button @click="router.push('/register')" plain>注册账号</el-button>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>