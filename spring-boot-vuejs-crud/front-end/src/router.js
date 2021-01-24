import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      alias: '/tutorials',
      name: 'tutorials',
      component: () => import('./components/TutorialsList')
    },
    {
      path: '/tutorials/:id',
      name: 'tuturial-details',
      component: () => import('./components/Tutorial')
    },
    {
      path: '/add',
      name: 'add',
      component: () => import('./components/AddTutorial')
    }
  ]
});