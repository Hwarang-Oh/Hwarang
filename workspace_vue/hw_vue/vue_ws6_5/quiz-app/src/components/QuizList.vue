<script setup>
import Quiz from './Quiz.vue'
import { ref, watch, inject } from 'vue'
import { useRouter, RouterLink } from 'vue-router'

const router = useRouter()
const { deleteQuizPk, quizList } = inject('res')
const { getDetail } = inject('service')
const currentQuizList = ref([])

watch(
  // quizList를 복사하는 과정
  quizList,
  (n) => {
    currentQuizList.value = n
  },
  {
    immediate: true
  }
)

const pickQuiz = (index) => {
  getDetail({ data: currentQuizList.value[index] })
  router.push(`/quiz/detail/${currentQuizList.value[index].pk}`)
}
</script>

<template>
  <div class="bg-gray-100 p-4 rounded-lg shadow-md">
    <!-- Header Section -->
    <div class="space-y-4">
      <header class="bg-orange-500 text-white text-center p-4 rounded-t-lg">
        <h1 class="font-bold text-2xl">Quiz List</h1>
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

      <!-- Quiz List Section -->
      <Quiz
        v-for="(eachQuiz, index) in currentQuizList"
        :key="eachQuiz.pk"
        :eachQuiz="eachQuiz"
        @click="pickQuiz(index)"
      />

      <!-- Footer Section -->
      <footer class="bg-gray-800 text-white text-center p-2 mt-4 rounded-md shadow-md">
        <nav class="flex justify-center space-x-2">
          <router-link to="/">Home</router-link>
          <span>|</span>
          <a href="#" class="hover:underline">Contact</a>
        </nav>
      </footer>
    </div>
  </div>
</template>

<style scoped></style>
