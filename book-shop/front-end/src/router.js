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
      path: '/book/list/:page/:category?',
      name: 'BookList',
      component: () => import('./components/book/BookList')
    },
    {
      path: '/book/detail/:page/:no/:category?',
      name: 'BookDetail',
      component: () => import('./components/book/BookDetail')
    }
  ]
})