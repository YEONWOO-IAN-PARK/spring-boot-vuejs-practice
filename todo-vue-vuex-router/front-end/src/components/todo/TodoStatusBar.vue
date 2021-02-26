<template>
  <div class="row border mt-3">
    <div class="col-10 py-3 d-flex justify-content-between">
      <button class="btn btn-info" @click="filteringTodos()">
        전체 <span class="badge badge-light">{{getTodosCount}}</span>
      </button>
      <button class="btn btn-primary" @click="filteringTodos('REGISTERED')">
        등록 <span class="badge badge-light">{{getTodosCount}}</span>
      </button>
      <button class="btn btn-success" @click="filteringTodos('COMPLETED')">
        완료 <span class="badge badge-light">{{getTodosCount}}</span>
      </button>
      <button class="btn btn-secondary" @click="filteringTodos('DELAYED')">
        지연 <span class="badge badge-light">{{getTodosCount}}</span>
      </button>
      <button class="btn btn-danger" @click="filteringTodos('DELETED')">
        삭제 <span class="badge badge-light">{{getTodosCount}}</span>
      </button>
    </div>
    <div class="col-2 text-center py-3">
      <router-link :to="`/todos/form`" class="btn btn-outline-primary">새 일정추가</router-link>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex'

export default {

  name: 'TodoStatusBar',
  methods: {
    ...mapActions([
      'fetchTodos'
    ])
  },
  computed: {
    ...mapGetters([
      'getTodosCount'
    ])
  }
}
</script>