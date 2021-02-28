import {FETCH_TODOS, UPDATE_FILTERED_TODOS} from './mutations-types'
import TodoService from '../services/TodoService'

export default {
  fetchTodos: function({commit}) {
    TodoService.getTodos()
      .then(response => {
        if (response.data.status == 'OK') {
          commit(FETCH_TODOS, response.data.items)
        }
      })  
  },
  updateFilteredTodos: function({commit}, status) {
    commit(UPDATE_FILTERED_TODOS, status)
  },
  insertTodo: function({commit}, todo) {
    TodoService.insertTodo(todo)
      .then(response => {
        if (response.data.status == 'OK') {
          commit(FETCH_TODOS, response.data.items)
        }
      })
  }
}

