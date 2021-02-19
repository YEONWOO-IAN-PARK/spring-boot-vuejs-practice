<template>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <todo-form :formTitle="formTitle" :todo="todo"/>
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
  },
  components: {
    'todo-form': TodoForm
  }
}
</script>