import Vue from 'vue'
import VueRouter from 'vue-router'
import BookRoutes from './path/book'
import UserRoutes from './path/user'

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: () => import('./components/Home')
    },
    ...BookRoutes,
    ...UserRoutes
  ]
})