export default [
  {
    //path: '/book/list/:page/:category?',
    path: '/book/list',
    name: 'BookList',
    component: () => import('../components/book/BookList')
  },
  {
    //path: '/book/detail/:page/:no/:category?',
    path: '/book/detail',
    name: 'BookDetail',
    component: () => import('../components/book/BookDetail')
  }
]