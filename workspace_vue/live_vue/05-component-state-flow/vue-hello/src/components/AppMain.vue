<script setup>
import { ref } from 'vue';
import IconMain from '@/components/icons/IconMain.vue';
import MainChild from '@/components/main/MainChild.vue';

const msg = ref('SSAFY에 오신 것을 환영합니다.');
const name = ref('Hoshino Ruby');

const moreMoney = () => {
  console.log('More Money');
  msg.value = name.value + ' More Money';
  // Msg의 Value를 바꿀 수 있음 => 본인의 Data이기 때문이다.
};

const moreMyMoney = (value) => {
  // 여러개가 들어오면 ...value로 받아내면 된다!!
  console.log(value);
  msg.value = 'More Money ' + value;
};

const changeName = (cname) => {
  name.value = cname;
};
</script>

<template>
  <div class="main"><IconMain /> 화면입니다.</div>
  <!-- <MainChild @some-event="moreMoney" my-msg="SSAFY에 오신 것을 환영합니다." /> -->
  <!-- msg를 반응형 객체로 설계해서 bind를 시켜준다!! -->
  <MainChild
    @some-event="moreMoney"
    @more-money="moreMyMoney"
    @change-name="changeName"
    :my-msg="msg" />
</template>

<style scoped></style>
