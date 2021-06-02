import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";
import LogIn from "../views/LogIn.vue";
import Register from "../views/Register.vue";
import MyBookings  from "../views/MyBookings.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/logIn",
    name: "LogIn",
    component: LogIn
  },
  {
    path: "/register",
    name: "Register",
    component: Register
  },
  {
    path: "/myBookings",
    name: "MyBookings",
    component: MyBookings
  },

];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
