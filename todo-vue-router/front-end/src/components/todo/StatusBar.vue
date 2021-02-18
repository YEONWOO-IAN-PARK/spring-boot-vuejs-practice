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
// 이 컴포넌트의 이름은 StatusBar다.
// 이 컴포넌트는 부모컴포넌트로부터 todos를 전달받아서 진행상태별로 구분해서 수량을 표시하는 컴포넌트다.
export default {
  name: 'StatusBar',
  // 부모컴포넌트로부터 전달받은 데이터를 담는 변수의 이름의 todos다.
  props: ["todos"],
  methods: {
    // 전달받은 상태값에 해당하는 Todo의 갯수를 반환하는 함수
    countTodosByStatus: function(status) {
      return this.todos.filter(todo => todo.status == status).length
    }
  },
  computed: {
    // 전체 갯수
    totalCount: function() {
      return this.todos.length;
    },
    // 등록된 갯수
    registeredCount: function() {
      return this.countTodosByStatus("등록")
    },
    // 완료된 갯수
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