<template>
  <div>
    <div v-if="result.status == 'fail'"  class="row">
      <div class="col-6 offset-3">
        <div class="alert alert-danger">
          <strong>로그인 실패</strong> 아이디 혹은 비밀번호가 올바르지 않습니다.
        </div>
      </div>
    </div>
    <div v-if="result.status == 'deny'" class="row">
      <div class="col-6 offset-3">
        <div class="alert alert-success">
          <strong>접근 거부</strong> 로그인 한 사용자만 이용할 수 있는 서비스입니다.
        </div>
      </div>
    </div>
    <div class="row">
      <div  class="col-6 offset-3">
        <div class="card">
          <div class="card-header">로그인 폼</div>
          <div class="card-body px-5">
            <div class="form-group">
              <label>아이디</label>
              <input type="text" class="form-control" v-model="user.id">
            </div>
            <div class="form-group">
              <label>비밀번호</label>
              <input type="password" class="form-control" v-model="user.password">
            </div>
            <div class="form-group  text-right">
              <button class="btn btn-primary" :disabled="disabledBtn" @click="login">로그인</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
//import UserService from '../../services/UserService'

export default {
  name: "LoginForm",
  data: function() {
    return {
      result: {},
      user: {
        id: '',
        password: '',
      }
    }
  },
  methods: {
    resetField: function() {
      this.user = {id:'', password:''}
    },
    login: function() {
      
    }
  },
  computed: {
    disabledBtn: function() {
      if (!this.user.id || !this.user.password) {
        return true;
      }
      
      return false;
    }
  },
  created: function() {
    this.resetField();
  }
}
</script>