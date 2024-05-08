<script setup>
import { reactive } from 'vue'
import BusinessCardList from './components/BusinessCardList.vue'
import BusinessCardCreate from './components/BusinessCardCreate.vue'

const BusinessCard = reactive({})

const registerCard = (payload) => {
  BusinessCard.cardno = payload.cardno
  BusinessCard.name = payload.name
  BusinessCard.job = payload.job
  BusinessCard.img = payload.img
}
</script>

<template>
  <header class="container p-5 my-5 bg-primary text-white">
    <h1><span class="badge bg-primary">아이돌 관리 페이지</span></h1>
  </header>
  <main class="container">
    <p>아이돌을 관리하는 페이지입니다. 여기에 아이돌 목록이 표시됩니다.</p>
    <BusinessCardCreate @register-card="registerCard" />
    <article>
      <BusinessCardList :BusinessCard="BusinessCard" />
    </article>
    <div class="space"></div>
  </main>
  <footer>
    <p>&copy; 2024 Hwarang Business Cards</p>
  </footer>
</template>

<style scoped>
header {
  text-align: center;
  border-radius: 1%;
}
main {
  text-align: center;
}
.space {
  height: 100px;
}

footer {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f8f9fa; /* Adjust to your preferred bg color */
  position: fixed;
  bottom: 0;
  width: 100%;
  height: 60px; /* Adjust height as needed */
}
</style>
