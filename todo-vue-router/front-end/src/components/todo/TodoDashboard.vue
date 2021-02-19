<template>
  <div class="container">
    <todo-status-bar :todos="todos" @filteringTodos="filteringTodos"/>
    <todo-dashboard-items :todos="filtedTodos" />
  </div>
</template>
<script>
import TodoService from '../../services/TodoService'
import TodoStatusBar from './TodoStatusBar'
import TodoDashboardItems from './TodoDashboardItems'

export default {
  name: 'List',
  data() {
    return {
      filtedTodos: [],
      todos: []
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
    }
  },
  components: {
    'todo-status-bar': TodoStatusBar,
    'todo-dashboard-items': TodoDashboardItems
  },
  created() {
    TodoService.getTodos()
      .then(response => { 
        var responseData = response.data
        if (responseData.status == 'OK') {
          this.todos = responseData.items
          this.filtedTodos = responseData.items
        }
      })
  }
}
</script>