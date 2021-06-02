<template>
  <div class="tourcard">
    <h2>{{ title }}</h2>  
    <h6>{{ description }}</h6>
    <h4>{{ price }}</h4>

    <div class="tourcard_spots">
      <h6
        v-for="spot in spotsArray"
        :key="spot.name"
        :spot="spot"
      > {{ spot  }}</h6>
    </div>
    </div>
    

</template>

<script>
export default {

  props: {
    title: String,
    description: String,
    price: String ,
    ["spots-array"]: Array
  },
}
</script>

<style>
.tourcard{
    border: 2px solid #70707070;
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 30%;
    min-width: 300px;
    margin: 1rem;
}
</style>