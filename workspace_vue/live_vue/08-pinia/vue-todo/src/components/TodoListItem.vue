<script setup>
defineProps({
  todo: Object
})
</script>

<template>
  <div>
    <span>{{ todo.text }}</span>
    <button>삭제</button>
  </div>
</template>

<style scoped></style>
