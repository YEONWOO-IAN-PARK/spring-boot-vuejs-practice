import http from '../http-common'

class BookService {
  getBooks() {
    return http.get(`/books`)
  }
}

export default new BookService()