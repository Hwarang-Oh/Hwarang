<script setup>
import { reactive } from 'vue'
const BusinessCard = reactive({ cardno: '', name: '', job: '', img: '' })
// List에 넘겨야 하는데, 바로 넘길 수가 없음 -> View에 넘겨줘야 한다
// View에 넘겨주고 (emit), View는 바로 List에 넘겨야 하는데 (props), List 입장에서는 props가 언제 오고 바뀔지 모르므로, watch하고 있어야 한다.
const emit = defineEmits(['registerCard'])

const registerCard = () => {
  // payload를 감싸지 않고, 그 객체 자체를 payload로 준 형태
  emit('registerCard', BusinessCard) // emit은 동기적으로 된다. => 끝내고 오면 reset한다
  reset()
}

const reset = () => {
  BusinessCard.cardno = ''
  BusinessCard.name = ''
  BusinessCard.job = ''
  BusinessCard.img = ''
}
</script>

<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-primary text-light text-center">아이돌 등록</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <tr>
            <th><label for="cardno">Idol Num</label></th>
            <td>
              <input type="text" name="cardno" v-model.lazy="BusinessCard.cardno" />
            </td>
          </tr>
          <tr>
            <th><label for="dname">Name</label></th>
            <td>
              <input type="text" name="name" id="name" v-model.lazy="BusinessCard.name" />
            </td>
          </tr>
          <tr>
            <th><label for="loc">Job</label></th>
            <td>
              <input type="text" name="job" id="job" v-model.lazy="BusinessCard.job" />
            </td>
          </tr>
          <tr>
            <th><label for="loc">Img</label></th>
            <td>
              <input type="text" name="img" id="img" v-model.lazy="BusinessCard.img" />
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2">
              <input type="button" value="등록" class="btn btn-warning m-1" @click="registerCard" />
              <input type="reset" value="취소" class="btn btn-info m-1" @click="reset" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<style scoped></style>
