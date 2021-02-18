<template>
  <div id="app">
    <nav-bar/>
    <router-view></router-view>
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import NavBar from './components/common/NavBar'

export default {
  name: 'App',
  components: {
    'nav-bar': NavBar
  }
}
</script>
