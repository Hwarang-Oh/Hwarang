<script setup>
import HelloWorld from './components/HelloWorld.vue'
// import TheWelcome from './components/TheWelcome.vue'
import ex2 from './components/ex2_1.vue'
</script>

<template>
  <main>
    <ex2 />
  </main>
</template>

<style scoped>
header {
  line-height: 1.5;
}

main {
  padding: 0;
  margin: 0;
  width: 100%;
  height: 100vh; /* Adjust the height as needed */
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
