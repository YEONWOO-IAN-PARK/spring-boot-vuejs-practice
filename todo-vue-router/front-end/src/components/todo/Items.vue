<template>
  <div class="row border mt-3 p-3">
    <div v-if="isEmptyTodos" class="col-12 text-center">
      작업일정이 존재하지 않습니다.
    </div>
    <item v-else v-for='(todo, index) in todos' :key="index"
      :todo="todo"/>
  </div>
</template>
<script>
import Item from './Item'

export default {
  name: 'Items',
  props: ["todos"],
  components: {
    'item': Item
  },
  computed: {
    isEmptyTodos: function() {
      return this.todos.length == 0
    }
  }
}
</script>