import { onMounted, ref, Ref } from "vue";
import { TourBooking } from "../types/TourBooking";
import { apiTourBookings } from "../services/apiTourBooking";
import { tour_booking } from "../config/urls";
import router from "@/router";

export function useTourBooking() {
  const tourBooking: Ref<TourBooking> = ref({tourBookingId:"", tourBookingInitDate:new Date(), tourBookingEndDate:new Date(), tourId:"", userId:""});

  async function bookTour(){
    
    await apiTourBookings.bookTourApi(tourBooking.value)
    router.push("/")
}

  return { tourBooking,bookTour };
}