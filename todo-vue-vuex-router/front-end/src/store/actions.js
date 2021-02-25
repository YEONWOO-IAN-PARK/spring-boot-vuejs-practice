import {FETCH_TODOS} from './mutations-types'
import TodoService from '../services/TodoService'

export function fetchTodos ({commit}) {
  TodoService.getTodos()
    .then(response => {
      if (response.data.status == 'OK') {
        commit(FETCH_TODOS, response.data.items)
      }
    })  
}

export default {
  fetchTodos
}