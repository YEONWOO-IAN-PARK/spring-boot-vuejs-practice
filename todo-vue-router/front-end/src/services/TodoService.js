import http from '../http-common'

class TodoService {
  insertTodo(todo) {
    return http.post(`/todos`, todo)
  }
  getTodos() {
    return http.get(`/todos`)
  }
  getTodo(id) {
    return http.get(`/todos/${id}`)
  }
  updateTodoStatus(id, status) {
    return http.put(`/todos/${id}/${status}`)
  }
  updateTodo(todo) {
    return http.put(`/todos/${todo.id}`, todo)
  }
}

export default new TodoService()