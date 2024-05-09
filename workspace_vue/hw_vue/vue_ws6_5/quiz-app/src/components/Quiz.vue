<script setup>
const props = defineProps(['eachQuiz'])
</script>

<template>
  <div class="bg-white p-4 shadow-sm rounded-lg hover:shadow-lg transition-shadow duration-200">
    <h3 class="font-semibold text-lg mb-2">
      {{ props.eachQuiz.pk }}번 문제 : {{ props.eachQuiz.question }}
    </h3>
    <p
      class="w-full p-2 border border-gray-300 rounded-lg focus:outline-none focus:border-orange-500"
    >
      정답 : {{ props.eachQuiz.answer }}
    </p>
  </div>
</template>

<style scoped></style>
