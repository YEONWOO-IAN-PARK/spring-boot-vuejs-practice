<template>
  <div class="row border mt-3 py-3">
    <div class="col-12 d-flex justify-content-between">
      <button class="btn btn-info">
        Total <span class="badge badge-light">{{totalCount}}</span>
      </button>
      <button class="btn btn-primary">
        Registered <span class="badge badge-light">{{registeredCount}}</span>
      </button>
      <button class="btn btn-success">
        Completed <span class="badge badge-light">{{completedCount}}</span>
      </button>
      <button class="btn btn-secondary">
        Delayed <span class="badge badge-light">{{delayedCount}}</span>
      </button>
      <button class="btn btn-danger">
        Deleted <span class="badge badge-light">{{deletedCount}}</span>
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