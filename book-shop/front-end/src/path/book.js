export default [
  {
    path: '/book/list/:page/:category?',
    name: 'BookList',
    component: () => import('../components/book/BookList')
  },
  {
    path: '/book/detail/:page/:no/:category?',
    name: 'BookDetail',
    component: () => import('../components/book/BookDetail')
  }
]