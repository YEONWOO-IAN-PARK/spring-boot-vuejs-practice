<template>
  <nav>
    <ul class="pagination justify-content-center">
      <li class="page-item" :class="{disabled: currentPage == 1}">
        <a class="page-link" href="#" tabindex="-1">Previous</a>
      </li>
      <li class="page-item"
        v-for="num in pageRange"
        :key="num"
        :class="{active: num == currentPage}">
        <a class="page-link"
          @click="move(num)">{{ num }}</a>
      </li>
      <li class="page-item" :class="{disabled: currentPage == totalPages}">
        <a class="page-link" href="#">Next</a>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: 'Pagination',
  props: ["pageRange", 'currentPage', 'totalPages'],
  methods: {
    move: function(num) {
      console.log(num);
    }
  }
}
</script>