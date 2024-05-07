<script setup>
import { reactive } from 'vue'
const depts = reactive([{ deptno: 10, dname: '개발1팀', loc: '서울' }])
// 배열이나 객체는 reactive로 만들고, 원시값은 ref로 정의하는 것을 Vue에서는 권장하고 있음.
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
          <!-- tbody : 사용자 정보가 없을 때는, 없음 안내를 보여주고, 있다면 부서 목록을 보여주기 -->
          <!--"depts?.length == 0" => ???-->
          <tr v-if="depts == null || depts.length === 0">
            <td colspan="4">등록된 사용자 정보가 없습니다.</td>
          </tr>
          <!--v-if와 v-for은 같이 쓰면 안되므로, template과 같은 가상 Tag를 통해 Wrapping!-->
          <template v-else>
            <tr v-for="(dept, index) in depts" :key="dept.deptno">
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
              <div class="btn btn-success text-center">등록</div>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
  </div>
</template>

<style scoped></style>
