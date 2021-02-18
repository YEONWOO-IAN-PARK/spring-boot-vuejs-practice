<template>
  <div class="container">
    <!-- 작업진행 상태를 표시하는 컴포넌트 -->
    <!-- 
        :todos="todos"
          :todos는 StatusBar 컴포넌트가 부모가 전달해준 데이터를 저장하는 변수명
          "todos"는 이 컴포넌트의 data중에서 todos에 저장된 데이터
     -->
    <status-bar :todos="todos" />
    <!-- 모든 작업목록을 표시하는 컴포넌트 -->
    <items :todos="todos" />
  </div>
</template>
<script>
// 이 컴포넌트에서 사용할 기능이 정의되어 있는 스크립트 파일을 import 한다.
import TodoService from '../../services/TodoService'
// 이 컴포넌트가 사용할 자식컴포넌트를 import 한다.
import StatusBar from './StatusBar'
import Items from './Items'

// 이 컴포넌트는 List라는 이름으로 외부에 노출된다.
export default {
  name: 'List',
  data() {  // 이 컴포넌트가 사용하는 데이터를 정의한다.
    return {
      todos: []
    }
  },
  components: {// 이 컴포넌트가 사용하는 자식컴포넌트를 정의한다. import문으로 포함시킨 컴포넌트
    'status-bar': StatusBar,
    'items': Items
  },
  created() {// 이 컴포넌트가 생성되고 난 후 실행할 작업을 정의한다.
    // 모든 Todo 작업일정을 서버로부터 조회해서 data의 todos에 저장하기
    TodoService.getTodos()
      .then(response => { // 성공적인 응답이 오면 .then() 메소드가 실행됨
        // response.data에는 {status:"상태값", rows:갯수, items:[데이터, 데이터], message:"메세지"}
        var responseData = response.data
        if (responseData.status == 'OK') {
          // 서버로부터 수신받은 [Todo, Todo, Todo, ...]를 data의 todos에 대입한다.
          this.todos = responseData.items
        }
      })
  }
}
</script>