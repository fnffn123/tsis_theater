import Vue from 'vue'
import Router from 'vue-router'
import MovieChoicePage from '@/components/MovieChoicePage'
import SeatChoicePage from '@/components/SeatChoicePage'
import ReservationPage from '@/components/ReservationPage'
import ReservationCheckPage from '@/components/ReservationCheckPage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: MovieChoicePage,
      name:'MovieChoicePage'
    },
    {
      path:'/seat',
      component:SeatChoicePage,
      name:'SeatChoicePage'
    },
    {
      path:'/reservation',
      component:ReservationPage,
      name:'ReservationPage'
    },
    {
      path:'/check',
      component:ReservationCheckPage,
      name:'ReservationCheckPage'
    }
  ]
})
