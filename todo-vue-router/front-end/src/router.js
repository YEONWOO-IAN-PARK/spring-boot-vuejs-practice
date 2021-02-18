import Vue from 'vue'
import VueRouter from 'vue-router'

// Vue가 VueRouter를 사용하도록 설정
Vue.use(VueRouter)

// 요청URL과 매핑되는 컴포넌트 정보를 정의하고 있는 파일이다.
export default new VueRouter({
    mode: 'history',
    // 요청URL과 매핑되는 컴포넌트 정보 정의
    routes: [
        // path는 요청URL
        // component에서 import하는 컴포넌트가 App.vue의 <router-view />에 대체된다.
        {
            path: '/home',
            name: 'Home',
            // component: function() { return import('./components/Home'); }
            component: () => import('./components/Home')
        },
        {
            path: '/todos/list',
            name: 'List',
            component: () => import('./components/todo/List')
        },
        {
            path: '/todos/detail/:id',
            name: 'Detail',
            component: () => import('./components/todo/Detail')
        }
    ]
})