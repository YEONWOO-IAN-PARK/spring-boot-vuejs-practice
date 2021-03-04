import Todo from '../api/Todo'

export default {
  fetchTodos({commit}) {
    Todo.getTodos()
      .then(response => {
        if (response.data.status == 'OK') {
          commit('setTodos', response.data.items)
          commit('setFilteredTodos')
        }
      }) 
  },
  changeFilteredTodos({commit}, status) {
    commit('setFilteredTodos', status)
  },
  fetchTodo({commit}, id) {
    return new Promise(function(resolve, reject) {
      Todo.getTodo(id)
        .then(response => {
          if (response.data.status == 'OK') {
            commit('setTodo', response.data.items[0])
            resolve()
          }
        })
        .catch(function() {
          reject()
        })
    })
  },
  changeTodoStatus({dispatch}, opt) {
    Todo.updateTodoStatus(opt.id, opt.status)
      .then((response) => {
        if (response.data.status == 'OK') {
          dispatch('fetchTodo', opt.id)
        }
      })
  },
  insertTodo({dispatch}, todo) {
    return new Promise(function(resolve, reject) {
      Todo.insertTodo(todo)
        .then(() => {
          dispatch('fetchTodos')
          resolve()
        })
        .catch(function() {
          reject()
        })
    })
  },
  updateTodo({dispatch}, todo) {
    return new Promise(function(resolve, reject) {
      Todo.updateTodo(todo)
        .then((response) => {
          if (response.data.status == 'OK') {
            dispatch('fetchTodo', todo.id)
            resolve()
          }
        })
        .catch(function() {
          reject()
        })
      })
  }
}