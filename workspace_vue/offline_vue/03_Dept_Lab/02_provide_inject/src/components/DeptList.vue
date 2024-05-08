<script setup>
import { reactive, watch, inject } from 'vue'
const { changeMode } = inject('service')
const { dept, deleteDeptno, type } = inject('res')

const depts = reactive([
  { deptno: 10, dname: '개발1팀', loc: '서울' },
  { deptno: 20, dname: '테스트1팀', loc: '서울' }
])

const changeForm = () => {
  changeMode({ mode: 'register' })
}

const pickDept = (index) => {
  changeMode({ mode: 'detail', data: depts[index] })
}

watch(
  dept,
  (n) => {
    if (type.value === 'register') {
      depts.push({ ...n })
    } else {
      for (const idx in depts) {
        if (depts[idx].deptno == n.deptno) {
          depts[idx].dname = n.dname
          depts[idx].loc = n.loc
          break
        }
      }
    }
  },
  {
    immediate: true
  }
)
watch(
  // ref 객체로 온 deleteDeptno -> getter로 받을 필요 X
  deleteDeptno,
  (n) => {
    for (const idx in depts) {
      if (depts[idx].deptno == n) {
        depts.splice(idx, 1)
        break
      }
    }
  }
)
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
