<script setup>
import { ref } from 'vue'
</script>

<template>
  <div class="container">
    <h1>가수 정보 페이지에 오신 것을 환영합니다</h1>
    <p>여러분이 좋아하는 가수와 아티스트에 대한 정보를 탐색해보세요.</p>
    <img id="mainImage" src="../assets/microphone.jpg" alt="Main Page Image" />
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}
#mainImage {
  width: 200px;
}
</style>
