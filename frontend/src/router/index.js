import Vue from 'vue'
import VueRouter from 'vue-router'
import UserHome from '../views/UserHome.vue'
import MarketHome from '../views/MarketHome.vue'
import Map from '../views/Kakaomap'
import Slide2 from '../views/Slide2.vue'
import Slide3 from '../views/Slide3.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'UserHome',
    component: UserHome
  },
  {
    path: '/market',
    name: 'MarketHome',
    component: MarketHome
  },
  {
    path: '/map',
    name: 'map',
    component: Map
  },
  {
    path: '/slide2',
    name: 'slide2',
    component: Slide2
  },
  {
    path: '/slide3',
    name: 'slide3',
    component: Slide3
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => {
		if (err.name !== 'NavigationDuplicated') throw err;
	});
};

export default router
