<template>
  <div class="filters">
    <div class="filters_bookings">
      <input
        type="number"
        id="vlue"
        placeholder="Min # reservas"
        v-on:input="inputMin($event.target.value)"
      />
    </div>
    <div class="filters_price">
      <input
        type="number"
        id="vlue"
        placeholder="Max precio"
        v-on:input="inputMax($event.target.value)"
      />
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
  methods: {
    inputMin: function (event: any) {
      this.$emit("filterByBookings", event);
    },
    inputMax: function (event: any) {
      this.$emit("filterByPrice", event);
    },
  },
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.filters {
  margin-top: 2rem;
  display: flex;
  flex-direction: row;
  width: 80%;
  justify-content: space-evenly;
}
.filters input {
  padding: 1rem;
  border-radius: 10px;
  outline: none;
  background-color: #4aa96c85;
  border: none;
}

</style>
