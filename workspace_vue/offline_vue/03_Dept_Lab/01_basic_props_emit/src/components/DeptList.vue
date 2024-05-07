<script setup>
import { reactive, watch } from 'vue'
const depts = reactive([
  { deptno: 10, dname: '개발1팀', loc: '서울' },
  { deptno: 20, dname: '테스트1팀', loc: '서울' }
])
// 배열이나 객체는 reactive로 만들고, 원시값은 ref로 정의하는 것을 Vue에서는 권장하고 있음.

const emit = defineEmits(['changeMode'])
const props = defineProps(['dept', 'type', 'deleteDeptno']) // 추가적으로! 객체형으로 받으면서, 유효성 검사를 할 수 있음.

const changeForm = () => {
  emit('changeMode', { mode: 'register' })
  // 위와 같은 인자를 페일 노드? 로드?라고 부른다.
}
const pickDept = (index) => {
  emit('changeMode', { mode: 'detail', data: depts[index] })
  // index를 받아와도 되고, 선택한 dept 객체 그 자체를 넘겨줄 수도 있다.
}
watch(
  // selectedDept가 바뀔 때 마다 새로운 dept를 만들어내자!!
  props.dept,
  (n) => {
    if (props.type === 'register') {
      // 백엔드가 있다면, 수정과 등록 요청을 날리고, 결과를 받아와야 한다.
      // 현재는 백엔드가 없기에, 여기서 모두 처리하는 것이다.
      // 객체를 구조분해할당 with spread 연산자!
      depts.push({ ...n })
    } else if (props.type === 'modify') {
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
  // watch의 대상이 될 수 있는 것은 반응형과 연결된 친구들
  () => props.deleteDeptno
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
          <!-- tbody : 사용자 정보가 없을 때는, 없음 안내를 보여주고, 있다면 부서 목록을 보여주기 -->
          <!--"depts?.length == 0" => ???-->
          <tr v-if="depts == null || depts.length === 0">
            <td colspan="4">등록된 사용자 정보가 없습니다.</td>
          </tr>
          <!--v-if와 v-for은 같이 쓰면 안되므로, template과 같은 가상 Tag를 통해 Wrapping!-->
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
