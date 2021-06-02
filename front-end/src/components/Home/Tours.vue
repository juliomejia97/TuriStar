<template>
  <div class="tours">
    <TourCard title="Mi primer tour" description="Esta es mi descripcion que es bien larga" price='2000' index="index" :spots-array="spots.map(a => a.name)"/>
    <TourCard title="Mi primer tour" description="Esta es mi descripcion que es bien larga" price='2000' index="index" :spots-array="spots.map(a => a.name)"/>
    <TourCard title="Mi primer tour" description="Esta es mi descripcion que es bien larga" price='2000' index="index" :spots-array="spots.map(a => a.name)"/>
    <TourCard title="Mi primer tour" description="Esta es mi descripcion que es bien larga" price='2000' index="index" :spots-array="spots"/>
    <TourCard title="Mi primer tour" description="Esta es mi descripcion que es bien larga" price='2000' index="index" :spots-array="spots.map(a => a.name)"/>
    <TourCard title="Mi primer tour" description="Esta es mi descripcion que es bien larga" price='2000' index="index" :spots-array="spots.map(a => a.name)"/>

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
  },
  data () {
    return {
      spots: [
        {
          name: 'Isla morada',
          required: 1,
          vMode1: ''
        },
        {
          name: 'Cartago',
          required: 3,
          vMode1: ''
        },
        {
          name: 'Ciudad Amurallada',
          required: 1,
          vMode1: ''
        }
      ]
    }
  }
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
