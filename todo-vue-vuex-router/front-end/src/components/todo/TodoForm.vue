<template>
  <div class="card">
    <div class="card-header">{{formTitle}}</div>
    <div class="card-body">
      <form novalidate @submit.prevent="insertOrUpdateTodo">
        <div class="form-row">
          <div class="form-group col-6">
            <label>작성자</label>
            <input type="text" class="form-control" v-model="todo.username">
          </div>
          <div class="form-group col-6">
            <label>예정일자</label>
            <input type="date" class="form-control" v-model="todo.dueDate">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-12">
            <label>제목</label>
            <input type="text" class="form-control" v-model="todo.title">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-12">
            <label>설명</label>
            <textarea rows="5" class="form-control" v-model="todo.description"></textarea>
          </div>
        </div>
        <div class="text-right">
          <router-link :to="`/todos/detail/${todo.id}`" class="btn btn-secondary mr-3">취소</router-link>
          <button type="submit" class="btn btn-primary" >완료</button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  props: ['formTitle', 'todo', ],
  methods: {
    insertOrUpdateTodo: function() {
      if (!this.todo.username || !this.todo.dueDate || !this.todo.title || !this.todo.description) {
        alert('입력값이 누락되었습니다.');
        return false
      }
      //this.callback(this.todo);
    }
  }
}
</script>