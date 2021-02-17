<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark my-3">
		<router-link :to="'/home'" class="navbar-brand">Todo App</router-link>
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <router-link :to="`/home`" class="nav-link">Home</router-link>
      </li>
    </ul>
	</nav>
</template>
<script>
export default {
  name: 'NavBar'
}
</script>