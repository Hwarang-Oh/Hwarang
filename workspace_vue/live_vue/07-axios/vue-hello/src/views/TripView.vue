<script setup>
import { ref } from 'vue'
import axios from 'axios'
import vCard from '@/components/vCard.vue'

const attractionName = ref('')
const attractions = ref([])

const serachAttractionByName = () => {
  // 해당 Part를 Axios를 사용할 수 있음 (직접 사용하는 Method)
  axios.get("~~~~", "~~~~").then(({ data }) => {
    attractions.value = data.response.body.Items.items
  })
  // https://apis.data.go.kr/B551011/KorService1/searchKeyword1?
  // serviceKey = achd2XS22Ewnyyh1h1 % 2F % 2FVT5GOayHGPrV94Dk2aev3fbYlbVTDjt4BSEW22Yprr2as2oeDY5QvrR % 2FuHedoT2pqA % 3D % 3D
  //   & numOfRows=10
  //   & pageNo=1
  //   & MobileOS=ETC
  //   & MobileApp=AppTest
  //   & _type=json
  //   & listYN=Y
  //   & arrange=A
  //   & keyword=% EA % B0 % 95 % EC % 9B % 90
  //   & contentTypeId=12
  // ServiceKey 관리법!!
}

const params = ref({
  // API 상세 설명에 변수명과 변수에 대한 설명이 담겨 있음
    & numOfRows=10
    & pageNo=1
    & MobileOS=ETC
    & MobileApp=AppTest
    & _type=json
    & listYN=Y
    & arrange=A
    & keyword=% EA % B0 % 95 % EC % 9B % 90
    & contentTypeId=12
})

console.log(import.meta.env);
const {vue_}
</script>

<template>
  <div class="container-fluid">
    <div class="alert alert-info" role="alert">관광지 목록</div>
    <div class="row g-3 align-items-center justify-content-center mb-3">
      <div class="col-auto">
        <label for="attractionName" class="col-form-label">관광지명</label>
      </div>
      <div class="col-auto">
        <input type="text" id="attractionName" class="form-control" v-model.lazy="attractionName" />
      </div>
      <div class="col-auto">
        <span class="form-text">
          <button type="button" class="btn btn-warning" @click="serachAttractionByName">
            검색
          </button>
        </span>
      </div>
    </div>
    <div class="row">
      <vCard />
    </div>
  </div>
</template>

<style scoped></style>
