<template>
  <div class="tours">
    <TourCard 
      v-for="tour in tours"
      :key="tour.id"
      :title="tour.name"
      :description="tour.description"
      :price="tour.price"
      :spots-array="tour.tourSpotsId"
      :bookings="tour.bookings"
        />
  
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import TourCard from "../Tours/TourCard.vue"; // @ is an alias to /src

export default defineComponent({
  name: "Tours",
  components: {
    TourCard,
  },
  props: {
    msg: String,
    tours: Array
  },
  methods: {
    filterByName(label: string) {
      console.log('nuenas',label)
        //this.tours = []
    }
  },
 
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.tours{
  margin: 2rem;
  width: 100%;
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  align-items: center;

}
</style>
