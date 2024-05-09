import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/quiz',
      name: 'quiz',
      redirect: 'quiz/list',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('@/views/QuizView.vue'),
      children: [
        {
          path: 'list',
          name: 'quiz_list',
          component: () => import('@/components/QuizList.vue')
        },
        {
          path: 'create',
          name: 'quiz_create',
          component: () => import('@/components/QuizCreate.vue')
        },
        {
          path: 'detail/:pk',
          name: 'quiz_detail',
          component: () => import('@/components/QuizDetail.vue')
        }
      ]
    }
  ]
})

export default router
