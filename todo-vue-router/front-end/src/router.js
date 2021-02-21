import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      alias: '/home',
      name: 'Home',
      component: () => import('./components/Home')
    },
    {
      path: '/todos/list',
      name: 'List',
      component: () => import('./components/todo/TodoDashboard')
    },
    {
      path: '/todos/form',
      name: 'Form',
      component: () => import('./components/todo/TodoRegisterForm')
    },
    {
      path: '/todos/detail/:id',
      name: 'Detail',
      component: () => import('./components/todo/TodoDetail')
    },
    {
      path: '/todos/modify/:id',
      name: 'Modify',
      component: () => import('./components/todo/TodoModifyForm')
    }
  ]
})