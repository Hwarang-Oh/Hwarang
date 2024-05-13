<script setup>
import { useCounterStore } from '@/stores/counter'

const store = useCounterStore()
</script>

<template>
  <h1>B Component Child입니다.</h1>
  <h3>B Component Store Count : {{ store.count }}</h3>
  <button @click="store.increment()">BComponent Child Button Count 증가</button>
</template>

<style scoped></style>
