import { deptAxios } from '@/utils/axios'

const deptAPI = deptAxios()

const getList = (success, fail) => {
  // get의 첫번째 요소 : URL
  // 똑같이 목록을 달라고 요청하는 친구들이 여러 명이 있다면,
  // 목록의 어떻게 줄 지는, 호출하는 쪽에서 결정하는 것이 맞다.
  deptAPI.get('api/depts').then(success).catch(fail)
}

const register = (dept, success, fail) => {
  deptAPI.post('/api/depts', dept).then(success).catch(fail)
}

// 수정, 삭제, 상세조회

const getDetail = (deptno, success, fail) => {
  deptAPI.get(`/api/depts/${deptno}`, deptno).then(success).catch(fail)
}

const modify = (dept, success, fail) => {
  deptAPI.put(`/api/depts/${dept.deptno}`, dept).then(success).catch(fail)
}

const remove = (deptno, success, fail) => {
  deptAPI.delete(`/api/depts/${deptno}`, deptno).then(success).catch(fail)
}

// 항상 기능은 내보내야지, 외부에서 import가 가능하다. => import with 구조분해할당 or dot Operator
export default { getList, register, getDetail, modify, remove }
