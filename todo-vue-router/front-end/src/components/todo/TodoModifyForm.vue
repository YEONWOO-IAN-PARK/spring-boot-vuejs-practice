<template>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <todo-form :formTitle="formTitle" :todo="todo" :cb="updateTodo"/>
      </div>
    </div>
  </div>
</template>
<script>
import TodoService from '../../services/TodoService'
import TodoForm from './TodoForm'

export default {
  name: 'TodoModifyForm',
  data() {
    return {
      formTitle: 'Todo 정보 수정',
      todo: {}
    }
  },
  methods: {
    updateTodo: function(todo) {
      TodoService.updateTodo(todo)
        .then(response => {
          var responseData = response.data;
          if (responseData.status == 'OK') {
            this.$router.push(`/todos/detail/${todo.id}`)
          } else {
            alert("수정 작업 중 오류가 발생하였습니다.");
          }
        })
    }
  },
  components: {
    'todo-form': TodoForm
  },
  created() {
    TodoService.getTodo(this.$route.params.id)
      .then(response => {
        var responseData = response.data;
        if (responseData.status == "OK") {
          this.todo = responseData.items[0]
        } else {
          alert(responseData.message)
        }
      })
  }
}
</script>