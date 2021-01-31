<template>
  <div class="row mt-3">
    <div class="col-12">
      <div class="card">
        <div class="card-header">책 목록</div>
        <div class="card-body">
          <div class="row">
            <div class="col-3 mb-3"
              v-for="book in books"
              :key="book.no">
              <book-item :book="book" :current-page="currentPage"></book-item>
            </div>
          </div>
          <pagination :pageRange="pageRange" 
            :current-page="currentPage" 
            :total-pages="totalPages"
            @move="move"></pagination>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import '../../filters/commonFilters'
import BookService from '../../services/BookService'
import BookItem from './BookListItem'
import Pagination from '../common/Pagination'

export default {
  name: 'BookList',
  data() {
    return {
      currentPage: 0,
      currentPageCategory: -1,
      totalPages: 0,
      pageRange:[],
      paging: {},
      books: []
    }
  },
  methods: {
    move: function(page) {
      this.currentPage = page
      this.refreshBookList(page, this.currentPageCategory);
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
      this.refreshBookList(this.$route.params.page, this.$route.params.category);
    }
  },
  components: {
    'pagination': Pagination,
    'book-item': BookItem
  },
  created() {
    this.currentPage = this.$route.params.page;
    this.currentPageCategory = this.$route.params.category;
    this.refreshBookList(this.currentPage, this.currentPageCategory);
  },
}
</script>

<style scoped>

</style>