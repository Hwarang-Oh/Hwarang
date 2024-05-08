<script setup>
import { ref } from 'vue'
import SingerDetail from './singers/SingerDetail.vue'
const singers = ref([
  { name: '츄' },
  { name: '리즈' },
  { name: '아리마 카나' },
  { name: '호시노 루비' }
])
</script>

<template>
  <div>
    <h1 class="listTitle">가수 목록</h1>
    <div class="listContainer">
      <SingerDetail v-for="singer in singers" :key="singer.name" />
    </div>
  </div>
</template>

<style scoped>
.listContainer {
  text-align: center;
}

.listTitle {
  text-align: center;
  color: orangered;
}
.card {
  display: inline-block;
  width: 40%;
  margin: 20px;
}
</style>
