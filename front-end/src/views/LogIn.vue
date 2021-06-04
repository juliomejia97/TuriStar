<template>
  <div class="login_container">
    <form class="login">
        <label for="email">Email</label>
        <input id="email" class="textfield" v-model="user.email" placeholder="write email" type="text" name="email" />
        <label for="password">Password</label>
        <input id="password" class="textfield" v-model="user.password" placeholder="write password" type="password" />
        <input @click="login" type="button" class="red_button" value="Iniciar sesión" :disabled="submitEnabled" />
    </form>
  </div>
</template>

<script>
import { useLogin } from '@/uses/useLogin';
import { computed, defineComponent } from 'vue'

export default defineComponent({
  setup() {
    const { user, login } = useLogin();

    const submitEnabled = computed(() => {
      let emailValidate = user.value.email !== null && user.value.email !== "";
      let passwordValidate = user.value.password !== null && user.value.password !== "";
      return !(emailValidate && passwordValidate)
    });
    return {user, login, submitEnabled}
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

  .textfield {
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