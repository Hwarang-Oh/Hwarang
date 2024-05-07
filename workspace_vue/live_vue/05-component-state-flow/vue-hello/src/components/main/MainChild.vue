<script setup>
import MainChildItem from '@/components/main/MainChildItem.vue';

// 1. props 배열 선언
// defineProps(['myMsg']);

// 2. props 객체 선언
const props = defineProps({
  // Validation도 가능하다
  // 재밌는 점은 myMsg의 Type을 Number로 정의해도, 경고만 뜨고 실행은 된다.
  myMsg: String,
});
// props.myMsg = 'aaaa';
// => props의 직접적인 Data를 바꾸는 것은 허용 X
// props라는 proxy 객체를 반환할 수 있다. => 이를 가공해서 사용할 수 있음.

console.log(props);
const childMsg = 'child에서 가공 : ' + props.myMsg;

const emit = defineEmits(['someEvent']);
const moreMoney = () => {
  // 돈의 액수와 함께 부모에게 정보를 넘겨야 한다!!
  // $emit() -> Template에서 호출하는 것 -> Script에서는 X
  emit('someEvent', 10);
};

const changeName = (name) => {};
</script>

<template>
  <div class="child">
    <h1>MainChild 입니다.</h1>
    <div>MainChild : {{ myMsg }}</div>
    <button @click="$emit('someEvent')">More Money</button>
    <button @click="moreMoney">More More Money</button>
    <!-- <MainChildItem child-msg="childMsg" /> -->
    <!-- 이렇게 전달되면 "childMsg"라는 문자열이 전달되는 것임. -> JS에 정의된 변수임을 알리고자 v-bind를 사용해야 함. -->
    <MainChildItem :child-msg="childMsg" @change-name="changeName" v-for="i in 3" />
  </div>
</template>

<style scoped>
.child {
  background-color: antiquewhite;
}
</style>
