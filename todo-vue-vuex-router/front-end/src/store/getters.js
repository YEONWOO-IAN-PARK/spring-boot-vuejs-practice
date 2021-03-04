export default {
  todosCountByStatus: (state) => (status) => {	
    if (status) {	
      return state.todos.filter(todo => todo.status == status).length	
    }	
    return state.todos.length	
  }
}