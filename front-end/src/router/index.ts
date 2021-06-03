import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";
import LogIn from "../views/LogIn.vue";
import Register from "../views/Register.vue";
import MyBookings  from "../views/MyBookings.vue";
import Tour from "../views/TourDetail.vue";
import TourSpots from "../views/TourSpots.vue";

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
  {
    path: "/tour",
    name: "Tours",
    component: Tour
  },
  {
    path: "/tourSpots",
    name: "Tour Spots",
    component: TourSpots
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
