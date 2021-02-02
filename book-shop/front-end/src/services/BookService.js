import http from '../http-common'

class BookService {
  getBooks(page, category) {
    category = category || -1
    return http.get(`/books?page=${page}&category=${category}`)
  }
  getRecentArrivalBooks() {
    return http.get(`/books?type=NEW`)
  }
  getBestsellerBooks() {
    return http.get(`/books?type=BEST`)
  }
  getBook(bookNo) {
    return http.get(`/books/${bookNo}`)
  }
}

export default new BookService()