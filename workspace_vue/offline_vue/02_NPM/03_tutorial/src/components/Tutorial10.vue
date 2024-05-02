<script setup>
import { ref, watch } from 'vue'

const todoId = ref(0)
const todoData = ref(null)

// Function to fetch data from the API
const fetchData = async (newValue, oldValue) => {
  todoData.value = null // Clear previous data
  try {
    const response = await fetch(`https://jsonplaceholder.typicode.com/todos/${todoId.value}`)
    if (!response.ok) throw new Error('Failed to fetch')
    const data = await response.json()
    todoData.value = data
  } catch (error) {
    console.error('Fetch error:', error)
    todoData.value = { error: 'Could not load data' }
  }
}

// Watching the todoId to fetch data when it changes
watch(todoId, fetchData)

const person = ref({
  name: '김수현',
  age: 36,
  addr: {
    zipcode: '111-222',
    loc: '서울'
  }
})

// A의 Value의 객체는 탐지가 안되는 상태. -> deep: true를 줘서 반응형 객체를 유지하는 Nested를 따라가거나 , A.value로 반응형으로 Wrapping된 객체가 들어가는 형태 -> 반응형이 됨

watch(person.value, (newValue, oldValue) => {
  console.log('watch person:', newValue, oldValue)
})

// Deep watcher for the person object to detect changes in nested properties
watch(
  person,
  (newValue, oldValue) => {
    console.log('watch person:', newValue, oldValue)
  },
  { deep: true }
)
watch(
  () => person.value.age,
  (newAge, oldAge) => {
    console.log(`watch person age ${oldAge} => ${newAge}`)
  }
) // getter Function 형태로 만들어주면 실행이 된다!!
</script>

<template>
  <div>
    <p>Todo id: {{ todoId }}</p>
    <button @click="todoId++">Fetch next todo</button>
    <p v-if="!todoData">Loading...</p>
    <pre v-else>{{ JSON.stringify(todoData, null, 2) }}</pre>
    <div>{{ person.name }} // {{ person.age }} // {{ person.addr.loc }}</div>
  </div>
</template>
<!-- JS는 길이가 있는 Array는 True로 취급됨! -->
<!-- <pre v-else>{{ todoData }}</pre> -> 디자인 고려안하고 JSON 형태 그대로!! -->
<!-- 초기값에서 변화를 줘야 watch가 콜백이 됨 -->
<!-- watch는 변화가 일어나야 CallBack이 되는데 , 그게 없으면 아예 안됨
그렇기에 명시적으로 변화를 주거나, Option으로 Immediate를 하던가 해야 한다!! -->
