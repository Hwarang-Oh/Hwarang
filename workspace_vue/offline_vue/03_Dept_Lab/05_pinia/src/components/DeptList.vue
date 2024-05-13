<script setup>
import { useRouter } from 'vue-router'

// 240513
import { useDeptStore } from '@/stores/dept'
import { storeToRefs } from 'pinia'
const deptStore = useDeptStore()
const { depts } = storeToRefs(deptStore)
// Store가 Return하는 반응형 대상을 구조 분해 할당으로 얻어내면 된다.

// 240513 End

// Assignment
const router = useRouter()
const changeForm = () => {
  router.push('/dept/form')
}

const pickDept = (index) => {
  router.push(`/dept/detail/${depts.value[index].deptno}`)
}
</script>

<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-primary text-light text-center">부서 목록</h2>
    </div>
    <div class="row">
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>번호</th>
            <th>부서번호</th>
            <th>부서이름</th>
            <th>위치</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="depts == null || depts.length === 0">
            <td colspan="4">등록된 사용자 정보가 없습니다.</td>
          </tr>
          <template v-else>
            <tr v-for="(dept, index) in depts" :key="dept.deptno" @click="pickDept(index)">
              <td>{{ index + 1 }}</td>
              <td>{{ dept.deptno }}</td>
              <td>{{ dept.dname }}</td>
              <td>{{ dept.loc }}</td>
            </tr>
          </template>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="4">
              <div class="btn btn-success text-center" @click="changeForm">등록</div>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
  </div>
</template>

<style scoped></style>
