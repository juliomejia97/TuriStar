<template>
  <Navbar/>
</template>

<script lang="ts">
import { defineComponent} from "vue";
import Navbar from "@/components/Navbar.vue";
export default defineComponent({
  name: "App",
  components: {
    Navbar,
  },
});

</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
body{
  margin: 0;
  padding: 0;
}
.red_button {
        background: #c64756;
        color: #fff;
        border-color: transparent;
        text-decoration: none;
        border-radius: 6rem;
        font-size: 1em;
        padding: 1rem 1.5rem;
    }
    .red_button:hover:enabled{
        background: #fad586;
        color: #000;
    }
    [disabled]{
      background: grey;
    }

</style>
