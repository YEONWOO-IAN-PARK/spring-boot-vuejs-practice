import Vue from 'vue'
import Vuex from 'vuex'
import Todo from '../api/Todo'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    todo: {},
    todos: [],
    filteredTodos: []
  },
  getters: {
    todosCountByStatus: (state) => (status) => {	
      if (status) {	
        return state.todos.filter(todo => todo.status == status).length	
      }	
      return state.todos.length	
    }
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
    }
  },
  mutations: {
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
})