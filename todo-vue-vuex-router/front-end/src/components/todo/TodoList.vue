<template>
  <div class="container">
    <todo-status-bar @updatefilteredTodos="changeFilteredTodos"/>
    <todo-list-items :todos="filteredTodos"/>
  </div>
</template>
<script>
import TodoStatusBar from './TodoStatusBar'
import TodoListItems from './TodoListItems'

import {mapState, mapActions} from 'vuex'

export default {
  methods: {
    ...mapActions([
      'fetchTodos', 'changeFilteredTodos'
    ])
  },
  computed: {
    ...mapState([
      'todos', 'filteredTodos'
    ])
  },
  created() {
    this.fetchTodos()
  },
  components: {
    TodoStatusBar,
    TodoListItems
  }  
}
</script>