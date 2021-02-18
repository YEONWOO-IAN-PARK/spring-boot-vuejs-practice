import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
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