import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

// Legacy : const use ~~~ store , defineStore(' ~~~ ')
/*
export const useCounterStore = defineStore('counter', () => {
  const count = ref(0)
  const doubleCount = computed(() => count.value * 2)
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment }
})
*/
export const useTodostore = defineStore('todos', () => {
  let id = 0
  const todos = ref([
    {
      id: id++,
      text: 'One day One Algorithm',
      isDone: false
    },
    {
      id: id++,
      text: 'Review Vue.JS',
      isDone: false
    },
    {
      id: id++,
      text: 'Review Spring',
      isDone: false
    }
  ])
  return { todos }
})
