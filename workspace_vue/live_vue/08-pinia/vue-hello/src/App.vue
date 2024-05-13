<script setup>
import { useCounterStore } from '@/stores/counter'
import AComponent from '@/components/AComponent.vue'
import BComponent from '@/components/BComponent.vue'

const store = useCounterStore()
store.count = 100
console.log(store.count)
</script>

<template>
  <div>
    <h1>APP입니다.</h1>
    <p>store count : {{ store.count }}</p>
    <p>store doubleCount : {{ store.doubleCount }}</p>
    <button @click="store.increment()">count 증가</button>
    <AComponent />
    <BComponent />
  </div>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
