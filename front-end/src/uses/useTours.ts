import { onMounted, ref, Ref } from "vue";
import { Tour } from "@/types/Tour";
import { apiTours } from "@/services/apiTours";

export function useTours() {
  const tours: Ref<Tour[]> = ref([]);

  onMounted(async () => {
    // products.value = await apiProducts.getProducts();
    tours.value = await apiTours.getToursApi();
  });

  return { tours };
}