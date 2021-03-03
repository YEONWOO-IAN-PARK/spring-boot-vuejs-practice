<template>
  <div class="container">
    <div class="col-12">
      <todo-form :formTitle="formTitle" :todo="todo" :callback="addTodo"/>
    </div>
  </div>
</template>
<script>
import TodoForm from './TodoForm'

export default {
  data() {
    return {
      formTitle: 'Todo 정보 입력폼',
      todo: {
        username: '',
        dueDate: '',
        title: '',
        description: ''
      }
    }
  },
  methods: {
    addTodo:function() {
      this.$store.dispatch('insertTodo', this.todo)
      .then(() => {
        this.$router.push("/todos/list")
      })
    }
  },
  components: {
    TodoForm
  }
}
</script>