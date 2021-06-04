import { onMounted, ref, Ref } from "vue";
import { City } from "@/types/City";
import { apiCities } from "@/services/apiCities";

export function useCities() {
  const cities: Ref<City[]> = ref([]);

  onMounted(async () => {
    // products.value = await apiProducts.getProducts();
    cities.value = await apiCities.getToursApi();
  });

  return { cities };
}