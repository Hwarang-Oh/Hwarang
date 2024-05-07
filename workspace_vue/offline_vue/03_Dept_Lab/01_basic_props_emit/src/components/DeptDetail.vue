<script setup>
import { reactive, ref, watch, watchEffect } from 'vue'
const props = defineProps(['selectedDept'])
// const dept = reactive({})

const dept = ref({})
// const dept = ref({ deptno: 10, dname: '개발 1팀', loc: '서울' })
// 수정이 없다면, 그냥 props 대신 바로 dept로 받고 뿌려도 된다.

// selectedDept는 계속 바뀔 수 있다. 한번만 받아내는 것이 아닌, 여러번 받아낼 수 있기 때문에, 계속 받아내는 데이터가 달라진다.
// 이런 경우에는 watch를 써서 관찰하면서, 바꿔줘야 한다.
// 한번만 바뀌는거면 그냥 한번만 clone따면 되지만, 지금 상황은 조금 더 복잡하다.

// ref Version
watch(
  // selectedDept가 바뀔 때 마다 새로운 dept를 만들어내자!!
  props.selectedDept,
  (n) => {
    console.log(dept.value)
    // 아래처럼 반응형 객체의 속성을 바꾸려면, reactive로 설계하는 것이 더 좋다.
    /*
    dept.value.deptno = n.deptno
    dept.value.dname = n.dname
    dept.value.loc = n.loc
    */
    // 반응형 객체 ref의 value 속성을 아예 바꿈 => {...n} 에서 spread 연산자를 통해서 달성함.
    dept.value = { ...n } // ref 객체에서만 가능한 것!! -> value값을 바꾼 것, dept 자체를 바꾼 것이 아니다!!
  },
  {
    immediate: true
  }
)

// watch(
//   // selectedDept가 바뀔 때 마다 새로운 dept를 만들어내자!!
//   props.selectedDept,
//   (n) => {
//     dept.deptno = n.deptno
//     dept.dname = n.dname
//     dept.loc = n.loc
//   },
//   {
//     immediate: true
//   }
// )
/*
watchEffect(() => {
  // immediate : true를 기본으로 가지고 있고, Computed와 같이 여러개를 watch하고 변경을 탐지하고, 자연스럽게 CallBack된다.
  // 또한 다수의 값을 보고 있기 때문에, Old Value에 대한 값을 가지고 있을 수 없다. ( 무엇이 바뀔지 모르기 때문이다.)
  dept.deptno = props.selectedDept.deptno
  dept.dname = props.selectedDept.dname
  dept.loc = props.selectedDept.loc
})
*/

const emit = defineEmits(['modifyDept', 'removeDept'])
const modifyDept = () => {
  emit('modifyDept', dept.value)
}
const removeDept = () => {
  emit('removeDept', dept.value)
}
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
              <input type="button" value="수정" class="btn btn-warning m-1" @click="modifyDept" />
              <input type="button" value="삭제" class="btn btn-dark m-1" @click="removeDept" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<style scoped></style>
