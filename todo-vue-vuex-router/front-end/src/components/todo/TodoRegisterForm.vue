<template>
  <div class="container">
    <div class="col-12">
      <todo-form :formTitle="formTitle" :todo="todo" />
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
   
  },
  computed: {
   
  },
  components: {
    TodoForm
  }
}
</script>