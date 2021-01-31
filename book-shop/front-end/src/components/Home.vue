<template>
  <div class="row mt-3">
    <div class="col-12">
      <div class="card">
        <div class="card-header"></div>
        <div class="card-body">
          <div class="row">
            <div class="col-3">
              <img :src="`/assets/images/${book.no}.jpg`" class="card-img">
              <!-- <book-item :book="book" :current-page="currentPage"></book-item> -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
//import BookItem from './book/BookListItem'

export default {
  name: "Home",
  data: function() {
    return {
      book: {},
      currentPage: 1
    }
  },
  components: {
    //'book-item': BookItem
  }
}
</script>