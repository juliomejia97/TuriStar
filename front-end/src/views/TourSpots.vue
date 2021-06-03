<template>
  <div class="filterTitle">
    <h1>Search by country</h1>
    <select class="select-items">
      <option class="select-items" value="0">All</option>
      <option class="select-items" value="1">Colombia</option>
      <option class="select-items" value="2">US</option>
      <option class="select-items" value="3">Spain</option>
    </select>
  </div>
  <div class="tourSpots">
    <TourSpotCard />
    <TourSpotCard />
    <TourSpotCard />
    <TourSpotCard />
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
    spots: Array,
  },
  data() {
    return {
      title: "3 Increíbles Destinos en Bogotá!!",
      description:
        "Iniciamos la experiencia, recogiendo a los viajeros en Unicentro un centro comercial muy tradicional de Bogotá. Posteriormente saldremos de la ciudad por la Autopista Norte, con rumbo a nuestra extraordinaria experiencia. Alrededor de una hora y media después, llegaremos a nuestro primer destino, La laguna de Guatavita, en el que realizaremos una visita guiada por nativos de la zona.",
      price: "$180.000 COP",
    };
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
