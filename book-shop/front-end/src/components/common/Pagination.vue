<template>
  <nav class="mt-3">
    <ul class="pagination justify-content-center">
      <li class="page-item" :class="{disabled: page == 1}">
        <a class="page-link" @click="move(page - 1)">Previous</a>
      </li>
      <li class="page-item"
        v-for="num in pageRange"
        :key="num"
        :class="{active: num == page}">
        <a class="page-link"
          @click="move(num)">{{ num }}</a>
      </li>
      <li class="page-item" :class="{disabled: page == totalPages}">
        <a class="page-link" @click="move(page + 1)">Next</a>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: 'Pagination',
  props: ["pageRange", 'page', 'totalPages'],
  methods: {
    move: function(num) {
      this.$emit("move", num);
    }
  }
}
</script>