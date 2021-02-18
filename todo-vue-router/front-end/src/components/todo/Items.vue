<template>
  <div class="row border mt-3 p-3">
    <item v-for='(todo, index) in todos' :key="index"
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
  }
}
</script>