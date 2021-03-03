<template>
  <div class="col-3 mb-3">
    <div class="card shadow">
      <div class="card-header"> {{todo.title}}</div>
        <div class="card-body">
          <p class="card-text"><strong>작성자 : </strong>{{todo.username}}</p>
          <p class="card-text"><strong>예정일자 : </strong>{{todo.dueDate}}</p>
          <div>
            <span class="badge p-2" :class="badgeStyle(todo.status)">{{todo.status }}</span>
            <router-link :to='`/todos/detail/${todo.id}`' class="btn btn-outline-primary btn-sm float-right">상세정보</router-link>
          </div>  
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: ["todo"],
  methods: {
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