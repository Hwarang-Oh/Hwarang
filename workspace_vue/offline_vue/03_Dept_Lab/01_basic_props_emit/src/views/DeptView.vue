<script setup>
import { reactive, ref } from 'vue'
import DeptList from '@/components/DeptList.vue'
import DeptDetail from '@/components/DeptDetail.vue'
import DeptForm from '@/components/DeptForm.vue'

const mode = ref('')
const selectedDept = reactive({}) // from : DeptList, via : DeptView , to : DeptDetail
const deleteDeptno = ref(0)

const changeMode = (payload) => {
  mode.value = payload.mode
  if (mode.value === 'detail') {
    // DeptView가 DeptDetail에게 선택한 Data를 줘야 한다.
    console.log(selectedDept)
    selectedDept.deptno = payload.data.deptno
    selectedDept.dname = payload.data.dname
    selectedDept.loc = payload.data.loc
    console.log(selectedDept)
  }
}

const dept = reactive({}) // from : DeptFrom(등록) / DeptDetail(수정), via : DeptView , to : DeptList
// DeptView 입장에서는 이를 구분하는 것을 해줘야 한다.
const type = ref('')

const registerDept = (payload) => {
  // 받아온 객체를 반응형으로 연결하고 List에 전달해줘야 한다.
  type.value = 'register'
  dept.deptno = payload.deptno
  dept.dname = payload.dname
  dept.loc = payload.loc
}

const modifyDept = (payload) => {
  // payload를 잘 설정해서, register와 하나의 함수로 만들어낼 수 있음.
  type.value = 'modify'
  dept.deptno = payload.deptno
  dept.dname = payload.dname
  dept.loc = payload.loc
}

const removeDept = (payload) => {
  deleteDeptno.value = payload
  mode = null
}
</script>

<!-- DeptView가 Rendering을 하는 역할을 하기에, DeptList가 DeptView에게 Signal을 보내고, 그에 맞게 조건부 Rendering을 해야 한다. -->
<!-- DepList가 부모의 mode를 바꿔서 필요한 Data와 함께 Rendering되는 화면을 바꾸고자 함 -->
<!-- DeptList에 의해서 mode를 바꿔줘야 함 -> 하지만 자식인 List는 힘이없다. -> deptList의 Event에 의해서 바꿔줘야 한다 -->

<template>
  <div>
    <DeptList @change-mode="changeMode" :dept="dept" :type="type" :deleteDeptno="deleteDeptno" />
    <DeptDetail
      v-if="mode === 'detail'"
      :selectedDept="selectedDept"
      @modify-dept="modifyDept"
      @remove-dept="removeDept"
    />
    <DeptForm v-else-if="mode === 'register'" @register-dept="registerDept" />
  </div>
</template>

<style scoped></style>
