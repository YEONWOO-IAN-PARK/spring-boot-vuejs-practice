<template>
<div>
  <list :title="`최근 입고된 도서`" :books="recentArrivalBooks"></list>
  <list :title="`베스트셀러 도서`" :books="bestsellerBooks"></list>
</div>
</template>
<script>
import BookService from '../services/BookService'
import List from '../components/book/List'

export default {
  name: "Home",
  data: function() {
    return {
      recentArrivalBooks: [],
      bestsellerBooks: [],
      page: 1
    }
  },
  created() {
    BookService.getRecentArrivalBooks()
      .then(response => {
        this.recentArrivalBooks = response.data.items;
      })
    BookService.getBestsellerBooks()
      .then(response => {
        this.bestsellerBooks = response.data.items;
      })
  },
  components: {
    'list': List
  }
}
</script>