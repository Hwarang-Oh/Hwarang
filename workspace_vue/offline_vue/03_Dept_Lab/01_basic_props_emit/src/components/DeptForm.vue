<script setup>
import { reactive } from 'vue'
const dept = reactive({ deptno: '', dname: '', loc: '' })
// List에 넘겨야 하는데, 바로 넘길 수가 없음 -> View에 넘겨줘야 한다
// View에 넘겨주고 (emit), View는 바로 List에 넘겨야 하는데 (props), List 입장에서는 props가 언제 오고 바뀔지 모르므로, watch하고 있어야 한다.

const emit = defineEmits(['registerDept'])

const registerDept = () => {
  // payload를 감싸지 않고, 그 객체 자체를 payload로 준 형태
  emit('registerDept', dept) // emit은 동기적으로 된다. => 끝내고 오면 reset한다
  reset()
}

const reset = () => {
  dept.deptno = ''
  dept.dname = ''
  dept.loc = ''
}
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
              <input type="button" value="등록" class="btn btn-warning m-1" @click="registerDept" />
              <input type="reset" value="취소" class="btn btn-info m-1" @click="reset" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<style scoped></style>
