<template>
  <div class="tourcard">
    <h2>{{ initDate }}</h2>
    <h6>{{ endDate }}</h6>
    <h4>{{ tourId }}</h4>
    <button class="red_button" @click="detailTour(title)">Ver mas...</button>
  </div>
</template>

<script>
export default {
  props: {
    key: String,
    initDate: String,
    endDate: String,
    tourId: String,
  },
  methods: {
    detailTour(title){
      this.$router.push('/tour')
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