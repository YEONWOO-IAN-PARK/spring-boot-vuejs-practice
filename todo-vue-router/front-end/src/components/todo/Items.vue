<template>
  <div class="row border mt-3 p-3">
    <!-- todos배열 요소의 갯수만큼 <item> 컴포넌트를 추가한다.
      item 컴포넌트에 todo를 순서대로 하나씩 전달한다. -->
    <item v-for='(todo, index) in todos' :key="index"
      :todo="todo"/>
  </div>
</template>
<script>
// 이 컴포넌트가 사용할 자식컴포넌트의 Item.vue를 import 한다.
import Item from './Item'

// 이 컴포넌트의 이름은  Items다.
// 이 컴포넌트는 부모컴포넌트로부터 전달받은 todos의 갯수만큼 <item> 태그를 추가한다.
export default {
  name: 'Items',
  props: ["todos"],
  components: {
    'item': Item
  }
}
</script>