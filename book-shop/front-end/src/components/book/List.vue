<template>
  <div class="row mt-3">
    <div class="col-12">
      <div class="card">
        <div class="card-header">{{ title }}</div>
        <div class="card-body">
          <div class="row">
            <div class="col-3 mb-3"
              v-for="book in books"
              :key="book.no">
              <list-item :book="book" :current-page="page" :category="category"></list-item>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ListItem from './ListItem'

export default {
  name: 'List',
  props: ['title', 'books',  'page', 'category'],
  components: {
    'list-item': ListItem
  }
}
</script>

<style scoped>

</style>