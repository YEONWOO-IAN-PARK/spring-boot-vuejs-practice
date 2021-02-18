<template>
  <div class="container">
    <status-bar :todos="todos" @filteringTodos="filteringTodos"/>
    <items :todos="filtedTodos" />
  </div>
</template>
<script>
import TodoService from '../../services/TodoService'
import StatusBar from './StatusBar'
import Items from './Items'

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
    'status-bar': StatusBar,
    'items': Items
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