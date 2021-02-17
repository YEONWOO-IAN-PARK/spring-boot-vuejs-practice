<template>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">Todo List</div>
                    <div class="card-body">
                        <table class="table">
                            <thead>
                                <th>id</th>
                                <th>title</th>
                                <th>date</th>
                                <th>status</th>
                            </thead>
                            <tbody>
                                <tr v-for="todo in todos" :key="todo.id">
                                    <td>{{todo.id}}</td>
                                    <td>{{todo.title}}</td>
                                    <td>{{todo.dueDate}}</td>
                                    <td>{{todo.status}}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import TodoService from '../services/TodoService'

export default {
    name: 'Home',
    data() {
        return {
            todos: []
        }
    },
    created() {
        TodoService.getTodos()
        .then((response) => {
          this.todos = response.data.items;
        })
    }
}
</script>