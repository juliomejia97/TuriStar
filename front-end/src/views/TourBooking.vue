<template>
  <div class="login_container">
    <form class="login">
        <label for="dateInit">Start date</label>
        <input id="dateInit" v-model="name" placeholder="write username" type="date" name="name" />
        <label for="dateEnd">End date</label>
        <input id="dateEnd" v-model="name" placeholder="write username" type="date" name="name" />
        <label>The total is ${{numberWithCommas( price )}} COP</label>
        <button class="red_button" type="submit" value="Enviar">Book</button>
    </form>
  </div>
</template>

<script>
import { defineComponent } from 'vue'

export default defineComponent({
    data(){
      return{
        price: 180000
      }
    },
    methods: {
      numberWithCommas(x) {
       return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      }
    },
})
</script>

<style lang="scss">

  .login_container{
    margin-top: 10%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .login {
    width: 40%;
    padding: 2rem;
    border-radius: 2rem;
    border-style: none;
    word-wrap: normal;
    display: flex;
    flex-direction: column;
    background-color: #96bb7c;
  }

  label {
    font-weight: bold;
    font-size: 1.5rem;
    margin-bottom: 0.5rem;
  }

  .input {
    padding-left: 2rem;
    height: 3rem;
    border-style: none;
    margin-bottom: 1rem;
    border-radius: 2rem;
    font-size: 2rem;
  }

  .red_button{
    font-size: 1.5rem;
  }

</style>