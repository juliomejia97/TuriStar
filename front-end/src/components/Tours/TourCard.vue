<template>
  <div class="tourcard">
    <h2>{{ title }}</h2>
    <h6>{{ description }}</h6>
    <h4>{{ price }}</h4>
    <h4>{{ bookings }} Available</h4>

   
    <button class="red_button" @click="detailTour(id)">Ver mas...</button>
  </div>
</template>

<script>
export default {
  props: {
    id: String,
    title: String,
    description: String,
    price: String,
    ["spots-array"]: Array,
    bookings: String,
  },
  methods: {
    detailTour(id){
      this.$router.push('/tour/'+id)
    }
  },
};
</script>

<style>
.tourcard {
  border: 2px solid #70707070;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 30%;
  min-width: 300px;
  padding: 1rem;
}
.tourcard h6 {
  line-break: anywhere;
  margin: 1rem;
}
</style>