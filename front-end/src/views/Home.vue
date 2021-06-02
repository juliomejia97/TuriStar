<template>
  <div class="home">
    <SearchBar msg="This is a search bar" />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import SearchBar from "@/components/Home/SearchBar.vue"; // @ is an alias to /src

export default defineComponent({
  name: "Home",
  components: {
    SearchBar,
  },
});
</script>
