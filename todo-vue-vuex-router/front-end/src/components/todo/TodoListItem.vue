<template>
  <div class="col-3 mb-3">
    <div class="card shadow">
      <div class="card-header"> {{todo.title}}</div>
        <div class="card-body">
          <p class="card-text"><strong>작성자 : </strong>{{todo.username}}</p>
          <p class="card-text"><strong>예정일자 : </strong>{{todo.dueDate}}</p>
          <div>
            <span class="badge p-2" :class="badgeStyle(todo.status)">{{todo.status }}</span>
            <button @click="viewDetail()" class="btn btn-outline-primary btn-sm float-right">상세정보</button>
          </div>  
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: ["todo"],
  methods: {
    viewDetail: function() {
      this.$store.dispatch('fetchTodo', this.todo.id)
      .then(() => {
        this.$router.push(`/todos/detail/${this.todo.id}`)
      })
    },
    badgeStyle: function(status) {
      return {
        'badge-primary': status == 'REGISTERED',
        'badge-success': status == 'COMPLETED',
        'badge-secondary': status == 'DELAYED',
        'badge-danger': status == 'DELETED'
      }
    }
  }
}
</script>