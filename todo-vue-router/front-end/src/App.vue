<template>
  <div id="app">
    <!-- Navbar.vue 컴포넌트 -->
    <nav-bar/>
    <!-- 요청 URL에 맞는 컴포넌트가 위치하는 곳 -->
    <router-view />
  </div>
</template>

<script>
// 부트스트랩 스타일을 포함시킨다.
import 'bootstrap/dist/css/bootstrap.css'
// NavBar.vue 컴포넌트를 사용하기 위해서 import 했다.
import NavBar from './components/common/NavBar'

// 이 컴포넌트를 App라는 이름으로 외부에 노출시킨다.
export default {
  name: 'App',
  components: { // 이 컴포넌트에서 사용하는 자식 컴포넌트를 지정한다.
    'nav-bar': NavBar
  }
}
</script>
