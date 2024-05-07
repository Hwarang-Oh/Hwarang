<script setup>
import { ref } from 'vue'
import DeptList from '@/components/DeptList.vue'
import DeptDetail from '@/components/DeptDetail.vue'
import DeptForm from '@/components/DeptForm.vue'

const mode = ref('mode')
</script>

<!-- DeptView가 Rendering을 하는 역할을 하기에, DeptList가 DeptView에게 Signal을 보내고, 그에 맞게 조건부 Rendering을 해야 한다. -->
<!-- DepList가 부모의 mode를 바꿔서 필요한 Data와 함께 Rendering되는 화면을 바꾸고자 함 -->
<!-- DeptList에 의해서 mode를 바꿔줘야 함 -> 하지만 자식인 List는 힘이없다. -> deptList의 Event에 의해서 바꿔줘야 한다 -->

<template>
  <div>
    <DeptList />
    <DeptDetail v-if="mode === 'detail'" />
    <DeptForm v-else-if="mode === 'register'" />
  </div>
</template>

<style scoped></style>
