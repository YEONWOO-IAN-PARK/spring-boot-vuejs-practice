<template>
  <div class="container">
    <todo-list :todos="todos"/>
  </div>
</template>
<script>
import TodoService from '../../services/TodoService'
import TodoList from './TodoList'

export default {
  name: "TodoMain",
  data() {
    return {
      todos: []
    }
  },
  components: {
    'todo-list': TodoList
  },
  created() {
    TodoService.getTodos()
      .then(response => {
        var responseData = response.data
        if (responseData.status == 'OK') {
          this.todos = responseData.items
          console.log(this.todos);
        }
      })
  }
}
</script>