<script setup>
import { ref, computed } from 'vue'

// 각 할 일에 고유한 ID 부여
let id = 0

// const newTodo = ref('')
const todos = ref([
  { id: id++, text: 'HTML 배우기', done: true },
  { id: id++, text: 'JavaScript 배우기', done: true },
  { id: id++, text: 'Vue 배우기', done: false }
])
const newTodo = ref('')

const addTodo = () => {
  todos.value.push({
    id: id++,
    text: newTodo.value,
    done: false
  })
  newTodo.value = ''
}

const removeTodo = (todo) => {
  todos.value = todos.value.filter((item) => item != todo)
}

const hideComplete = ref(false)

const filteredTodos = computed(() =>
  hideComplete.value ? todos.value.filter((item) => !item.done) : todos.value
)
</script>

<template>
  <form @submit.prevent="addTodo">
    <input input type="text" v-model="newTodo" />
    <button>할 일 추가</button>
  </form>

  <ul>
    <li v-for="todo in filteredTodos" :key="todo.id">
      <input type="checkbox" v-model="todo.done" />
      <span :class="{ done: todo.done }">{{ todo.text }}</span>
      <button @click="removeTodo(todo)">X</button>
    </li>
  </ul>
  <button @click="hideComplete = !hideComplete">
    {{ hideComplete ? 'Show Completed' : 'Hide Completed' }}
  </button>
</template>

<style scoped>
.done {
  text-decoration: line-through;
}
</style>
