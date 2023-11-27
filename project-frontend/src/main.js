import './assets/main.css'
import './request/request'
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import axios from 'axios'
import App from './App.vue'
import router from './router'

const app = createApp(App)
axios.defaults.baseUrl='http://localhost:8080'
app.use(createPinia())
app.use(router)

app.mount('#app')
