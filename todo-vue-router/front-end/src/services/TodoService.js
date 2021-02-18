import http from '../http-common'

class TodoService {
  getTodos() {
    return http.get(`/todos`)
  }
  getTodo(id) {
    return http.get(`/todos/${id}`)
  }
  deleteTodo(id) {
    return http.delete(`/todos/${id}`)
  }
}

export default new TodoService()