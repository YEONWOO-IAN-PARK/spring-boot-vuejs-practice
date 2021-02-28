import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: () => import('./components/Home')
    },
    {
      path:'/todos/list',
      name: 'TodoList',
      component: () => import('./components/todo/TodoList')
    },
    {
      path: '/todos/form',
      name: 'TodoRegisterForm',
      component: () => import('./components/todo/TodoRegisterForm')
    }
  ]
})