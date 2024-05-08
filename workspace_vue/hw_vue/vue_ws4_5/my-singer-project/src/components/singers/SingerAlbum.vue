<script setup>
import { ref } from 'vue'
</script>

<template>
  <div class="songListContainer">
    <h3>Album Title</h3>
    <ul class="songList">
      <li>Song List1</li>
      <li>Song List2</li>
      <li>Song List3</li>
    </ul>
  </div>
</template>

<style scoped>
.songListContainer {
  background-color: whitesmoke;
  border-radius: 10%;
  display: flex;
  flex-direction: column;
  padding: 3%;
  margin-bottom: 10px;
}
.songList {
  list-style-type: none;
  padding-left: 0;
  margin-top: 0;
}
</style>
