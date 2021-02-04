<template>
  <div>
    <list :title="`도서목록`" :books="books" :page="page" :category="category"></list>
    <pagination :pageRange="pageRange" 
      :page="page" 
      :total-pages="totalPages"
      @move="move"></pagination>
  </div>
</template>

<script>
import '../../filters/common-filters'
import BookService from '../../services/BookService'
import List from './List'
import Pagination from '../common/Pagination'

export default {
  name: 'BookList',
  data() {
    return {
      page: 1,
      category: undefined,
      totalPages: 0,
      pageRange:[],
      paging: {},
      books: []
    }
  },
  methods: {
    move: function(page) {
      this.page = page
      this.refreshBookList(page, this.category);
    },
    generatePageRange: function(begin, end) {
      this.pageRange = new Array(end-begin+1).fill(begin).map((n,i)=>n+i);
    },
    refreshBookList: function(page, category) {
      BookService.getBooks(page, category)
        .then(response => {
          this.books = response.data.items;
          this.paging = response.data.page;
          this.totalPages = this.paging.pages;
          this.generatePageRange(this.paging.begin, this.paging.end);
        })
    }
  },
  watch: {
    $route() {
      this.refreshBookList(this.$route.query.page, this.$route.query.category);
    }
  },
  components: {
    'list': List,
    'pagination': Pagination
  },
  created() {
    this.page = this.$route.query.page;
    if (this.$route.query.category) {
      this.category = this.$route.query.category ;
    }
    this.refreshBookList(this.page, this.category);
  },
}
</script>