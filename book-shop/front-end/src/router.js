import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/book/list/:page',
      name: 'BookList',
      component: () => import('./components/book/BookList')
    },
    {
      path: '/book/detail/:page/:no',
      name: 'BookDetail',
      component: () => import('./components/book/BookDetail')
    }
  ]
})