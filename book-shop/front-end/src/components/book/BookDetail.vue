<template>
  <div class="row mb-3">
    <div class="col-12 mb-3">
      <div class="card">
          <div class="row">
            <div class="col-md-3">
                <!-- <img src="../resources/images/.jpg" class="card-img" alt="..."> -->
            </div>
            <div class="col-md-9">
                <div class="card-body">
                  <h5 class="card-title">{{ book.title }}</h5>
                  <form id="book-form" method="get" action="../order/form.hta">
                    <input type="hidden" name="bookno" value="" />
                    <table class="table">
                      <colgroup>
                        <col width="18%">
                        <col width="32%">
                        <col width="18%">
                        <col width="32%">
                      </colgroup>
                      <tbody>
                        <tr>
                          <th>저자</th>
                          <td>{{ book.writer }}</td>
                          <th>역자</th>
                          <td>{{ book.translator }}</td>
                        </tr>
                        <tr>
                          <th>출판사</th>
                          <td>{{ book.publisher }}</td>
                          <th>출판일</th>
                          <td>{{ book.pubDate | formatDate }}</td>
                        </tr>
                        <tr>
                          <th>카테고리</th>
                          <td></td>
                          <th>재고현황</th>
                          <td>{{ book.stock | formatNumber }} 권</td>
                          
                        </tr>
                        <tr>
                          <th>정가</th>
                          <td>{{ book.price | currency }} 원</td>
                          <th>상태</th>
                          <td>{{ book.status }}</td>
                        </tr>
                        <tr>
                          <th>판매가</th>
                          <td><strong  class="text-danger">{{ book.salePrice | currency }} 원</strong> <small>({{ book.discountRate | percent }}%할인)</small></td>
                          <th>포인트</th>
                          <td><span class="text-danger">{{ book.savePoint | currency }}원</span> 적립</td>
                        </tr>
                        <tr>
                          <th>평점</th>
                          <td><strong class="text-danger"></strong> 점</td>
                          <th>사용자 리뷰</th>
                          <td>{{ book.reviewCount | formatNumber }} 개</td>
                        </tr>
                        <tr>
                          <th>구매수량</th>
                          <td><input type="number" class="form-control" name="amount" value="1" style="width: 100px;"></td>
                          <td colspan="2" class="text-right">
                            <button type="button" class="btn btn-primary btn-sm mr-2" onclick="buy()">바로구매</button>
                            <button type="button" class="btn btn-info btn-sm mr-2" onclick="addCartItem()">장바구니</button>
                            <router-link :to="'/book/list/'+page" class="btn btn-outline-primary btn-sm">쇼핑계속</router-link>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </form>
                </div>
            </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import '../../filters/commonFilters'
import BookService from "../../services/BookService"

export default {
  name: 'BookDetail',
  data() {
    return {
      page:1,
      book: {}
    }
  },
  mounted() {
    this.page = this.$route.params.page;
    BookService.getBook(this.$route.params.no)
      .then(response => {
        this.book = response.data.items[0];
        console.log(response.data)
      })
  }
}
</script>