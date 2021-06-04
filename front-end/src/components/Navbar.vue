<template>
  <div id="nav">
    <img src="https://image.shutterstock.com/image-photo/couple-kayaking-together-mangrove-river-260nw-1325112503.jpg"/>
    <div class="nav_links">
        <router-link to="/">Home</router-link> 
        <router-link to="/tourSpots">Tour Spots</router-link> 
        <router-link v-if="!logged" to="/logIn">Login</router-link>
        <router-link v-if="!logged" to="/register">Register</router-link> 
        <router-link v-if="logged" to="/mybookings">My Bookings</router-link>
        <router-link v-if="logged" to="/logOut">Logout</router-link>
    </div>
  </div>
  <router-view />
</template>

<script>
import { defineComponent } from "vue"

export default defineComponent({
  name: "SearchBar",
  data(){
    return{
      logged:true
    }
  }
});
</script>

<style  lang="scss">
#nav {
  height: 4rem;
  width: 100%;
  background-color: #96bb7c;    
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  a {
    font-weight: bold;
    color: #184d47;
    align-self: center;
    text-decoration: none;
    &.router-link-exact-active {
      color: #c64756;
      }
  }
}
img{
    height: 100%;
    border-radius: 35px;
    margin-left: 3rem;
}

.nav_links{
    width: 70%;
    justify-content: space-evenly;
    display: flex;
}
</style>