import Vue from 'vue'
import Vuex from 'vuex'
import Todo from '../api/Todo'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    todos: [],
    filteredTodos: []
  },
  getters: {
  }, 
  actions: {
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
    }
  },
  mutations: {
    setTodos(state, todos) {
      state.todos = todos
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
})