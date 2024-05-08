<script setup>
import { reactive, ref, provide, readonly } from 'vue'
import { RouterView, useRouter } from 'vue-router'
import DeptList from '@/components/DeptList.vue'

const selectedDept = reactive({})
const dept = reactive({})
// const mode = ref('')
const router = useRouter()
const type = ref('')
const deleteDeptno = ref(0)

const changeMode = (payload) => {
  // DeptList상황에서 호출됨
  selectedDept.deptno = payload.data.deptno
  selectedDept.dname = payload.data.dname
  selectedDept.loc = payload.data.loc
}

const registerDept = (payload) => {
  type.value = 'register'
  dept.deptno = payload.deptno
  dept.dname = payload.dname
  dept.loc = payload.loc
}

const modifyDept = (payload) => {
  type.value = 'modify'
  dept.deptno = payload.deptno
  dept.dname = payload.dname
  dept.loc = payload.loc
}

const removeDept = (payload) => {
  deleteDeptno.value = payload
  router.push('/dept')
  // mode.value = null => 같은 기능을 하는 기본 화면 Routing를 해야 한다!!
}

// resource라는 이름으로, 현재 Props로 보내는 것들을 하나의 객체로 묶어서 Provide 할 것이다.
// Props로 갈 때는, ref 객체를 보내는 느낌이다.
// Provide로 갈 때는, ref 객체의 value값이 그 자체로 가는 느낌이다. ( like reactive )
// provide('res', { dept, selectedDept, deleteDeptno, type })
// => ShortHand로 쉽게 줄 수 있지만... ReadOnly를 하고 싶기 때문에, 아래와 같이 전달해야 함.
provide('res', {
  dept: readonly(dept),
  selectedDept: readonly(selectedDept),
  deleteDeptno: readonly(deleteDeptno),
  type: readonly(type)
})

provide('service', {
  changeMode,
  registerDept,
  modifyDept,
  removeDept
})
// => 위와 같은 Provide를 통해 Props와 emit을 없앨 수 있다.
</script>

<template>
  <div>
    <!-- <DeptList @change-mode="changeMode" :dept="dept" :type="type" :deleteDeptno="deleteDeptno" /> 
      와 같이 Props와 event를 받아내는 emit에 대한 Code가 사라진다.
    -->
    <DeptList />
    <!-- <DeptDetail v-if="mode === 'detail'" />
    <DeptForm v-else-if="mode === 'register'" /> 
    if로 구분한 것은 vue Router로 처리해야 한다. -->

    <router-view />
  </div>
</template>

<style scoped></style>
