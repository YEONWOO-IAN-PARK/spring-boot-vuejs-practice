<template>
  <div class="container">
    <todo-status-bar />
    <todo-list-items :todos="todos"/>
  </div>
</template>
<script>
import TodoStatusBar from './TodoStatusBar'
import TodoListItems from './TodoListItems'

export default {
  computed: {
    todos() {
      return this.$store.todos
    }
  },
  created() {
    this.$store.dispatch('fetchTodos')
  },
  components: {
    TodoStatusBar,
    TodoListItems
  }  
}
</script>