<template>
  <div class="row border mt-3 py-3">
    <div class="col-12 d-flex justify-content-between">
      <button class="btn btn-info">
        전체 <span class="badge badge-light">{{totalCount}}</span>
      </button>
      <button class="btn btn-primary">
        등록 <span class="badge badge-light">{{registeredCount}}</span>
      </button>
      <button class="btn btn-success">
        완료 <span class="badge badge-light">{{completedCount}}</span>
      </button>
      <button class="btn btn-secondary">
        지연 <span class="badge badge-light">{{delayedCount}}</span>
      </button>
      <button class="btn btn-danger">
        삭제 <span class="badge badge-light">{{deletedCount}}</span>
      </button>
    </div>
  </div>
</template>
<script>
export default {
  name: 'StatusBar',
  props: ["todos"],
  methods: {
    countTodosByStatus: function(status) {
      return this.todos.filter(todo => todo.status == status).length
    }
  },
  computed: {
    totalCount: function() {
      return this.todos.length;
    },
    registeredCount: function() {
      return this.countTodosByStatus("등록")
    },
    completedCount: function () {
      return this.countTodosByStatus("완료")
    },
    delayedCount: function() {
      return this.countTodosByStatus("지연")
    },
    deletedCount: function () {
      return this.countTodosByStatus("삭제")
    }
  }
}
</script>