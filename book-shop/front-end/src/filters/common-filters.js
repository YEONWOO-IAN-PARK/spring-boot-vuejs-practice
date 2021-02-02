import Vue from 'vue'

Vue.filter('currency', value => {
  return new Number(value).toLocaleString();
});
Vue.filter('formatNumber', value => {
  return new Number(value).toLocaleString();
})
Vue.filter('formatDate', value => {
  return new Date(value).toLocaleDateString();
})
Vue.filter('percent', value => {
  return parseInt(value*100);
})