<template>
  <div class="searchbar">
    <form class="searchbar_form" action="">
      <div class="searchbar_button" >
      <input type="search" name="holi" id="vlue" placeholder="Ingrese nombre del tour..." v-on:input= "select($event.target.value)">
      
        <img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJDYXBhXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4Ig0KCSB2aWV3Qm94PSIwIDAgMzk2LjgxOSAzOTYuODE5IiBzdHlsZT0iZW5hYmxlLWJhY2tncm91bmQ6bmV3IDAgMCAzOTYuODE5IDM5Ni44MTk7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4NCjxnPg0KCTxnPg0KCQk8cGF0aCBkPSJNMzUyLjEwMyw0NC42NzljLTU5LjIzNy01OS40MDEtMTU1LjQxMi01OS41MzUtMjE0LjgxMy0wLjI5OGMtNTcuMzE2LDU3LjE1Ny01OS43NDEsMTQ5LjIxOC01LjUxNSwyMDkuMzE0bC0xMS42LDExLjYNCgkJCWMtOS4zNzItOS4zNzMtMjQuNTY4LTkuMzc1LTMzLjk0MS0wLjAwM2MtMC4wMDEsMC4wMDEtMC4wMDIsMC4wMDItMC4wMDMsMC4wMDNsLTc5LjIsNzkuMg0KCQkJYy05LjM3Myw5LjM3Mi05LjM3NSwyNC41NjgtMC4wMDMsMzMuOTQxYzAuMDAxLDAuMDAxLDAuMDAyLDAuMDAyLDAuMDAzLDAuMDAzbDExLjMxMiwxMS4zMTJjOS4zNzIsOS4zNjksMjQuNTY0LDkuMzY5LDMzLjkzNiwwDQoJCQlsNzkuMi03OS4yYzkuMzczLTkuMzcyLDkuMzc1LTI0LjU2OCwwLjAwMy0zMy45NDFjLTAuMDAxLTAuMDAxLTAuMDAyLTAuMDAyLTAuMDAzLTAuMDAzbDExLjYtMTEuNg0KCQkJYzYyLjI0LDU2LjI0NywxNTguMjkyLDUxLjM4OCwyMTQuNTM5LTEwLjg1MUM0MTEuOTQ4LDE5NC4wMzcsNDA5LjUyMSwxMDEuODU2LDM1Mi4xMDMsNDQuNjc5eiBNMTIwLjE3NSwyOTkuMjMxbC03OS4yLDc5LjINCgkJCWMtMy4xMjQsMy4xMjMtOC4xODgsMy4xMjMtMTEuMzEyLDBsLTExLjMxMi0xMS4zMmMtMy4xMTgtMy4xMjMtMy4xMTgtOC4xODEsMC0xMS4zMDRsNzkuMi03OS4yYzMuMTY0LTMuMDI1LDguMTQ4LTMuMDI1LDExLjMxMiwwDQoJCQlsMTEuMzEyLDExLjMyQzEyMy4yOTMsMjkxLjA1LDEyMy4yOTMsMjk2LjEwOCwxMjAuMTc1LDI5OS4yMzF6IE0zNDAuNzk5LDI0OC4zMjdjLTUzLjExMiw1My4xMS0xMzkuMjIzLDUzLjEwOS0xOTIuMzMzLTAuMDAzDQoJCQlzLTUzLjEwOS0xMzkuMjIzLDAuMDAzLTE5Mi4zMzNjNTMuMTExLTUzLjEwOSwxMzkuMjE5LTUzLjEwOSwxOTIuMzMsMEMzOTMuODI0LDEwOS4xMzksMzkzLjgyNCwxOTUuMTc5LDM0MC43OTksMjQ4LjMyN3oiLz4NCgk8L2c+DQo8L2c+DQo8Zz4NCgk8Zz4NCgkJPHBhdGggZD0iTTMyOS40NzksNjcuMzAzTDMyOS40NzksNjcuMzAzbC0xMS4zMTIsMTEuMzEyYzQwLjU0NSw0MC42NDQsNDAuNTQ1LDEwNi40MzYsMCwxNDcuMDhsMTEuMzEyLDExLjMxMg0KCQkJQzM3Ni4yNzUsMTkwLjExNywzNzYuMjc1LDExNC4xOTMsMzI5LjQ3OSw2Ny4zMDN6Ii8+DQoJPC9nPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=" />
      </div>
    </form>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "SearchBar",
  props: {
    msg: String,
  },
  methods: {
      select: function(event: any) {
          this.$emit('filterByName',event)
          
      }
  },
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.searchbar{
  width: 80%;
  margin-top: 4rem;
}
.searchbar_form{
  display: flex;
  
  align-items: center;
  justify-content: space-around;
}
.searchbar_form input{
  outline: none;
  padding: 1rem;
  border-radius: 30px;
  background-color: transparent;
  border: none;
  width: 80%;

}
.searchbar_button{
  border-radius: 10px;
  background-color: #4aa96c85;
  height: 3rem;
  width: 80%;
  display: flex;
  align-items: center;
}
.searchbar_button img{
  margin: 0;
  height: 1.5rem;
  border-radius: 0;
  margin: auto;
}
</style>
