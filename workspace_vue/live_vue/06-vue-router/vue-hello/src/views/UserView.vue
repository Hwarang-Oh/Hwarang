<script setup>
import { useRoute, useRouter, onBeforeRouteLeave, onBeforeRouteUpdate } from 'vue-router'

const route = useRoute() // 해당 Component로 전달된 Param을 (Route)를 가져오는 역할
const router = useRouter() // 다른 Component로 이동하는 느낌!!
const userId = ref(route.params.id)

const goHome1 = () => {
  router.push({ name: 'home' })
}

const goHome2 = () => {
  router.replace({ name: 'home' })
}

onBeforeRouteLeave((to, from) => {
  // 다른 Page로 이동을 안내
  const flag = window.confirm('정말 떠나는가?')
  if (flag === false) return false
})

const changeUser = () => {
  router.push({ name: 'user', params: { id: 'kimSSAFY' } })
}

onBeforeUpdate((to,from) => {
  userId.value = to.params.id
}),
</script>

<template>
  <div class="user">
    <h1>This is an User Page</h1>
    <h2>{{ userId }} Profile!</h2>
    <!-- <h2>{{ $route.params.id }}님 프로필 입니다</h2> -->
    <!-- $emit과 유사함 => 하지만 권장하지 않기에..
      const emit = defineEmits()로 사용함
      그냥 Template 안에서는, 되도록 $를 통한 내부 변수를 사용하지 말자
    -->
    <button @click="goHome1">Home (Push)</button>
    <button @click="goHome2">Home (Replace)</button>
    <button @click="changeUser">사용자 전환</button>
  </div>
</template>

<style scoped></style>
