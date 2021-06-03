<template>
  <div class="filters">
    
    <div class="filters_bookings">
      <input type="number" name="holi" id="vlue" placeholder="Min # reservas" v-on:input= "select($event.target.value)">
    </div>
    <div class="filters_price">
      <input type="number" name="holi" id="vlue" placeholder="Max precio" v-on:input= "select($event.target.value)">
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Filters",
  props: {
    msg: String,
  },
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.filters{
    margin-top: 2rem;
    display: flex;
    flex-direction: row;
}
.filters_bookings{
}
</style>
