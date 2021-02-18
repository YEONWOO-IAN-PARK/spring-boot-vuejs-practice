<template>
  <div class="container">
    <status-bar :todos="todos" />
    <items :todos="todos" />
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
      todos: []
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
        }
      })
  }
}
</script>