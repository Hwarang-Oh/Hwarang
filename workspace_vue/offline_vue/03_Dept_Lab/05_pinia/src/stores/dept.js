import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import deptAPI from '@/apis/dept'

export const useDeptStore = defineStore('dept', () => {
  const orgDepts = ref([]) // state
  // 직접 사용하게 하지 않고, Getter로 제공하자
  const depts = computed(() => orgDepts.value)

  const getDepts = (success, fail) => {
    // BackEnd에서 List를 가져와야함. API를 호출해서 사용하자!
    deptAPI.getList(({ response }) => {
      orgDepts.value = response
      if (success) success()
    }, fail)
  }

  // store가 생성되면 data를 바로 가져오게 한다
  getDepts()
  return { orgDepts, depts, getDepts }
})
