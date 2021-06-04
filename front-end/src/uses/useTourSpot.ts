import { apiTourSpots } from "@/services/apiTourSpots";
import { Tour } from "@/types/Tour";
import { TourSpot } from "@/types/TourSpot";
import { ref, Ref } from "vue";
import { onMounted } from "vue";


export function useTourSpot() {
    const tourSpots: Ref<TourSpot[]> = ref([]);
  
    onMounted(async () => {

        tourSpots.value =await apiTourSpots.getTourSpotApi();
    });
  
    return { tourSpots };
  }