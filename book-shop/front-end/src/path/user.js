export default [
  {
    path: '/user/form',
    name: "UserForm",
    component: () => import('../components/user/UserForm')
  },
  {
    path: '/user/login',
    name: "UserForm",
    component: () => import('../components/user/LoginForm')
  }
]