<script setup>
import TodoListItem from '@/components/TodoListItem.vue'
import { useTodostore } from '@/stores/todo.js'

const store = useTodostore()
</script>

<template>
  <div>
    <h2>할일 목록</h2>
    <TodoListItem v-for="todo in store.todos" :key="todo.id" :todo="todo" />
  </div>
</template>

<style scoped></style>
