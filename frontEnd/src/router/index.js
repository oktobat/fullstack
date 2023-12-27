import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('../views/HomeView.vue')
  },
  {
    path: '/getHopeBooks',
    name: 'getHopeBooks',
    component: () => import('../views/HopeBooksView.vue')
  },
  {
    path: '/getHopeBookForm',
    name: 'getHopeBookForm',
    component: () => import('../views/HopeBookFormView.vue')
  },
  {
      path: '/photoReview',
      name: 'photoReview',
      component: () => import('../views/PhotoReviewView.vue')
    }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
