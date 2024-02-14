import {createRouter, createWebHistory} from 'vue-router'
import {unauthorized} from "@/axios/index.js";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '',
            name: 'welcome',
            component: () => import('@/views/WelcomeHome.vue'),
            children: [
                {
                    path: '',
                    name: 'welcome-login',
                    component: () => import('@/views/welcome/LoginPage.vue')
                },
                {
                    path: '/register',
                    name: 'welcome-register',
                    component: () => import('@/views/welcome/RegisterPage.vue')
                }, {
                    path: '/forget',
                    name: 'welcome-forget',
                    component: () => import('@/views/welcome/ForgetPage.vue')
                }
            ]
        }, {
            path: '/index',
            name: 'index',
            component: () => import('@/views/IndexView.vue'),
            children: [{
                name: 'index',
                path: '',
                component: () => import('@/views/index/IndexNullPage.vue')
            },{
                name: 'scoreAnalysis',
                path: 'score-analysis',
                component: () => import('@/views/index/ScoreAnalysis.vue')
            }, {
                path: 'start-test',
                name: 'startTest',
                component: () => import('@/views/question/Fetch.vue')
            }, {
                path: 'score-record',
                name: 'scoreRecord',
                component: () => import('@/views/index/TestRecord.vue')
            }, {
                path: 'exam-record',
                name: 'examRecord',
                component: () => import('@/views/question/ExamRecords.vue')
            },]
        }, {
            path: '/user',
            name: 'user',
            component: () => import('@/views/user/UserIndex.vue')
        }
    ]
})
router.beforeEach((to, from, next) => {
    const isUnauthorized = unauthorized()
    if (to.name.startsWith('welcome') && !isUnauthorized) {
        next('/index')
    } else if (to.fullPath.startsWith('/index') && isUnauthorized) {
        next('/')
    } else {
        next()
    }
})
export default router
