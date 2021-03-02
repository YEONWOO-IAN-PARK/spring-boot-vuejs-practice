import Vue from 'vue'
import Vuex from 'vuex'
import Todo from '../api/Todo'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    todos: []
  },
  getters: {

  }, 
  actions: {
    fetchTodos({commit}) {
      Todo.getTodos()
        .then(response => {
          if (response.data.status == 'OK') {
            commit('setTodos', response.data.itme)
          }
        })
    }
  },
  mutations: {
    setTodos(state, todos) {
      state.todos = todos
    }
  }
})