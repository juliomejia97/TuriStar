import { onMounted, ref, Ref } from "vue";
import { Tour } from "@/types/Tour";
import { apiTours } from "@/services/apiTours";

export function useTour(id: string) {
  const tour: Ref<Tour> = ref({name:"", price:0, id:"", bookings:0, description:"",tourSpotsId:[]});
  onMounted(async () => {
    tour.value = await apiTours.getTourApi(id);
  });

  return { tour };
}