<script setup>
import { ref, onMounted } from 'vue'
const pElementRef = ref(null)
const inputRef = ref(null)
onMounted(() => {
  pElementRef.value.textContent = '빠빠~'
  inputRef.value.focus()
})
</script>

<template>
  <div>
    <p ref="pElementRef">안녕</p>
    <input type="text" ref="inputRef" />
  </div>
</template>

<style scoped></style>
