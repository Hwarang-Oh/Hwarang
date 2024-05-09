<script setup>
import { inject, ref, watch } from 'vue'

const { selectedQuiz } = inject('res')
const { modifyQuiz, deleteQuiz } = inject('service')
const quiz = ref({})

watch(
  selectedQuiz,
  (n) => {
    quiz.value = { ...n }
  },
  { immediate: true }
)
</script>

<template>
  <div class="bg-gray-100 p-4 rounded-lg shadow-md">
    <!-- Header Section -->
    <header class="bg-orange-500 text-white text-center p-4 rounded-t-lg">
      <h1 class="font-bold text-2xl">Quiz Detail</h1>
    </header>

    <!-- Quiz List Section -->
    <form method="post">
      <div class="space-y-4">
        <div
          class="bg-white p-4 shadow-sm rounded-lg hover:shadow-lg transition-shadow duration-200"
        >
          <h3 class="font-semibold text-lg mb-2">{{ quiz.pk }}번 문제</h3>
          <div>
            <label for="question" class="block text-lg font-semibold text-gray-700 mb-1"
              >문제</label
            >
            <input
              type="text"
              name="question"
              id="question"
              class="w-full p-3 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-orange-500 focus:border-transparent transition duration-200"
              v-model="quiz.question"
              placeholder="질문 입력"
            />
          </div>

          <!-- Answer Section -->
          <div>
            <label for="answer" class="block text-lg font-semibold text-gray-700 mb-1">정답</label>
            <input
              type="text"
              name="answer"
              id="answer"
              class="w-full p-3 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-orange-500 focus:border-transparent transition duration-200"
              v-model="quiz.answer"
              placeholder="정답 입력"
            />
          </div>
        </div>
        <div class="button_group">
          <span class="button_box">
            <input
              type="button"
              value="Quiz 수정"
              class="bg-gradient-to-r from-green-500 to-green-700 hover:from-green-600 hover:to-green-800 text-white font-bold py-2 px-6 rounded-full shadow-lg hover:shadow-xl transition duration-300 transform hover:-translate-y-1"
              @click="modifyQuiz(quiz)"
            />
          </span>
          <span class="button_box">
            <input
              type="button"
              value="Quiz 삭제"
              class="bg-gradient-to-r from-orange-500 to-red-500 hover:from-red-500 hover:to-orange-500 text-white font-bold py-2 px-6 rounded-full shadow-lg hover:shadow-xl transition duration-300 transform hover:-translate-y-1"
              @click="deleteQuiz(quiz.pk)"
            />
          </span>
        </div>
      </div>
    </form>
  </div>
</template>

<style scoped>
.button_box {
  padding: 10px;
}
</style>
