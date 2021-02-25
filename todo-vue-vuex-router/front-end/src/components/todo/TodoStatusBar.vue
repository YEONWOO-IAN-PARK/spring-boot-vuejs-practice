<template>
  <div class="row border mt-3">
    <div class="col-10 py-3 d-flex justify-content-between">
      <button class="btn btn-info" @click="filteringTodos()">
        전체 <span class="badge badge-light">{{totalCount}}</span>
      </button>
      <button class="btn btn-primary" @click="filteringTodos('REGISTERED')">
        등록 <span class="badge badge-light">{{registeredCount}}</span>
      </button>
      <button class="btn btn-success" @click="filteringTodos('COMPLETED')">
        완료 <span class="badge badge-light">{{completedCount}}</span>
      </button>
      <button class="btn btn-secondary" @click="filteringTodos('DELAYED')">
        지연 <span class="badge badge-light">{{delayedCount}}</span>
      </button>
      <button class="btn btn-danger" @click="filteringTodos('DELETED')">
        삭제 <span class="badge badge-light">{{deletedCount}}</span>
      </button>
    </div>
    <div class="col-2 text-center py-3">
      <router-link :to="`/todos/form`" class="btn btn-outline-primary">새 일정추가</router-link>
    </div>
  </div>
</template>
<script>
import { mapState } from '../../store/states'

export default {

  name: 'TodoStatusBar',
  methods: {
    countTodosByStatus: function(status) {
      return this.todos.filter(todo => todo.status == status).length
    }
  },
  computed: {
    ...mapState([
      'todos'
    ]),
    totalCount: function() {
      return this.todos.length;
    },
    registeredCount: function() {
      return this.countTodosByStatus("REGISTERED")
    },
    completedCount: function () {
      return this.countTodosByStatus("COMPLETED")
    },
    delayedCount: function() {
      return this.countTodosByStatus("DELAYED")
    },
    deletedCount: function () {
      return this.countTodosByStatus("DELETED")
    }
  }
}
</script>