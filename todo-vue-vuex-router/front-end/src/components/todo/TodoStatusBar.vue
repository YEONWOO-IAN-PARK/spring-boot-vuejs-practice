<template>
  <div class="row border mt-3">
    <div class="col-10 py-3 d-flex justify-content-between">
      <button class="btn btn-info" @click="updateFilteredTodos()">
        전체 <span class="badge badge-light">{{todosCountByStatus()}}</span>
      </button>
      <button class="btn btn-primary" @click="updateFilteredTodos('REGISTERED')">
        등록 <span class="badge badge-light">{{todosCountByStatus('REGISTERED')}}</span>
      </button>
      <button class="btn btn-success" @click="updateFilteredTodos('COMPLETED')">
        완료 <span class="badge badge-light">{{todosCountByStatus('COMPLETED')}}</span>
      </button>
      <button class="btn btn-secondary" @click="updateFilteredTodos('DELAYED')">
        지연 <span class="badge badge-light">{{todosCountByStatus('DELAYED')}}</span>
      </button>
      <button class="btn btn-danger" @click="updateFilteredTodos('DELETED')">
        삭제 <span class="badge badge-light">{{todosCountByStatus('DELETED')}}</span>
      </button>
    </div>
    <div class="col-2 text-center py-3">
      <router-link :to="`/todos/form`" class="btn btn-outline-primary">새 일정추가</router-link>
    </div>
  </div>
</template>
<script>
import {mapGetters} from 'vuex'
export default {
  methods: {
    updateFilteredTodos(status) {
      this.$emit('updatefilteredTodos', status)
    }
  },
  computed: {
    ...mapGetters([
      'todosCountByStatus'
    ])
  }
}
</script>