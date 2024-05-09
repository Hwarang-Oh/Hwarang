<script setup>
import { inject, ref, computed } from 'vue'
import { RouterView } from 'vue-router'
import EachSolve from './EachSolve.vue'
import QuizResult from './QuizResult.vue'

const { quizList } = inject('res')
const solvedQuiz = ref([])
const remainQuiz = computed(() => quizList.length - solvedQuiz.value.length)

const randomIndex = computed(() => {
  return Math.floor(Math.random() * remainQuiz.value)
})

const currentQuiz = computed(() => {
  remainQuiz
  const remainQuizList = quizList.filter((quiz) => !solvedQuiz.value.includes(quiz.pk))
  return remainQuiz.value > 0 ? remainQuizList[randomIndex.value] : null
})

const userInput = ref('')
const showResult = ref(false)
const checkResult = (payload) => {
  showResult.value = !showResult.value
  userInput.value = payload.userInput
}

const submitAnswer = (payload) => {
  if (!solvedQuiz.value.includes(payload.quizPk)) {
    solvedQuiz.value.push(payload.quizPk)
  }
  userInput.value = ''
  showResult.value = false
}
</script>

<template>
  <div class="bg-gray-100 p-4 rounded-lg shadow-md">
    <!-- Header Section -->
    <header class="bg-orange-500 text-white text-center p-4 rounded-t-lg">
      <h1 class="font-bold text-2xl">Quiz Challenge</h1>
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
    <div class="space">
      <p class="text-lg font-semibold">Solved: {{ solvedQuiz.length }} / {{ quizList.length }}</p>
    </div>
    <!-- Random Quiz Section -->
    <EachSolve
      v-if="currentQuiz"
      :currentQuiz="currentQuiz"
      :showResult="showResult"
      @checkResult="checkResult"
      @submitAnswer="submitAnswer"
    />
    <div v-else>
      <h2 class="text-xl font-semibold text-green-600">모든 퀴즈를 완료했습니다</h2>
    </div>
  </div>
  <QuizResult v-if="showResult" :currentQuiz="currentQuiz" :userInput="userInput" />
</template>

<style scoped>
.space {
  margin: 10px;
  margin-left: 0px;
}
</style>
