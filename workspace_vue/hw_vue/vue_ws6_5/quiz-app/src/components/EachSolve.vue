<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const props = defineProps(['currentQuiz', 'showResult'])
const emit = defineEmits(['submitAnswer', 'checkResult'])
const userInput = ref('')
const isSubmit = ref(false)

const checkResult = () => {
  if (userInput.value === '') alert('답을 입력해주세요 :)')
  else {
    const confirmMessage = `${userInput.value} 을/를 답안으로 제출합니다. 확실합니까?`
    if (isSubmit.value === true) {
      emit('checkResult', { userInput: userInput })
    } else if (window.confirm(confirmMessage)) {
      // On confirmation, navigate to another page (e.g., quiz results or list)
      isSubmit.value = true
      emit('checkResult', { userInput: userInput })
    } else {
      userInput.value = ''
    }
  }
}

const submitAnswer = () => {
  if (userInput.value === '') alert('답을 입력해주세요 :)')
  else {
    const confirmMessage = `${userInput.value} 을/를 답안으로 제출합니다. 확실합니까?`
    if (isSubmit.value === true) {
      emit('submitAnswer', { quizPk: props.currentQuiz.pk })
      userInput.value = ''
      isSubmit.value = false
    } else if (window.confirm(confirmMessage)) {
      // On confirmation, navigate to another page (e.g., quiz results or list)
      emit('submitAnswer', { quizPk: props.currentQuiz.pk })
      userInput.value = ''
      isSubmit.value = false
    } else {
      // Clear the input if the user cancels
      userInput.value = ''
    }
  }
}
</script>

<template>
  <form method="post">
    <div class="space-y-4">
      <div class="bg-white p-4 shadow-sm rounded-lg hover:shadow-lg transition-shadow duration-200">
        <div>
          <label for="question" class="block text-lg font-semibold text-gray-700 mb-1">문제</label>
          <input
            type="text"
            name="question"
            id="question"
            :value="props.currentQuiz.question"
            readonly
            class="w-full p-3 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-orange-500 focus:border-transparent transition duration-200"
          />
        </div>

        <!-- Answer Section -->
        <div>
          <label for="answer" class="block text-lg font-semibold text-gray-700 mb-1">답안</label>
          <input
            type="text"
            name="answer"
            id="answer"
            v-model.lazy="userInput"
            class="w-full p-3 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-orange-500 focus:border-transparent transition duration-200"
            placeholder="답안 입력"
            :readonly="isSubmit"
            @keyup.enter="checkResult"
          />
        </div>
      </div>
      <div class="button_group">
        <span class="button_box">
          <input
            type="button"
            :value="props.showResult ? 'Hide Result' : 'Check Result'"
            class="bg-gradient-to-r from-green-500 to-orange-700 hover:from-orange-600 hover:to-green-800 text-white font-bold py-2 px-6 rounded-full shadow-lg hover:shadow-xl transition duration-300 transform hover:-translate-y-1"
            @click="checkResult"
          />
        </span>
        <span class="button_box">
          <input
            type="button"
            value="Next Question"
            class="bg-gradient-to-r from-blue-500 to-purple-700 hover:from-purple-600 hover:to-blue-800 text-white font-bold py-2 px-6 rounded-full shadow-lg hover:shadow-xl transition duration-300 transform hover:-translate-y-1"
            @click="submitAnswer"
          />
        </span>
      </div>
    </div>
  </form>
</template>

<style scoped>
.button_box {
  padding: 10px;
}
</style>
