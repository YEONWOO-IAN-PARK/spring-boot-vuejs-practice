<template>
  <!-- Vue 인스턴스 영역 시작 -->
  <div id="app">
    <div class="container">
      <!-- 헤더부 시작 -->
      <div class="row">
        <div class="col-12">
          <h1>Todo Application</h1>
        </div>
      </div>
      <!-- 헤더부 끝 -->

      <div class="row">
        <div class="col-10">
          <button class="btn"></button>
          <button class="btn"></button>
          <button class="btn"></button>
          <button class="btn"></button>
          <button class="btn"></button></div>
        <div class="col-2"></div>
      </div>

      <!-- Todo 카드 표시부 시작 -->
      <div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-header">Todo List</div>
            <div class="card-body">
              <div class="row">
                <!-- Todo 카드 시작-->
                <div class="col-3 mt-3 p-3 " v-for="(todo, index) in todos" :key="index">
                  <div class="card shadow ">
                    <div class="card-header">{{todo.title}}</div>
                    <div class="card-body">
                      <p class="card-text">{{todo.username}}</p>
                      <p class="card-text">{{todo.dueDate}}</p>
                      <div class="d-flex justify-content-between">
                        <span class="badge px-3 py-2" :class="badgeStyle(todo.status)">{{todo.status | statusToLocaleString}}</span>
                        <button class="btn btn-outline-primary btn-sm">상세보기</button>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- Todo 카드 끝 -->
              </div>
            </div>
          </div> 
        </div>
      </div>
      <!-- Todo 카드 표시부 끝 -->
    </div>
  </div>
  <!-- Vue 인스턴스 영역 끝 -->
</template>

<script>
import 'bootstrap/dist/css/bootstrap.min.css'
import TodoService from './services/TodoService' 

export default {
  name: 'App',
  data() {
    return {
      todos: []
    }
  },
  methods: {
    badgeStyle: function(status) {
      return {
        'badge-primary': status == 'REGISTERED',
        'badge-success': status == 'COMPLETED',
        'badge-secondary': status == 'DELAYED',
        'badge-danger': status == 'DELETED'
      }
    }
  },
  computed: {

  },
  filters: {
    statusToLocaleString: function(status) {
      if (status == 'REGISTERED') return '등록'
      if (status == 'COMPLETED') return '완료'
      if (status == 'DELAYED') return '지연'
      if (status == 'DELETED') return '삭제'
    }
  },
  created() {
    TodoService.getTodos()
      .then(response => {
        this.todos = response.data.items
      })
  }
}
</script>

<style>

</style>
