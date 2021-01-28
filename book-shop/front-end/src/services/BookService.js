import http from '../http-common'

class BookService {
  getBooks(page) {
    page = page || 1
    return http.get(`/books?page=${page}`)
  }
  getBook(bookNo) {
    return http.get(`/books/${bookNo}`)
  }
}

export default new BookService()