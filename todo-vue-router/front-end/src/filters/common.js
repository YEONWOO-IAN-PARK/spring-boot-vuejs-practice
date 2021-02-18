import Vue from 'vue'

Vue.filter('statusToLocaleString', status => {
  if (status == 'REGISTERED') return '등록'
  if (status == 'COMPLETED') return '완료'
  if (status == 'DELAYED') return '지연'
  if (status == 'DELETED') return '삭제'
});