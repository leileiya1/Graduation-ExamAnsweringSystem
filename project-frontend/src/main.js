
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import axios from 'axios'
import App from './App.vue'
import router from './router'
const app = createApp(App)
axios.defaults.baseURL='http://localhost:8080'
app.use(createPinia())
app.use(router)
app.use(ElementPlus)
app.mount('#app')
