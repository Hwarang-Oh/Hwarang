<script setup>
import { reactive, ref, provide, readonly } from 'vue'
import { RouterView, useRouter } from 'vue-router'
import DeptList from '@/components/DeptList.vue'

const isReload = ref(0)
const reloadDepts = () => {
  isReload.value = new Date().getTime()
  // isReload는 계속 바뀌어야 하는데.. 랜덤한 값은 중복이 될 수도 있으니, 시간으로 설정!
}

provide('res', {
  isReload: readonly(isReload)
  // DeptList는 이 값을 가지고 보고 있을 것이다.
})

provide('service', {
  // 등록 수정 삭제는 해당 Method를 통해 isReload값을 바꿀 것이다!!
  reloadDepts
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
