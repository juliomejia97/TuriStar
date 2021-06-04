<template>
  <div class="filterTitle">
    <h1>Search by country</h1>
    <select class="select-items">
      <option>Select here</option>
      <option  v-for="choice in cities " v-bind:key="choice.id" >{{ choice.country }}</option>
    </select>
  </div>
  <div class="tourSpots" v-for="choice in cities " v-bind:key="choice.id"  >

    <TourSpotCard 
      v-for="tourSpot in choice.tourSpots"
      :key='tourSpot.id'
      :photo="tourSpot.photos[0]"
      :title="tourSpot.name"
      :description="tourSpot.description  "
        />
    
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import TourSpotCard from "../components/Tours/TourSpotCard.vue"; // @ is an alias to /src
import { useCities } from "@/uses/useCities";

export default defineComponent({
  name: "Tour",
  components: {
    TourSpotCard,
  },
  props: {
    spots: Array,
  },
  setup() {
    const { cities } = useCities();
    console.log(cities)
    return { cities };
  },
});
</script>

<style  lang="scss">
.tourSpots {
  margin-top: 5rem;
  width: 100%;
  display: flex;
  justify-content: column;
  flex-wrap: wrap;
}

.select-items {
  background-color: #c64756;
  color: #ffffff;
  width: 60%;
  padding: 8px 16px;
  font-size: 2rem;
  border: 1px solid transparent;
  border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
}

.filterTitle{
    text-align: center;    
}
</style>
