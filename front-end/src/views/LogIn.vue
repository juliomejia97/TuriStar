<template>
  <div class="login_container">
    <form class="login">
        <label class="username">Username</label>
        <input id="name" v-model="name" placeholder="write username" type="text" name="name" />
        <label for="password">Password</label>
        <input id="password" v-model="age" placeholder="write password" type="password" />
        <button class="red_button" type="submit" value="Enviar">Iniciar sesión</button>
    </form>
  </div>
</template>

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

  input {
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