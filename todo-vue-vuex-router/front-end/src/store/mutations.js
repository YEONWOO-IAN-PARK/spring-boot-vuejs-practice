export default {
  setTodos(state, todos) {
    state.todos = todos
  },
  setTodo(state, todo) {
    state.todo = todo
  },
  setFilteredTodos(state, status) {
    state.filteredTodos = state.todos.filter(todo => {
      if (status) {
        return todo.status == status
      }
      return true
    })
  } 
}