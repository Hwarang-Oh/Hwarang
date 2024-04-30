<script setup>
import { ref } from 'vue'

// give each todo a unique id
let id = 0

const newTodo = ref('')
const todos = ref([
  { id: id++, text: 'Learn HTML' },
  { id: id++, text: 'Learn JavaScript' },
  { id: id++, text: 'Learn Vue' }
])

function addTodo() {
  // ...
  newTodo.value = ''
}

function removeTodo(todo) {
  // ...
}
</script>

<template>
  <div>
    <ul>
      <li v-for="each in todos" :key="each.id">
        {{ each.text }}
      </li>
    </ul>
  </div>
</template>

<style scoped></style>
