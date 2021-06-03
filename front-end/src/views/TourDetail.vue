<template>
    <div class="tourInfo">
        <div class="tourdetail">
            <div class="tourtitle">
                <h1>{{title}}</h1>
                <p>{{description}}</p>
            </div>
            <div class="tourbooking">
                <button id="pricetag">Reserva ya por {{price}}!</button>
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

export default defineComponent({
  name: "Tour",
  components: {
    TourSpotCard,
  },
  props: {
    spots: Array
  },
  data(){
      return {
        title: "3 Increíbles Destinos en Bogotá!!",
        description: "Iniciamos la experiencia, recogiendo a los viajeros en Unicentro un centro comercial muy tradicional de Bogotá. Posteriormente saldremos de la ciudad por la Autopista Norte, con rumbo a nuestra extraordinaria experiencia. Alrededor de una hora y media después, llegaremos a nuestro primer destino, La laguna de Guatavita, en el que realizaremos una visita guiada por nativos de la zona.",
        price: "$180.000 COP"
    }
  }
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
