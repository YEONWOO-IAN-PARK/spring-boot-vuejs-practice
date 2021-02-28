<template>
  <div class="container">
    <todo-status-bar @updateFilteredTodos="updateFilteredTodos"/>
    <todo-list-items :todos="filteredTodos"/>
  </div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import TodoStatusBar from './TodoStatusBar'
import TodoListItems from './TodoListItems'

export default {
  methods: {
    ...mapActions([
      'fetchTodos', 'updateFilteredTodos'
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