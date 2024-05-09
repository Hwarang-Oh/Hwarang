<script setup>
import { reactive, ref, watch, inject } from 'vue'
import { useRouter } from 'vue-router'
import deptAPI from '@/apis/dept'

const { isReload } = inject('res') // isReload 자체가 반응형! inject로 가져옴
const depts = ref([])
// 이제는 Back에서 목록을 통채로 가져오는 방식이다. => 그렇기에, ref로 관리하는 것이 더 좋다.
// ref는 value 속성을 통해 접근하기 때문에, ref 사용

const router = useRouter()
const changeForm = () => {
  // => 조건부 Rendering을 위한 Code였음. -> 이제는 Router를 통한 전환 처리만 해주면 됨
  // changeMode({ mode: 'register' })
  router.push('/dept/form')
  // 왜 /dept도 함께 push하는 것일까?
}

const pickDept = (index) => {
  changeMode({ data: depts[index] })
  router.push(`/dept/detail/${depts[index].deptno}`)
}

// 240509 추가

// API 호출 -> getList ( success callBack, fail CallBack )
// 한 번만 일어나는 형태가 아님 -> 여러번 일어나기에, Method화 and watch에 넣어주기!!
const getDepts = () => {
  deptAPI.getList(
    ({ data }) => (depts.value = data),
    () => console.log('목록 조회 실패!!')
  )
}
watch(isReload, () => getDepts(), { immediate: true }) // 어차피 SetUp은 한번 무조건 처음에 되어야 하기 때문에, immediate
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
