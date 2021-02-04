<template>
  <div>
    <div  v-if="result.status == 'fail'"  class="row">
      <div class="col-12">
        <div class="alert alert-danger">
          <strong>회원가입 실패</strong> 이미 사용중인 아이디입니다. 
        </div>
      </div>
    </div>
    <div v-if="result.status == 'ok'" class="row">
      <div class="col-12">
        <div class="alert alert-success">
          <strong>회원가입 완료</strong> 회원가입이 완료되었습니다. 
        </div>
      </div>
    </div>
    <div v-show="result.status != 'ok'" class="row">
      <div  class="col-12">
        <div class="card">
          <div class="card-header">회원가입 폼</div>
          <div class="card-body px-5">
            <div class="form-row">
              <div class="form-group col-6">
                <label>이름</label>
                <input type="text" class="form-control" v-model="user.name">
              </div>
              <div class="form-group col-6">
                <label>아이디</label>
                <input type="text" class="form-control" v-model="user.id">
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-6">
                <label>비밀번호</label>
                <input type="password" class="form-control" v-model="user.password">
              </div>
              <div class="form-group col-6">
                <label>비밀번호 확인</label>
                <input type="password" class="form-control" v-model="user.confirmPassword">
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-6">
                <label>전화번호</label>
                <input type="text" class="form-control" v-model="user.tel">
              </div>
              <div class="form-group col-6">
                <label>이메일</label>
                <input type="email" class="form-control" v-model="user.email">
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-12 text-right">
                <button class="btn btn-primary" :disabled="disabledBtn" @click="addUser">가입</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import UserService from '../../services/UserService'

export default {
  name: "UserForm",
  data: function() {
    return {
      result: {},
      user: {
        name: '',
        id: '',
        password: '',
        confirmPassword: '',
        tel: '',
        email: ''
      }
    }
  },
  methods: {
    resetField: function() {
      this.user = {name:'', id:'', password:'', confirmPassword:'', tel:'', email:''}
    },
    addUser: function() {
      UserService.addUser(this.user)
        .then(response => {
          this.result = response.data;
          this.resetField();
        })
    }
  },
  computed: {
    disabledBtn: function() {
      if (!this.user.name || !this.user.id || !this.user.password || !this.user.confirmPassword || !this.user.tel || !this.user.email) {
        return true;
      }
      if (!/^[가-힣]{2,4}$/.test(this.user.name)) {
        return true
      }
      if (this.user.password != this.user.confirmPassword) {
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