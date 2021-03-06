import Vue from 'vue'
import App from './App.vue'
import axios from 'axios' // import axios
import router from './router'
import Notifications from 'vue-notification'

Vue.use(Notifications)
Vue.prototype.$axios = axios;

Vue.config.productionTip = false

new Vue({
  render: h => h(App),

  router,
}).$mount('#app')
