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
                <th>가격</th>
                <th>상태</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(book, index) in books" :key="index">
                <td>{{index + 1}}</td>
                <td>{{book.title}}</td>
                <td>{{book.writer}}</td>
                <td>{{book.price}}</td>
                <td>{{book.status}}</td>
                <td></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BookService from '../services/BookService'

export default {
  name: 'BookList',
  data() {
    return {
      books: []
    }
  },
  created() {
    BookService.getBooks()
      .then(response => {
        console.log(response.data);
        this.books = response.data.items;
      })
  },
}
</script>

<style scoped>

</style>