<template>
  <div class="card">
    <div class="card-body">
      <router-link :to="`/book/detail/${currentPage}/${book.no}`"><img :src="`/assets/images/${book.no}.jpg`" alt="" class="img-thumbnail"></router-link>
      <strong class="book-title">{{book.title}}</strong>
      <div class="d-flex justify-content-between">
        <small class="text-secondary">{{book.writer}}</small>
        <small class="text-secondary">{{book.publisher}}</small>
      </div>
      <div class="d-flex justify-content-between">
        <small><strong class="text-danger">35,000원 (20% 할인)</strong></small>
        <small>300원 적립</small>
      </div>
      <div class="mt-3 d-flex justify-content-between">
        <span class="badge badge-primary align-bottom">무료배송</span>
        <span class="badge badge-success">새책</span>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'BookItem',
  props: ['book', 'currentPage']
}
</script>