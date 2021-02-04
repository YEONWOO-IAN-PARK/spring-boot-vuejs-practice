import axios from 'axios'

export default axios.create({
  baseURL: 'http://localhost/api',
  headers: {
    'Access-Control-Allow-origin': '*',
    'Content-type': 'application/json'
  }
})