<template>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">Todo 상세정보</div>
                    <div class="card-body">
                        <table class="table table-bordered">
                            <colgroup>
                                <col width="10%"/>
                                <col width="40%"/>
                                <col width="10%"/>
                                <col width="40%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th>아이디</th>
                                    <td>{{todo.id}}</td>
                                    <th>상태</th>
                                    <td>{{todo.status}}</td>
                                </tr>
                                <tr>
                                    <th>제목</th>
                                    <td>{{todo.title}}</td>
                                    <th>작성자</th>
                                    <td>{{todo.username}}</td>
                                </tr>
                                <tr>
                                    <th>설명</th>
                                    <td colspan="3">{{todo.description}}</td>
                                </tr>
                                <tr>
                                    <th>예정일</th>
                                    <td>{{todo.dueDate}}</td>
                                    <th>완료일</th>
                                    <td>{{todo.completedDate}}</td>
                                </tr>
                                <tr>
                                    <th>지연기간</th>
                                    <td></td>
                                    <th>삭제일</th>
                                    <td>{{todo.deletedDate}}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer text-right">
                        <button :disabled="!disabledBtn(todo.status)"  class="btn btn-danger mr-3" @click="deleteTodo(todo.id)">삭제</button>
                        <button :disabled="!disabledBtn(todo.status)" class="btn btn-success">완료</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import TodoService from '../../services/TodoService'

export default {
    name: 'Detail',
    data() {
        return {
            todo: {}
        }
    },
    methods: {
        completeTodo: function() {

        },
        deleteTodo: function(id) {
            TodoService.deleteTodo(id)
                .then(response => {
                    console.log(response);
                    if (response.data.status == "OK") {
                        this.$router.push('/todos/list')
                    } else {
                        alert(response.data.message);
                    }
                })
        },
        disabledBtn: function(status) {
            return status == '등록' || status == '지연';
        }
    },
    created() {
       TodoService.getTodo(this.$route.params.id)
        .then(response => {
            var responseData = response.data
            if (responseData.status == "OK") {
                this.todo = responseData.items[0]
            }
        })
    }
}
</script>