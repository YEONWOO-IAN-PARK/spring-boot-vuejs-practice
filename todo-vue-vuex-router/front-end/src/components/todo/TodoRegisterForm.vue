<template>
  <div class="container">
    <div class="col-12">
      <todo-form :formTitle="formTitle" :todo="todo" :callback="addTodo"/>
    </div>
  </div>
</template>
<script>
import {mapActions} from 'vuex'
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
    ...mapActions([
      'insertTodo'
    ]),
    addTodo: function(todo) {
      this.insertTodo(todo)
      this.$router.push('/todos/list')
    }
  },
  components: {
    TodoForm
  }
}
</script>