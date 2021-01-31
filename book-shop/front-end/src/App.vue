<template>
  <div id="app">
    <div class="container">
      <nav-bar></nav-bar>
      <router-view />
    </div>
  </div>
</template>
<script>
import NavBar from './components/common/NavBar'
export default {
  name: 'App',
  components: {
    'nav-bar': NavBar
  }
}
</script>

<style>
</style>
