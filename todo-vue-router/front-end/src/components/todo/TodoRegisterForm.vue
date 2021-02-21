<template>
  <div class="container">
    <div class="col-12">
      <todo-form :formTitle="formTitle" :todo="todo" :cb="addTodo"/>
    </div>
  </div>
</template>
<script>
import TodoService from '../../services/TodoService'
import TodoForm from './TodoForm'

export default {
  name: "TodoRegisterForm",
  data() {
    return {
      formTitle: '새 Todo 정보 입력',
      todo: {
        user: {
          username: '',
          dueDate: '',
          title: '',
          description: ''
        }
      }
    }
  },
  methods: {
    addTodo(todo) {
      TodoService.insertTodo(todo)
        .then(() => {
          this.$router.push('/todos/list')
        })
        .catch(() => {
          alert("등록 작업 중 오류가 발생하였습니다.");
        })
    }
  },
  components: {
    'todo-form': TodoForm
  }
}
</script>