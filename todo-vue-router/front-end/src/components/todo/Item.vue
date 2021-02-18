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
// 이 컴포넌트의 이름은 Item이다.
// 부모 컴포넌트로부터 전달받은 데이터를 todo에 대입한다.
export default {
    name: "Item",
    props: ["todo"],
    methods: {
        // 뱃지의 스타일의 변경하기 위한 메소드다.
        // 이 메소드가 반환하는 값은 {'badge-primary':true, 'badge-success':false, ..}
        // true인 것만 class에 추가된다.
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