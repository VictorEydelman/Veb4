import Vue from 'vue'
import App from './App.vue'
import Main from './Main.vue'
import Axios from 'axios'
import First from './First.vue'
Vue.prototype.$axios = Axios.create({baseUrl: '/api'})
Vue.use(VueRouter)
const routes = [
  { path: '/', name:"/",component: First },
  { path: '/first', name:"first",component: First },
  { path: '/main', name:"main",component: Main, beforeEnter:(to,from,next)=>{
    if (localStorage.getItem("jwt")!=="") next();
    else next ({name: "/"})
    } }
]

const router = new VueRouter({
  routes
})
new Vue({
  el: '#app',
  render: h => h(App),
  router
})
