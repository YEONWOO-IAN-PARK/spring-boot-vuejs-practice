<template>
  <nav class="navbar navbar-expand-sm bg-success navbar-dark">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <router-link class="nav-link" href="/">홈</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" href="/board/list">게시판</router-link>
      </li>
    </ul>
  </nav>
</template>
<script>
export default {
  name: "NavBar"
}
</script>