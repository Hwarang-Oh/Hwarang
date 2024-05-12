<script setup>
import { ref, watch, inject } from 'vue'
import deptAPI from '@/apis/dept'

const { reloadDepts } = inject('service')
const detailNum = defineProps(['no'])
const deptDetails = ref({})

const reset = () => {
  deptDetails.value.deptno = ''
  deptDetails.value.dname = ''
  deptDetails.value.loc = ''
}

watch(
  detailNum,
  (newValue) => {
    deptAPI.getDetail(
      newValue.no,
      (response) => {
        deptDetails.value = { ...response.data } // Assuming response structure contains data field
        console.log('Department details updated:', deptDetails.value)
      },
      () => {
        console.error('Failed to retrieve department details!')
        deptDetails.value = {} // Optionally reset details on error
      }
    )
  },
  {
    immediate: true
  }
)

const modifyDept = () => {
  deptAPI.modify(
    deptDetails.value,
    () => {
      reloadDepts()
      // register에 성공하면 => Post 요청에 대해 성공 응답이 옴 -> 갱신이 되면서 List가 watch하고 있는 isReload가 바뀜 => 그에 따라 목록을 가져오는 요청을 다시 보냄
    },
    () => {
      console.log('부서 수정 실패')
    }
  )
}

const removeDept = () => {
  deptAPI.remove(
    deptDetails.value.deptno,
    () => {
      reloadDepts()
      reset()
      // register에 성공하면 => Post 요청에 대해 성공 응답이 옴 -> 갱신이 되면서 List가 watch하고 있는 isReload가 바뀜 => 그에 따라 목록을 가져오는 요청을 다시 보냄
    },
    () => {
      console.log('부서 삭제 실패')
    }
  )
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
          <tr>
            <th><label for="deptno">부서번호</label></th>
            <td>
              <input type="text" name="deptno" id="deptno" v-model="deptDetails.deptno" readonly />
            </td>
          </tr>
          <tr>
            <th><label for="dname">부서이름</label></th>
            <td>
              <input type="text" name="dname" id="dname" v-model.lazy="deptDetails.dname" />
            </td>
          </tr>
          <tr>
            <th><label for="loc">지역</label></th>
            <td>
              <input type="text" name="loc" id="loc" v-model.lazy="deptDetails.loc" />
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
