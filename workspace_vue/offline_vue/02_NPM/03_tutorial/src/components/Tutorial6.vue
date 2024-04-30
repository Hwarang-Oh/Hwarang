<script setup>
import { ref } from 'vue'

const awesome = ref(true)

function toggle() {
  if (awesome.value == true) awesome.value = false
  else awesome.value = true
}

/*
const toggle = () => {
  awesome.value = !awesome.value
}
*/
</script>

<template>
  <div>
    <button @click="toggle">toggle</button>
    <h1 v-if="awesome">Vue is awesome!</h1>
    <h1 v-else="awesome">Oh no 😢</h1>
    <h1 v-show="awesome">Vue is awesome!</h1>
    <h1 v-show="!awesome">Oh no 😢</h1>
  </div>
</template>

<style scoped></style>
