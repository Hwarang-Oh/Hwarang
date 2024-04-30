<script setup>
import { ref } from 'vue'
// ex2_1
const koTitle = ref('모네 인사이드')
const enTitle = ref('monet-inside')
const artMuseum = ref('예술의 전당')
const museumURL = ref('https://www.sac.or.kr/')
const description = ref(
  '<p><모네 인사이드> 는 빛의 화가 <b>클로드 모네</b>가 남긴 소중한 명작들을 현대적 감각으로 재해석해 음악과 함께 감상하는 미디어아트 전시입니다.</p>'
)
// ex2_2
const count = ref(0)
const increament = () => {
  count.value++
}
const decreament = () => {
  count.value--
  if (count.value == -1) count.value = 0
}
// ex2_3
const selectedClass = ref('is-selected')
const requiredClass = ref('is-required')
const select = () => {
  if ()
}
</script>

<template>
  <h1>다양한 전시 정보</h1>
  <hr />
  <ul>
    <li :id="enTitle">
      전시 선택 <input type="checkbox" @click="select" />
      <h3>{{ koTitle }}</h3>
      <p v-html="description"></p>
      <hr />
      <p>{{ artMuseum }}</p>
      <a v-bind:href="museumURL">전시장 바로가기</a>
      <hr />
      <p>입장권 구매하기</p>
      <div>
        인원 수 : {{ count }}명 <button @click="increament">+</button
        ><button @click="decreament">-</button>
      </div>
      <p>총 입장료 : {{ 1000 * count }}원</p>
    </li>
  </ul>
</template>

<style scoped></style>
