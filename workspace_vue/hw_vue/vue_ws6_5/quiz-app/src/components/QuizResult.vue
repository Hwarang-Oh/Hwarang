<script setup>
import { computed } from 'vue'

const props = defineProps(['currentQuiz', 'userInput'])
const isAnswerCorrect = computed(() => {
  return props.userInput.value.trim().toLowerCase() === props.currentQuiz.answer.toLowerCase()
})
</script>

<template>
  <div class="bg-white p-6 rounded-lg shadow-md">
    <h3 class="text-lg font-semibold mb-2"></h3>
    <div>
      <h4 class="font-semibold text-xl mb-2">
        <span :class="isAnswerCorrect ? 'text-green-600' : 'text-red-600'">
          {{ isAnswerCorrect ? '정답입니다!' : '오답입니다.' }}
        </span>
      </h4>
      <p>나의 제출 답안: {{ userInput.value }}</p>
      <p>정답: {{ currentQuiz.answer }}</p>
    </div>
  </div>
</template>

<style scoped></style>
