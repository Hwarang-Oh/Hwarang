<script setup>
import { useCounterStore } from '@/stores/counter'
import BComponentChild from '@/components/BComponentChild.vue'

const store = useCounterStore()
</script>

<template>
  <h1>B Component 입니다.</h1>
  <h3>B Component Child Store Count : {{ store.count }}</h3>
  <BComponentChild />
</template>

<style scoped></style>
