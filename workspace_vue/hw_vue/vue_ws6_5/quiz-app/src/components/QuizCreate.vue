<script setup>
import { reactive, ref, inject, watch } from 'vue'
import { useRouter, onBeforeRouteLeave } from 'vue-router'
const { createQuiz } = inject('service')
const quiz = reactive({ pk: 0, question: '', answer: '' })
const creatingQuiz = ref(false)
const submitQuiz = ref(false)
const router = useRouter()

const submit = () => {
  submitQuiz.value = true
  createQuiz(quiz)
  reset()
}

const reset = () => {
  quiz.question = ''
  quiz.answer = ''
}

watch(quiz, (n) => {
  creatingQuiz.value = quiz.question !== '' || quiz.answer !== ''
})

onBeforeRouteLeave((to, from, next) => {
  if (submitQuiz.value) {
    next()
  } else if (creatingQuiz.value) {
    const response = window.confirm(
      '작성중이던 문제가 있습니다. 다른 경로로 이동시 작성중이던 내용은 소멸됩니다. 이동하시겠습니까?'
    )
    if (response) {
      next() // Allow navigation
    } else {
      next(false) // Prevent navigation
    }
  } else {
    next() // Allow navigation without warning
  }
})
</script>

<template>
  <div class="bg-gray-100 p-4 rounded-lg shadow-md">
    <!-- Header Section -->
    <header class="bg-orange-400 text-white text-center p-4 rounded-t-lg">
      <h1 class="font-bold text-xl">Quiz Create</h1>
    </header>
    <footer class="bg-gray-800 text-white text-center p-2 mt-4 rounded-md">
      <nav class="flex justify-center space-x-2">
        <router-link to="/" class="hover:underline">Home</router-link>
        <span>|</span>
        <router-link to="/quiz/list" class="hover:underline">Quiz List</router-link>
        <span>|</span>
        <router-link to="/quiz/create" class="hover:underline">Quiz Create</router-link>
      </nav>
    </footer>

    <!-- Form Section -->
    <form method="post">
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
        <input
          type="button"
          value="퀴즈 생성"
          class="bg-gradient-to-r from-blue-500 to-sky-500 hover:from-blue-500 hover:to-sky-500 text-white font-bold py-2 px-6 rounded-full shadow-lg hover:shadow-xl transition duration-300 transform hover:-translate-y-1"
          @click="submit"
        />
      </div>
    </form>
  </div>
</template>

<style scoped></style>
