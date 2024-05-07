<script setup>
import { ref } from 'vue'
// const props = defineProps(['selectedDept'])
const dept = ref({ deptno: 10, dname: '개발 1팀', loc: '서울' })
</script>

<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-info text-light text-center">부서 조회</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <!--단순하게 조회하는 것이 아닌, 수정과 삭제가 동반되어야 하므로, v-model로 연결해줘야 한다-->
          <tr>
            <th><label for="deptno">부서번호</label></th>
            <td>
              <input type="text" name="deptno" id="deptno" v-model="dept.deptno" readonly />
            </td>
          </tr>
          <tr>
            <th><label for="dname">부서이름</label></th>
            <td>
              <!-- lazy modifer을 통해서, 입력이 다끝난 다음에 반영해줄 수 있다.-->
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
              <input type="button" value="수정" class="btn btn-warning m-1" />
              <input type="button" value="삭제" class="btn btn-dark m-1" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<style scoped></style>
