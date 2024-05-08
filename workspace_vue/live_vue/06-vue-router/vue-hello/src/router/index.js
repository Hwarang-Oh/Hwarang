import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import UserView from '@/views/UserView.vue'
import LoginView from '@/views/LoginView.vue'
import { createLogger } from 'vite'

// Before니까 이전에 하면 좋겠다 -> 이러면 안됨 => Hoisting이 일어나도, 선언되기 전이다.
/*
router.beforeEach((to, from) => {
  console.log('beforeEach 호출!!!')
})
*/

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/user/:id',
      name: 'user',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: UserView,
      beforeEnter: (to, from) => {
        // 영상 봐야 하는 부분
        console.log(to)
        console.log(from)
      }
    },
    {
      path: '/login',
      name: 'login',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: LoginView,
      beforeEnter: (to, from) => {
        const isLogin = true
        if (isLogin === true) {
          console.log('로그인 상태')
          return { name: 'home' }
        }
      }
    }
  ]
})

// beforeEach의 to 와 from은 무엇일까?
// to : 이동할 url정보를 지닌 router 객체
// from : 현재 url정보를 지닌 router 객체
// 공식 홈페이지에서는 next라는 Argument도 알려준다.
/*
router.beforeEach((to, from, next) => {
  // to and from are both route objects. must call `next`.
  next()
})
*/

/* // 전역 Guard인 beforeEach 주석
router.beforeEach((to, from) => {
  console.log('beforeEach 호출!!!')
  console.log(to)
  console.log(from)
})

router.beforeEach((to, from) => {
  // Stack Overflow -> Login 창에서도 Login 여부를 체크하고 돌려보내기에, 무한 loop가 발생함
  const isLogin = false
  if (!isLogin && to.name !== 'login') {
    console.log('로그인이 필요합니다.')
    return { name: 'login' }
  }
})
*/

export default router
