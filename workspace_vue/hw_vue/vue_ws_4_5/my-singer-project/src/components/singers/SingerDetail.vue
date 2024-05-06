<script setup>
import { ref } from 'vue'
import SingerAlbum from './SingerAlbum.vue'
</script>

<template>
  <div class="card">
    <h1 class="testStyle">가수 이름</h1>
    <img class="singerImage" src="../../assets/Chu.png" alt="singer Picture" />
    <p>가수 소개</p>
    <div class="albumList">
      <SingerAlbum />
      <SingerAlbum />
    </div>
  </div>
</template>

<style scoped>
.card {
  border-style: solid;
  border-color: black;
  border-radius: 14%;
  border-width: 3px;
}
.testStyle {
  /* color: green; */
}
.singerImage {
  width: 200px;
  border-radius: 50%;
}
.albumList {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}
</style>
