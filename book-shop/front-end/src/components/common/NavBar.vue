<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark my-3">
		<router-link :to="'/home'" class="navbar-brand">Book Shop</router-link>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsible-navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsible-navbar">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">
					<router-link :to="`/home`" class="nav-link">홈</router-link>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="navbardrop-1" data-toggle="dropdown">카테고리</a>
					<div class="dropdown-menu">
						<router-link :to="`/book/list/1`" class="dropdown-item">전체</router-link>
						<router-link :to="`/book/list/1/100`" class="dropdown-item">국내도서</router-link>
						<router-link :to="`/book/list/1/200`" class="dropdown-item">외국도서</router-link>
						<router-link :to="`/book/list/1/300`" class="dropdown-item">전자책</router-link>
					</div>
				</li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item">
					<router-link :to="`/user/form`" class="nav-link">회원가입</router-link>
				</li>
			</ul>
		</div>
	</nav>
</template>
<script>
export default {
  name: 'NavBar'
}
</script>