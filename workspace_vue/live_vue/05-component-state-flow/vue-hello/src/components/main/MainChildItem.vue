<script setup>
import { ref } from 'vue';
const name = ref('');

defineProps({
  childMsg: String,
});

const emit = defineEmits(['changeName']);

const changeName = () => {
  // 내가 입력한 이름을 가지고, 부모로 넘어가기 위한 목적!!
  emit('changeName', name.value);
};
</script>

<template>
  <div class="child-item">
    <h1>MainChildItem 입니다.</h1>
    <div>ChildItem : {{ childMsg }}</div>
    <div>자식 이름 : <input type="text" v-model="name" @keyup.enter="changeName" /></div>
  </div>
</template>

<style scoped>
.child-item {
  background-color: aqua;
}
</style>
