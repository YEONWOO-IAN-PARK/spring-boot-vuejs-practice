<template>
    <div class="col-3 mb-3">
        <div class="card shadow">
            <div class="card-header">
                {{todo.title}}
                <span class="float-right badge" :class="badgeStyle(todo.status)">{{todo.status}}</span>
            </div>
            <div class="card-body">
                <p class="card-text"><strong>작성자 : </strong>{{todo.username}}</p>
                <p class="card-text"><strong>예정일자 : </strong>{{todo.dueDate}}</p>
                <div>
                    <router-link :to="`/todos/detail/${todo.id}`" class="btn btn-outline-primary btn-sm">상세정보</router-link>
                </div>  
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name: "Item",
    props: ["todo"],
    methods: {
        badgeStyle: function(status) {
            return {
                'badge-primary': status == '등록',
                'badge-success': status == '완료',
                'badge-secondary': status == '지연',
                'badge-danger': status == '삭제'
            }
        }
    }
}
</script>