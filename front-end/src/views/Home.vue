<template>
  <div class="home">
    <SearchBar msg="This is a search bar"      
     @filterByName="filterByName"
    />
    <Filters msg="This is a filter" @filterByBookings="filterByBookings" @filterByPrice="filterByPrice" />
    <Tours msg=" Tours" :tours="tours_filtered.tours.value"/>

  </div>
</template>

<script lang="ts">
import { defineComponent,computed  } from "vue";
import SearchBar from "@/components/Home/SearchBar.vue"; // @ is an alias to /src
import Filters from "@/components/Home/Filters.vue"; // @ is an alias to /src
import Tours from "@/components/Home/Tours.vue"; // @ is an alias to /src
import { useTours } from "@/uses/useTours";
import { Tour } from "@/types/Tour";

export default defineComponent({
  name: "Home",
  components: {
    SearchBar,
    Filters,
    Tours,
  },
  methods: {
     
    filterByName(label: string): void {
      var PATTERN = label 
      this.tours_filtered.tours.value =this.tours.filter(function (str) { return str.name.includes(PATTERN); });
    },
    filterByBookings(label: number): void {
     if (label) {
       this.tours_filtered.tours.value =this.tours.filter(function (str) { return str.bookings<=label });
     }
     else{
        this.tours_filtered.tours.value =this.tours

      }
    },
    filterByPrice(label: number): void {
      console.log('aver3',label)

      if (label) {
        this.tours_filtered.tours.value =this.tours.filter(function (str) { return str.price<label });
      }else{
        this.tours_filtered.tours.value =this.tours

      }
    }
  },
  
  setup() {
    const { tours } = useTours();
    const tours_filtered  = useTours();
    console.log(tours_filtered.tours)
    return {tours,tours_filtered};
  },

   data () {
    return {
      loading: false,
      post: null,
      error: null,
      filtered: ''
    }
  }
});



</script>
<style lang="scss">
.home{
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>


