<script setup>
import { reactive, ref, watch, watchEffect, inject } from 'vue'

const { selectedDept } = inject('res')
// const res = inject('res') => 객체 자체를 받아내서 dot 연산자로 접근해야 한다.
const { modifyDept, removeDept } = inject('service')
const dept = ref({})
watch(
  selectedDept,
  (n) => {
    dept.value = { ...n }
  },
  {
    immediate: true
  }
)
</script>

<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-info text-light text-center">부서 조회</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <tr>
            <th><label for="deptno">부서번호</label></th>
            <td>
              <input type="text" name="deptno" id="deptno" v-model="dept.deptno" readonly />
            </td>
          </tr>
          <tr>
            <th><label for="dname">부서이름</label></th>
            <td>
              <input type="text" name="dname" id="dname" v-model.lazy="dept.dname" />
            </td>
          </tr>
          <tr>
            <th><label for="loc">지역</label></th>
            <td>
              <input type="text" name="loc" id="loc" v-model.lazy="dept.loc" />
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2">
              <input
                type="button"
                value="수정"
                class="btn btn-warning m-1"
                @click="modifyDept(dept)"
              />
              <input
                type="button"
                value="삭제"
                class="btn btn-dark m-1"
                @click="removeDept(dept.deptno)"
              />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<style scoped></style>
