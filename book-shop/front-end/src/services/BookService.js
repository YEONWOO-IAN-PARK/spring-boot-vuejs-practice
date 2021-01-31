import http from '../http-common'

class BookService {
  getBooks(page, category) {
    category = category || -1
    return http.get(`/books?page=${page}&category=${category}`)
  }
  getBook(bookNo) {
    return http.get(`/books/${bookNo}`)
  }
}

export default new BookService()