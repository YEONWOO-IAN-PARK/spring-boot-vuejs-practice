<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <Router-link class="navbar-brand" to="/">Tutorials</Router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link class="nav-link" to="/tutorials">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/add">Add</router-link>
        </li>
      </div>
    </nav>
    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>
