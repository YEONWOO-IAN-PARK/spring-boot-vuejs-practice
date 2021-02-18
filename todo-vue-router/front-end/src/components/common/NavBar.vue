<template>
  <!-- -->
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark my-3">
    <!-- 
      <router-link>가 <a> 태그의 역할을 수행한다. 
        :to="링크주소"
    -->
		<router-link :to="'/home'" class="navbar-brand">Todo 애플리케이션</router-link>
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <router-link :to="`/home`" class="nav-link">홈</router-link>
      </li>
      <li class="nav-item">
        <router-link :to="`/todos/list`" class="nav-link">Todos</router-link>
      </li>
    </ul>
	</nav>
</template>
<script>
// 이 컴포넌트를 NavBar라는 이름으로 노출시킨다.
export default {
  name: 'NavBar'
}
</script>