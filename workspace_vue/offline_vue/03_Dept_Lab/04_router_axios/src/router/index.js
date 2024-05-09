import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      // name -> Named Router
      component: HomeView
      // HomeView는 이미 불러온 상태
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('@/views/AboutView.vue')
      // 함수형 Component 불러오기 => 불릴 때 Component를 가져온 것
      // 필요한 시점엘 Loading하는 방식으로 설계된 것이다.
    },
    {
      path: '/dept',
      name: 'dept',
      component: () => import('@/views/DeptView.vue'),
      // children 속성은 부모의 Path를 이어서 사용할 수 있게 해준다.
      // DeptView에 등록되어 있는 RouterLink는 DeptView의 Children에서 Route를 찾는다.
      children: [
        {
          path: 'form',
          name: 'dept_form',
          component: () => import('@/components/DeptForm.vue')
        },
        {
          path: 'detail/:no', // -> /dept/detail/10 형태, 지금은 BackEnd를 안하고 있기에, 목록이 Unique한 정보를 주었지만, 나중에는 BackEnd에서 가져올 것이다.
          name: 'dept_detail',
          component: () => import('@/components/DeptDetail.vue'),
          props: true // :no을 굳이 Route의 Params를 통해 받을 필요가 없이, 받아낼 수 있다.
        }
      ]
    }
  ]
})

export default router
