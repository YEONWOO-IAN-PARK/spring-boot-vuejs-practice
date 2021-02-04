import http from '../http-common'

class UserService {
  addUser(user) {
    return http.post('/users', user)
  }
}

export default new UserService()