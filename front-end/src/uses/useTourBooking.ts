import { onMounted, ref, Ref } from "vue";
import { TourBooking } from "../types/TourBooking";
import { apiTourBookings } from "../services/apiTourBooking";
import { tour_booking } from "../config/urls";

export function useTourBooking() {
  const tourBooking: Ref<TourBooking> = ref({tourBookingId:"bb5f8ac3-b90d-40ec-b3e2-e0ca3f432735", tourBookingInitDate:new Date(), tourBookingEndDate:new Date(), tourId:"bb5f8ac3-b90d-40ec-b3e2-e0ca3f432735", userId:"bb5f8ac3-b90d-40ec-b3e2-e0ca3f432735"});

  async function bookTour(){
    
    await apiTourBookings.bookTourApi(tourBooking.value)
}

  return { tourBooking,bookTour };
}