<script setup>
import { ref } from 'vue'
const titleClass = ref('title')
const change = () => {
  if (titleClass.value == 'title') {
    titleClass.value = 'normalText'
  } else {
    titleClass.value = 'title'
  }
}
</script>

<template>
  <div>
    <h1 v-bind:class="titleClass">Make me red</h1>
    <!-- add dynamic class binding here -->
    <button @click="change">변경</button>
  </div>
</template>

<style scoped>
.title {
  color: red;
}
.normalText {
  color: blue;
}
</style>
