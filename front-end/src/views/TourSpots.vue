<template>
  <div class="filterTitle">
    <h1>Search by country</h1>
    <select class="select-items" @change="filterByCity(sortType)"  v-model="sortType">
      <option v-for="choice in cities" v-bind:key="choice.id">
        {{ choice.country }}
      </option>
    </select>
  </div>
  <div class="tourSpots" v-for="choice in cities_filtered.cities.value" v-bind:key="choice.id">
    <TourSpotCard
      v-for="tourSpot in choice.tourSpots"
      :key="tourSpot.id"
      :photo="tourSpot.photos[0]"
      :title="tourSpot.name"
      :description="tourSpot.description"
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
    spotsFilter: Array,

  },
  setup() {
    const { cities } = useCities();
    const cities_filtered  = useCities();

    return { cities,cities_filtered};
  },
  methods: {
    filterByCity(label: string): void {
      this.cities_filtered.cities.value =this.cities.filter(function (str) { return str.country==label; });
    },
    data () {
    return {
      sortType: 'false',
      
    }
  }
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
  background-color: #4aa96c85;
  border-radius: 10pc;
  width: 30%;
  padding: 8px 16px;
}

.filterTitle {
  text-align: center;
}
</style>
