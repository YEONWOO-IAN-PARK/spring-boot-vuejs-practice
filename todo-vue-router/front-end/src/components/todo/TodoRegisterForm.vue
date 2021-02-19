<template>
  <div class="container">
    <div class="col-12">
      <todo-form />
    </div>
  </div>
</template>
<script>
import TodoForm from './TodoForm'

export default {
  name: "TodoRegisterForm",
  components: {
    'todo-form': TodoForm
  }
}
</script>