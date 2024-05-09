<script setup>
import Quiz from './Quiz.vue'
import { computed, inject, ref, watch } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const newQuizPk = computed(() => quizList.length + 1)
const { getDetail } = inject('service')
const { quiz, deleteQuizPk, type, quizList } = inject('res')
const currentQuizList = ref([])

watch(
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

watch(
  quiz,
  (n) => {
    if (type.value === 'create') {
      n.pk = newQuizPk
      quizList.push({ ...n })
    } else {
      for (const idx in quizList) {
        if (quizList[idx].pk == n.pk) {
          quizList[idx].question = n.question
          quizList[idx].answer = n.answer
          break
        }
      }
    }
  },
  {
    immediate: true
  }
)
watch(deleteQuizPk, (n) => {
  const index = quizList.findIndex((item) => item.pk === n)
  if (index !== -1) {
    quizList.splice(index, 1)
  }
})
</script>

<template>
  <div class="bg-gray-100 p-4 rounded-lg shadow-md">
    <!-- Header Section -->
    <div class="space-y-4">
      <header class="bg-orange-500 text-white text-center p-4 rounded-t-lg">
        <h1 class="font-bold text-2xl">Quiz List</h1>
      </header>

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
          <a href="#" class="hover:underline">Home</a>
          <span>|</span>
          <a href="#" class="hover:underline">Contact</a>
        </nav>
      </footer>
    </div>
  </div>
</template>

<style scoped></style>
