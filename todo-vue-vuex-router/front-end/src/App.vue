<template>
  <div id="app">
    <navbar/>
    <router-view />
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import Navbar from './components/common/Navbar'
import { mapActions } from 'vuex'

export default {
  name: 'App',
  methods: {
    ...mapActions([
      'fetchTodos'
    ])
  },
  created: function() {
    this.fetchTodos()
  },
  components: {
    Navbar
  }
}
</script>
