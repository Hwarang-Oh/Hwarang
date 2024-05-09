<script setup>
import { reactive, provide, readonly } from 'vue'
import { useRouter, RouterView } from 'vue-router'

const router = useRouter()
const selectedQuiz = reactive({})
const quiz = reactive({})

const quizList = reactive([
  {
    pk: 1,
    question: 'Python 웹 프레임워크 중 하나로, 마이크로 웹 프레임워크로 빠른 개발을 지원하는 것은?',
    answer: 'flask'
  },
  {
    pk: 2,
    question: 'HTML에서 텍스트 입력란을 만드는 데 사용되는 요소는?',
    answer: 'input'
  },
  {
    pk: 3,
    question:
      '웹 애플리케이션에서 클라이언트의 데이터를 서버로 전송할 때 주로 사용되는 HTTP 메서드는?',
    answer: 'post'
  },
  {
    pk: 4,
    question: 'Python의 가상 환경을 만들어 프로젝트 별로 라이브러리 의존성을 격리시키는 명령어는?',
    answer: 'virtualenv'
  },
  {
    pk: 5,
    question:
      '웹 애플리케이션을 개발할 때, 사용자의 브라우저에 보여지는 부분을 렌더링하는 언어는 무엇인가요?',
    answer: 'html'
  }
])

provide('res', {
  quiz: quiz,
  quizList: readonly(quizList),
  selectedQuiz: readonly(selectedQuiz)
})

const restoreQuizPk = () => {
  for (const idx in quizList) {
    quizList[idx].pk = parseInt(idx) + 1
  }
}

const createQuiz = (payload) => {
  quiz.pk = quizList.length + 1
  quiz.question = payload.question
  quiz.answer = payload.answer
  quizList.push({ ...quiz })
  router.push('/quiz/list')
}

const modifyQuiz = (payload) => {
  for (const idx in quizList) {
    if (quizList[idx].pk == payload.pk) {
      quizList[idx].question = payload.question
      quizList[idx].answer = payload.answer
      break
    }
  }
  router.push('/quiz/list')
}

const deleteQuiz = (payload) => {
  for (const idx in quizList) {
    if (quizList[idx].pk === payload) {
      quizList.splice(idx, 1)
      restoreQuizPk()
      break
    }
  }
  router.replace('/quiz/list')
}

const getDetail = (payload) => {
  // QuizList에서 호출됨
  console.log(payload.data)
  selectedQuiz.pk = payload.data.pk
  selectedQuiz.question = payload.data.question
  selectedQuiz.answer = payload.data.answer
}

provide('service', {
  getDetail,
  createQuiz,
  modifyQuiz,
  deleteQuiz
})
</script>

<template>
  <RouterView />
</template>

<style scoped></style>
