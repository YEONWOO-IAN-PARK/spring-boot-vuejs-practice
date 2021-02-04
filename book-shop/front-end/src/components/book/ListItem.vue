<template>
  <div class="card">
    <div class="card-body">
      <router-link v-if="category" :to="`/book/detail?page=${page}&category=${category}&no=${book.no}`"><img :src="`/assets/images/${book.no}.jpg`" alt="" class="img-thumbnail"></router-link>
      <router-link v-else :to="`/book/detail?page=${page}&no=${book.no}`"><img :src="`/assets/images/${book.no}.jpg`" alt="" class="img-thumbnail"></router-link>
      <strong class="book-title">{{book.title}}</strong>
      <div class="d-flex justify-content-between">
        <small class="text-secondary">{{ book.writer }}</small>
        <small class="text-secondary">{{ book.publisher }}</small>
      </div>
      <div class="d-flex justify-content-between">
        <small><strong class="text-danger">{{ book.price | currency }}원 (20% 할인)</strong></small>
        <small>{{ book.savePoint | currency }}원 적립</small>
      </div>
      <div class="mt-3 d-flex justify-content-between">
        <span class="badge badge-primary align-bottom">무료배송</span>
        <span class="badge badge-success">새책</span>
      </div>
    </div>
  </div>
</template>

<script>
import '../../filters/common-filters'

export default {
  name: 'ListItem',
  props: ['book', 'page', 'category']
}
</script>

<style scoped>
.card {
  height: 475px;
}
.book-title {
  display: block;
  height: 52px;
  overflow: hidden;
}
.img-thumbnail {
  width: 202.5px;
  height: 289px;
}
</style>