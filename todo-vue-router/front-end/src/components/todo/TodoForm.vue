<template>
  <div class="card">
    <div class="card-header">{{formTitle}}</div>
    <div class="card-body">
      <form>
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
          <button type="button" class="btn btn-primary">수정</button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  name: 'TodoForm',
  props: ['formTitle', 'todo']
}
</script>