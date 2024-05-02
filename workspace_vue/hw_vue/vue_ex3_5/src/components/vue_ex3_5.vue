<script setup>
import { ref, computed } from 'vue'

// ex3_1 ~ ex3_2
const exhibitions = ref([
  {
    title: '무라카미 다카시 : 무라카시좀비',
    location: '부산 시립 미술관',
    price: 1000,
    isRunning: true,
    isSelected: false
  },
  {
    title: '마우라치오 카텔란 개인전',
    location: '리움 미술관',
    price: 30000,
    isRunning: true,
    isSelected: false
  },
  {
    title: '조선백자전',
    location: '리움 미술관',
    price: 30000,
    isRunning: true,
    isSelected: false
  },
  {
    title: '한국 실험미술 1960 - 1970',
    location: '국립현대미술관',
    price: 0,
    isRunning: true,
    isSelected: false
  },
  {
    title: '에드워드 호퍼 : 길 위에서',
    location: '서울 시립 미술관',
    price: 1000,
    isRunning: false,
    isSelected: false
  },
  {
    title: '알렉산더 칼더 x 이우환',
    location: '국제갤러리 서울점',
    price: 15000,
    isRunning: false,
    isSelected: false
  }
])
// ex3_2
const isActive = ref(false)

const filteredList = computed(() =>
  isActive.value ? exhibitions.value.filter((item) => item.isRunning) : exhibitions.value
)
// ex3_3
const addDesc = (price) => {
  if (price === 0) return '이 전시는 무료입니다'
}
// ex3_4
</script>

<template>
  <div>
    <h1>다양한 전시 정보</h1>
    <label>
      전시 중인 정보만 보기
      <input type="checkbox" v-model="isActive" />
    </label>
    <ul>
      <li
        v-for="each in filteredList"
        :key="each.title"
        :class="{
          cheap: each.price <= 5000,
          expensive: each.price >= 20000,
          normal: !(each.price <= 5000 || each.price >= 20000)
        }"
      >
        <div v-if="each.isRunning === true">
          <label
            >전시 관람 하기
            <input type="checkbox" v-model="each.isSelected" />
          </label>
        </div>
        <div v-else :style="{ color: 'red' }">
          <p>전시가 종료되어 관람할 수 없습니다.</p>
        </div>
        <h2>{{ each.title }}</h2>
        <p>{{ each.location }}</p>
        <p>가격 : {{ each.price }}</p>
        <p v-html="addDesc(each.price)"></p>
        <hr />
      </li>
    </ul>
  </div>
</template>

<style scoped>
.cheap {
  background-color: #d0f0c0;
}
.normal {
  background-color: whitesmoke;
}
.expensive {
  background-color: lightcoral;
}
</style>
