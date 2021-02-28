<template>
  <div id="app">
    <navbar />
    <router-view />
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import Navbar from './components/common/Navbar'

export default {
  name: 'App',
  components: {
    Navbar
  }
}
</script>
