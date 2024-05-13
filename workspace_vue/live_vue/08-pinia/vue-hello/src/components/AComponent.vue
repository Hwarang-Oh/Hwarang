<script setup>
import { useCounterStore } from '@/stores/counter'

const store = useCounterStore()
</script>

<template>
  <h1>A Component 입니다.</h1>
  <h3>A Component Store Count : {{ store.count }}</h3>
</template>

<style scoped></style>
