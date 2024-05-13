<script setup>
import { ref, watch, inject } from 'vue'
import { useRouter } from 'vue-router'
import deptAPI from '@/apis/dept'

// 240513
import { useDeptStore } from '@/stores/dept'
const deptStore = useDeptStore()

// 240513 End
const { isReload } = inject('res')
const depts = ref([])

// Assignment
const router = useRouter()
const changeForm = () => {
  router.push('/dept/form')
}

const pickDept = (index) => {
  router.push(`/dept/detail/${depts.value[index].deptno}`)
}

const getDepts = () => {
  deptAPI.getList(
    ({ data }) => (depts.value = data),
    () => console.log('목록 조회 실패!!')
  )
}
watch(isReload, () => getDepts(), { immediate: true })
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
