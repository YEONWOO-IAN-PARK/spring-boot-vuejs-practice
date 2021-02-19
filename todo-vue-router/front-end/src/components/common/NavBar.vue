<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark my-3">
		<router-link :to="'/'" class="navbar-brand">Todo 애플리케이션</router-link>
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <router-link :to="`/`" class="nav-link">홈</router-link>
      </li>
      <li class="nav-item">
        <router-link :to="`/todos/list`" class="nav-link">Todos</router-link>
      </li>
    </ul>
	</nav>
</template>
<script>
export default {
  name: 'NavBar'
}
</script>