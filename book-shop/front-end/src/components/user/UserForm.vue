<template>
  <div class="row">
    <div class="col-12">
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
              <button class="btn btn-primary">가입</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserForm",
  data: function() {
    return {
      user: {
        name: '',
        id: '',
        password: '',
        confirmPassword: '',
        tel: '',
        email: ''
      }
    }
  }
}
</script>