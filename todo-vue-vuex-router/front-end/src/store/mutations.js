import {FETCH_TODOS} from './mutations-types'
export default {
  [FETCH_TODOS] (state, payload) {
    state.todos = payload
  }
}