<script setup>
import { reactive, inject } from 'vue'
// const emit = defineEmits(['registerDept'])
const { createQuiz } = inject('service')
const quiz = reactive({ pk: 0, question: '', answer: '' })

const submit = () => {
  // click에서 registerDept를 그대로 써도 가능하다. (reset() 때문에, 안하고 있는 것!)
  createQuiz(quiz)
  reset()
}

const reset = () => {
  quiz.question = ''
  quiz.answer = ''
}
</script>

<template>
  <div class="bg-gray-100 p-4 rounded-lg shadow-md">
    <!-- Header Section -->
    <header class="bg-orange-400 text-white text-center p-4 rounded-t-lg">
      <h1 class="font-bold text-xl">Quiz Create</h1>
    </header>

    <!-- Form Section -->
    <form @submit.prevent="createQuiz">
      <!-- Question Input -->
      <div class="mb-4">
        <label for="question" class="block mb-1 text-gray-700 font-semibold">문제</label>
        <textarea
          id="question"
          v-model="quiz.question"
          rows="3"
          class="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring focus:border-blue-400"
          placeholder="질문 입력"
        ></textarea>
      </div>

      <!-- Answer Input -->
      <div class="mb-4">
        <label for="answer" class="block mb-1 text-gray-700 font-semibold">답안</label>
        <input
          id="answer"
          v-model="quiz.answer"
          type="text"
          class="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring focus:border-blue-400"
          placeholder="정답 입력"
        />
      </div>

      <!-- Submit Button -->
      <div class="flex justify-center">
        <button
          type="submit"
          class="bg-gradient-to-r from-blue-500 to-sky-500 hover:from-blue-500 hover:to-sky-500 text-white font-bold py-2 px-6 rounded-full shadow-lg hover:shadow-xl transition duration-300 transform hover:-translate-y-1"
          @click="createQuiz(quiz)"
        >
          퀴즈 생성
        </button>
      </div>
    </form>
  </div>
</template>

<style scoped></style>
