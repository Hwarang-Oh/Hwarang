<script setup>
import { ref } from 'vue'

// 각 할 일에 고유한 ID 부여
let id = 0

// const newTodo = ref('')
const todos = ref([
  { id: id++, text: 'HTML 배우기' },
  { id: id++, text: 'JavaScript 배우기' },
  { id: id++, text: 'Vue 배우기' }
])
const newTodo = ref('')

const addTodo = () => {
  todos.value.push({ id: id++, text: newTodo.value })
  newTodo.value = ''
}

const removeTodo = (todo) => {
  todos.value = todos.value.filter((item) => item != todo)

  // for (let index = 0; index < todos.value.length; index++) {
  //     const item = todos.value[index];
  //     if(item == todo){
  //         todos.value.splice(index,1) // index 위치로부터 1개 짤라내라
  //         break;
  //     }

  // }
}
</script>

<template>
  <form @submit.prevent="addTodo">
    <input input type="text" v-model="newTodo" />
    <button>할 일 추가</button>
  </form>

  <ul>
    <li v-for="todo in todos" :key="todo.id">
      {{ todo.text }}
      <button @click="removeTodo(todo)">X</button>
    </li>
  </ul>
</template>

<style scoped></style>
