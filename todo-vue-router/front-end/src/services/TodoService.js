import http from '../http-common'

class TodoService {
  // 모든 Todo정보를 조회한다.
  getTodos() {
    return http.get(`/todos`)
  }
  // 지정된 id에 해당하는 Todo정보를 조회한다.
  getTodo(id) {
    return http.get(`/todos/${id}`)
  }
  // 지정된 id에 해당하는 Todo정보를 삭제한다.
  updateTodoStatus(id, status) {
    return http.put(`/todos/${id}/${status}`)
  }
}

// 이 클래스로 만든 객체를 외부에 노출시킨다.
export default new TodoService()