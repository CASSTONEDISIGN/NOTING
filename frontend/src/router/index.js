import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'home',
      
      component: () => import('../views/HomeView.vue')
    },
    {
      path: '/login/deligate',
      name: 'deligate',
      component: () => import('../views/Login/DeligateLoginView.vue')
    },
    {
      path: '/login/customer',
      name: 'customer',
      component: () => import('../views/Login/CustomerLoginView.vue')
    },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
