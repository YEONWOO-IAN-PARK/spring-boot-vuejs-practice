<template>
  <div class="row mt-3">
    <div class="col-12">
      <div class="card">
        <div class="card-header">책 목록</div>
        <div class="card-body">
          <table class="table">
            <thead>
              <tr>
                <th>순번</th>
                <th>제목</th>
                <th>저자</th>
                <th class="text-right pr-5">가격</th>
                <th>상태</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(book, index) in books" :key="index">
                <td>{{ index + 1 }}</td>
                <td>{{ book.title }}</td>
                <td>{{ book.writer }}</td>
                <td class="text-right pr-5">{{ book.price | currency }} 원</td>
                <td>{{ book.status }}</td>
                <td>
                  <router-link :to="'/book/detail/'+currentPage + '/' + book.no"  class="btn btn-primary btn-sm">상세정보</router-link>
                </td>
              </tr>
            </tbody>
          </table>
          <pagination :pageRange="pageRange" :current-page="currentPage" :total-pages="totalPages"></pagination>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import '../../filters/commonFilters'
import BookService from '../../services/BookService'
import Pagination from '../common/Pagination'

export default {
  name: 'BookList',
  data() {
    return {
      currentPage: 0,
      totalPages: 0,
      pageRange:[],
      paging: {},
      books: []
    }
  },
  methods: {
    generatePageRange: function(begin, end) {
      this.pageRange = new Array(end-begin+1).fill(begin).map((n,i)=>n+i);
    }
  },
  components: {
    'pagination': Pagination
  },
  created() {
    this.currentPage = this.$route.params.page || 1;
    
    BookService.getBooks(this.$route.params.page)
      .then(response => {
        this.books = response.data.items;
        this.paging = response.data.page;
        this.totalPages = this.paging.pages;
        this.generatePageRange(this.paging.begin, this.paging.end);
      })
  },
}
</script>

<style scoped>

</style>