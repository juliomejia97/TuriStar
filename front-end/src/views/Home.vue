<template>
  <div class="home">
    <SearchBar msg="This is a search bar"      
     @filterByName="filterByName"
    />
    <Filters msg="This is a filter" />
    <Tours msg=" Tours" :tours="filtered_tours"/>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import SearchBar from "@/components/Home/SearchBar.vue"; // @ is an alias to /src
import Filters from "@/components/Home/Filters.vue"; // @ is an alias to /src
import Tours from "@/components/Home/Tours.vue"; // @ is an alias to /src

export default defineComponent({
  name: "Home",
  components: {
    SearchBar,
    Filters,
    Tours
  },
  methods: {
    filterByName(label: string): void {

      var PATTERN = label
      let filtered: { price: number; name: string; id: 
      string; bookings: number; description: string;
      tourSpotsId: string[]; }[]
      = this.tours.filter(function (str) { return str.name.includes(PATTERN); });
      this.filtered_tours=filtered
    }
  },
  computed: {
    // a computed getter
    reversedMessage: function (label:any):any {
      // `this` points to the vm instance
      var PATTERN = label
      var filtered = this.tours.filter(function (str) { return str.name.includes(PATTERN); });
      console.log('nuenas',filtered)
      return filtered
    }
  },
   data () {
    return {
      filtered_tours: [
        {
          price: 25000.0,
          name: "TestTour",
          id: "5ade9d58-ac73-11eb-8529-0242ac130003",
          bookings: 20,
          description:"Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga",
          tourSpotsId:[]
        },
        {
          price: 30000.0,
          name: "TestTour2",
          id: "5ade9d58-ac73-11eb-8529-0242ac130005",
          bookings: 20,
          description:"Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga",
          tourSpotsId:[
            "UUID",
            "UUID",
            "UUID",
          ]
        },
        {
          price: 35000.0,
          name: "TestTour4",
          id: "5ade9d58-ac73-11eb-8529-0242ac130006",
          bookings: 10,
          description:"Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga",
          tourSpotsId:[]
        },
        {
          price: 30000.0,
          name: "TestTour2",
          id: "5ade9d58-ac73-11eb-8529-0242ac130005",
          bookings: 20,
          description:"Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga",
          tourSpotsId:[
            "UUID",
            "UUID",
            "UUID",
          ]
        }
      ],
      tours: [
        {
          price: 25000.0,
          name: "TestTour",
          id: "5ade9d58-ac73-11eb-8529-0242ac130003",
          bookings: 20,
          description:"Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga",
          tourSpotsId:[]
        },
        {
          price: 30000.0,
          name: "TestTour2",
          id: "5ade9d58-ac73-11eb-8529-0242ac130005",
          bookings: 20,
          description:"Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga",
          tourSpotsId:[
            "UUID",
            "UUID",
            "UUID",
          ]
        },
        {
          price: 35000.0,
          name: "TestTour4",
          id: "5ade9d58-ac73-11eb-8529-0242ac130006",
          bookings: 10,
          description:"Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga",
          tourSpotsId:[]
        },
        {
          price: 30000.0,
          name: "TestTour2",
          id: "5ade9d58-ac73-11eb-8529-0242ac130005",
          bookings: 20,
          description:"Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga Esta es mi descripcion que es bien larga",
          tourSpotsId:[
            "UUID",
            "UUID",
            "UUID",
          ]
        }
        
      ],
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
