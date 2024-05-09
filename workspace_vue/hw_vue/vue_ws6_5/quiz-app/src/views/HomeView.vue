<script setup>
import { RouterLink } from 'vue-router'
</script>

<template>
  <div class="bg-gray-100 p-4 rounded-lg shadow-md">
    <!-- Header Section -->
    <header class="bg-orange-400 text-white text-center p-4 rounded-t-lg">
      <h1 class="font-bold text-xl">Quiz 퀴즈</h1>
    </header>

    <!-- Main Content Section -->
    <main class="bg-white p-4 text-center rounded-b-lg">
      <p>여기는 퀴즈의 나라! 놀라운 퀴즈들이 기다리고 있어요. 지금 바로 도전해보세요!</p>
    </main>

    <!-- Footer Section -->
    <footer class="bg-gray-800 text-white text-center p-2 mt-4 rounded-md">
      <nav class="flex justify-center space-x-2">
        <router-link to="/" class="hover:underline">Home</router-link>
        <span>|</span>
        <router-link to="/quiz/list" class="hover:underline">Quiz List</router-link>
        <span>|</span>
        <router-link to="/quiz/create" class="hover:underline">Quiz Create</router-link>
      </nav>
      <div id="startButton" class="flex justify-center mb-6">
        <button
          class="bg-gradient-to-r from-orange-500 to-red-500 hover:from-red-500 hover:to-orange-500 text-white font-bold py-2 px-6 rounded-full shadow-lg hover:shadow-xl transition duration-300 transform hover:-translate-y-1"
          @click="startQuiz"
        >
          Challenge! Go to Quiz
        </button>
      </div>
    </footer>
  </div>
</template>

<style scoped>
#startButton {
  margin-top: 12px;
  margin-bottom: 12px;
}
</style>
