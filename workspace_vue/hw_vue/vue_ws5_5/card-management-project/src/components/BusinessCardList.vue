<script setup>
import BusinessCard from './BusinessCard.vue'
import { computed, reactive, ref, watch } from 'vue'

const props = defineProps(['BusinessCard'])

watch(props.BusinessCard, (n) => {
  BusinessCardList.push({ ...n })
})

const BusinessCardList = reactive([
  {
    cardno: 10,
    name: '호시노 아이',
    job: '1세대 전설 최애의 아이',
    img: '/src/assets/Hoshino_AI.png'
  },
  {
    cardno: 20,
    name: '호시노 루비',
    job: '2세대 신성 최애의 아이',
    img: '/src/assets/Ruby.gif'
  },
  {
    cardno: 30,
    name: '아리마 카나',
    job: '붉은머리가 어울리는 미인',
    img: '/src/assets/Arima_Kana.png'
  },
  {
    cardno: 40,
    name: 'MEM쵸',
    job: '진심 목소리 개짜증나는 사람',
    img: '/src/assets/Mem.png'
  },
  {
    cardno: 50,
    name: '쿠로카와 아카네',
    job: '일본 극단 배우의 정점',
    img: '/src/assets/Akane.png'
  }
])

const removeNum = ref(0)
const removeCard = (payload) => {
  removeNum.value = payload
}
watch(removeNum, (n) => {
  for (const idx in BusinessCardList) {
    if (BusinessCardList[idx].cardno === n) {
      BusinessCardList.splice(idx, 1)
      break
    }
  }
})

const haveCardNum = computed(() => BusinessCardList.length)
</script>

<template>
  <div>
    <h2>
      보유 아이돌 목록<span v-show="haveCardNum > 0"> : {{ haveCardNum }}</span>
    </h2>
    <div v-if="haveCardNum > 0" class="row row-cols-1 row-cols-md-2 g-4">
      <BusinessCard
        v-for="BusinessCard in BusinessCardList"
        :key="BusinessCard.name"
        :BusinessCard="BusinessCard"
        @remove-card="removeCard"
      />
    </div>
    <div v-else><p>아이돌이 없습니다. 새로운 아이돌을 영입해 주세요</p></div>
  </div>
</template>

<style scoped></style>
