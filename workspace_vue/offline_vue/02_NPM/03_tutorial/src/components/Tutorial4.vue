<script setup>
import { ref } from 'vue'
const count = ref(0)
const changeUp = () => {
  count.value++
}
const changeDown = () => {
  count.value--
}
</script>

<template>
  <div>
    <h1>{{ count }}</h1>
    <!-- add dynamic class binding here -->
    <button @click="changeUp">증가</button>
    <button @click="changeDown">감소</button>
  </div>
</template>

<style scoped></style>
