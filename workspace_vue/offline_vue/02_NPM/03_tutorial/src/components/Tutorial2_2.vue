<script>
import { ref } from 'vue'
export default {
  name: 'Tutorial2_2',
  setup() {
    const title = ref('허2덩') // 반응형 객체의 Proxy를 만들어 내는 것
    const change = () => {
      if (title.value == 'hello') {
        title.value = '허2덩'
      } else {
        title.value = 'hello'
      }
    }
    return {
      title,
      change
    }
  }
}
</script>

<template>
  <div>
    <h1>{{ title }}</h1>
    <button @click="change">변경</button>
  </div>
</template>

<style scoped>
h1 {
  background-color: aquamarine;
}
</style>
