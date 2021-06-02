<template>
  <div class="home">
    <SearchBar msg="This is a search bar" />
    <Filters msg="This is a filter" />
    <Tours msg=" Tours" />
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
});
</script>
<style lang="scss">
.home{
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
