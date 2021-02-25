<template>
  <div class="container">
    <todo-status-bar />
    <todo-list-items />
  </div>
</template>
<script>
import TodoStatusBar from './TodoStatusBar'
import TodoListItems from './TodoListItems'

export default {
  name: 'TodoList',
  components: {
    TodoStatusBar,
    TodoListItems
  }  
}
</script>