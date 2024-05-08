<script setup>
import { ref, watch } from 'vue'

const props = defineProps(['BusinessCard'])
const emit = defineEmits(['removeCard'])
const BusinessCard = ref({})
watch(
  props.BusinessCard,
  (n) => {
    BusinessCard.value = { ...n }
  },
  {
    immediate: true
  }
)

const removeCard = () => {
  emit('removeCard', BusinessCard.value.cardno)
}
</script>

<template>
  <div class="col">
    <div class="card" style="width: 18rem">
      <img :src="BusinessCard.img" class="card-img-top" alt="Image" />
      <div class="card-body">
        <p class="card-text">Name : {{ BusinessCard.name }}</p>
        <p class="card-text">Job : {{ BusinessCard.job }}</p>
        <button @click="removeCard">방출하기</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.col {
  display: flex;
  justify-content: center;
}
</style>
