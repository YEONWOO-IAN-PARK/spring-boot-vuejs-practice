import {FETCH_TODOS, UPDATE_FILTERED_TODOS} from './mutations-types'

export default {
  [FETCH_TODOS] (state, todos) {
    state.todos = todos
    state.filteredTodos = todos
  }, 
  [UPDATE_FILTERED_TODOS] (state, status) {
    state.filteredTodos = []
      state.todos.filter(todo => {
        if (status) {
          return todo.status == status
        }
        return true
      }).forEach(todo => state.filteredTodos.push(todo))
  }
}