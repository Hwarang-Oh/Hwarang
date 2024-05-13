<script setup>
import { ref } from 'vue'

const todoText = ref('')
</script>

<template>
  <div>
    <form @submit.prevent="addtodo()">
      <input type="text" v-model="todoText" />
      <button type="submit">추가</button>
    </form>
  </div>
</template>

<style scoped></style>
