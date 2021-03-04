<template>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <todo-form :formTitle="formTitle" :todo="todo" :callback="updateTodo"/>
      </div>
    </div>
  </div>
</template>
<script>
import {mapState} from 'vuex'
import TodoForm from './TodoForm'

export default {
  data() {
    return {
      formTitle: 'Todo 정보 수정'
    }
  },
  methods: {
    updateTodo: function(todo) {
      this.$store.dispatch('updateTodo', todo)
      .then(() => {
        this.$router.push(`/todos/detail/${todo.id}`)
      })
    }
  },
  computed: {
    ...mapState([
      'todo'
    ])
  },
  components: {
    'todo-form': TodoForm
  },
  created() {
    this.$store.dispatch('fetchTodo', this.$route.params.id)
  },
}
</script>