<template>
  <div>
    <status-bar :todos="todos" />
    <todo-items :todos="todos" />
  </div>
</template>
<script>
import StatusBar from './StatusBar'
import TodoItems from './TodoItems'

export default {
  name: 'TodoList',
  props: ['todos'],
  components: {
    'status-bar': StatusBar,
    'todo-items': TodoItems
  }
}
</script>