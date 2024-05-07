<script setup>
import { reactive } from 'vue'
const dept = reactive({ deptno: '', dname: '', loc: '' })
</script>

<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-danger text-light text-center">부서 등록</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <!-- 구조를 잘 살펴보면, 상세보기와 구조가 비슷하다. => 하나로 통합해서 구성할 수 도 있다. 하지만 현재는 어려운 상태-->
          <tr>
            <th><label for="deptno">부서번호</label></th>
            <td>
              <input type="text" name="deptno" v-model.lazy="dept.deptno" />
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
              <input type="button" value="등록" class="btn btn-warning m-1" />
              <input type="reset" value="취소" class="btn btn-info m-1" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<style scoped></style>
