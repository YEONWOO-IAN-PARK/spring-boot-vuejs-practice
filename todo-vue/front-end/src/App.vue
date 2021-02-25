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
        <div class="col-12">
          <form novalidate @submit.prevent="insertOrUpdateTodo">
            <div class="form-row">
              <div class="form-group col-6">
                <label>작성자</label>
                <input type="text" class="form-control" v-model="todo.username">
              </div>
              <div class="form-group col-6">
                <label>예정일자</label>
                <input type="date" class="form-control" v-model="todo.dueDate">
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-12">
                <label>제목</label>
                <input type="text" class="form-control" v-model="todo.title">
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-12">
                <label>설명</label>
                <textarea rows="5" class="form-control" v-model="todo.description"></textarea>
              </div>
            </div>
            <div class="text-right">
              <button type="button" class="btn btn-secondary">닫기</button>
              <button type="button" class="btn btn-primary" >완료</button>
            </div>
          </form>
        </div>
      </div>

      <!-- Todo 카드 표시부 시작 -->
      <div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-header">Todo List</div>
            <div class="card-body">
              <!-- Todo 현황 표시 버튼 시작 -->
              <div class="row px-3">
                <div class="col-10 p-3 border border-right-0  d-flex justify-content-between">
                  <button class="btn btn-info" @click="filteringTodos()">전체 <span class="badge badge-light">{{totalCount}}</span></button>
                  <button class="btn btn-primary" @click="filteringTodos('REGISTERED')">등록됨 <span class="badge badge-light">{{registeredCount}}</span></button>
                  <button class="btn btn-success" @click="filteringTodos('COMPLETED')">완료됨 <span class="badge badge-light">{{completedCount}}</span></button>
                  <button class="btn btn-secondary" @click="filteringTodos('DELAYED')">지연됨 <span class="badge badge-light">{{delayedCount}}</span></button>
                  <button class="btn btn-danger" @click="filteringTodos('DELETED')">삭제됨 <span class="badge badge-light">{{deletedCount}}</span></button>
                </div>
                <div class="col-2 p-3 border border-left-0 text-right">
                  <button class="btn btn-outline-primary">새 Todo 등록</button>
                </div>
              </div>
              <!-- Todo 현황 표시 버튼 끝 -->
              <div class="row">
                <!-- Todo 카드 시작-->
                <div class="col-3 mt-3 p-3 " v-for="(todo, index) in filtedTodos" :key="index">
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
      todo: {},
      todos: [],
      filtedTodos: []
    }
  },
  methods: {
    filteringTodos: function(status) {
      this.filtedTodos = []
      if (status) {
        this.todos.filter(todo => {
          return todo.status == status
        }).forEach(todo => {
          this.filtedTodos.push(todo)
        })
      } else {
        this.todos.forEach(todo => {
          this.filtedTodos.push(todo)
        });
      }
    },
    countTodosByStatus: function(status) {
      return this.todos.filter(todo => todo.status == status).length
    },
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
    totalCount: function() {
      return this.todos.length;
    },
    registeredCount: function() {
      return this.countTodosByStatus("REGISTERED")
    },
    completedCount: function () {
      return this.countTodosByStatus("COMPLETED")
    },
    delayedCount: function() {
      return this.countTodosByStatus("DELAYED")
    },
    deletedCount: function () {
      return this.countTodosByStatus("DELETED")
    }
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
        this.filtedTodos = response.data.items
      })
  }
}
</script>

<style>

</style>
