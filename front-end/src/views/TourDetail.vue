<template>
    <div class="tourInfo">
        <div class="tourdetail">
            <div class="tourtitle">
                <h1>{{tour.name}}</h1>
                <p>{{tour.description}}</p>
            </div>
            <div class="tourbooking">
                <button id="pricetag" class="red_button" @click="bookTour">Reserva ya por ${{tour.price}} COP!</button>
            </div>

        </div>
        <div class="tourSpots">
            <TourSpotCard/>
            <TourSpotCard/>
            <TourSpotCard/>
            <TourSpotCard/>
        </div>
    </div>
    
</template>

<script lang="ts">

import { defineComponent } from "vue";
import TourSpotCard from "../components/Tours/TourSpotCard.vue"; // @ is an alias to /src
import { useTour } from "@/uses/useTour";
import { useRoute } from 'vue-router'

export default defineComponent({
  name: "Tour",
  components: {
    TourSpotCard,
  },
  setup(){    
    const route = useRoute()
    let id = route.params.id
    const { tour } = useTour(id.toString())
    console.log(tour)
    return {tour}
  },
  data(){
      return {
        title: "3 Increíbles Destinos en Bogotá!!",
        description: "Iniciamos la experiencia, recogiendo a los viajeros en Unicentro un centro comercial muy tradicional de Bogotá. Posteriormente saldremos de la ciudad por la Autopista Norte, con rumbo a nuestra extraordinaria experiencia. Alrededor de una hora y media después, llegaremos a nuestro primer destino, La laguna de Guatavita, en el que realizaremos una visita guiada por nativos de la zona.",
        price: "$180.000 COP"
    }
  },
  methods: {
      bookTour(){
      this.$router.push('/tourBooking/'+this.$route.params.id)
    }
  },
});
</script>

<style  lang="scss">
.tourInfo{
    margin: 3rem;
}
.tourdetail{
    display: flex;
    align-content: space-between;
    margin-bottom: 5rem;
}
.tourtitle{
    padding-right: 3rem;
    text-align: justify;
}
.tourbooking{
    width: 100%;
    display: flex;
    align-items: center; 
    justify-content: center;
    #pricetag {
        font-size: 2em;
        text-decoration: none;
        padding: 1.5rem 2rem;
    }
}
.tourSpots{
  width: 100%;
  display: flex;
  justify-content: column ;
  flex-wrap: wrap;
}   
</style>
