<template>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-header">Todo 상세정보</div>
          <div class="card-body">
            <table class="table table-bordered">
              <colgroup>
                <col width="10%"/>
                <col width="40%"/>
                <col width="10%"/>
                <col width="40%"/>
              </colgroup>
              <tbody>
                <tr>
                  <th>아이디</th>
                  <td>{{todo.id}}</td>
                  <th>상태</th>
                  <td>{{todo.status | statusToLocaleString}}</td>
                </tr>
                <tr>
                  <th>제목</th>
                  <td>{{todo.title}}</td>
                  <th>작성자</th>
                  <td>{{todo.username}}</td>
                </tr>
                <tr>
                  <th>설명</th>
                  <td colspan="3">{{todo.description}}</td>
                </tr>
                <tr>
                  <th>예정일</th>
                  <td>{{todo.dueDate}}</td>
                  <th>완료일</th>
                  <td>{{todo.completedDate}}</td>
                </tr>
                <tr>
                  <th>지연기간</th>
                  <td><span v-show="todo.status == 'DELAYED'">{{todo.delayedDays}} 일</span></td>
                  <th>삭제일</th>
                  <td>{{todo.deletedDate}}</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="card-footer">
            <router-link :to="`/todos/modify/${todo.id}`" v-show="showBtn()" class="btn btn-warning mr-3">수정하기</router-link>
            <button v-show="showBtn()"  class="btn btn-danger mr-3" @click="changeTodoStatus('DELETED')">삭제하기</button>
            <button v-show="showBtn()" class="btn btn-success" @click="changeTodoStatus('COMPLETED')">완료하기</button>
            <router-link :to="`/todos/list`" class="btn btn-primary float-right">목록보기</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import {mapState} from 'vuex'

export default {
  methods: {
    showBtn: function() {
      return this.todo.status == 'REGISTERED' || this.todo.status == 'DELAYED';
    },
    changeTodoStatus(status) {
      this.$store.dispatch('changeTodoStatus', this.todo.id, status)
      .then(() => {
        
      })
    }
  },
  computed: {
    ...mapState([
      'todo'
    ])
  },
  filters: {
    statusToLocaleString: function(status) {
      if (status == 'REGISTERED') return '등록'
      if (status == 'COMPLETED') return '완료'
      if (status == 'DELAYED') return '지연'
      if (status == 'DELETED') return '삭제'
    }
  }
}
</script>