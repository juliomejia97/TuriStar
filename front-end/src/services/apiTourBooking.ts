import { tour_booking } from "../config/urls";
import { TourBooking } from "../types/TourBooking";

export const apiTourBookings = {

  bookTourApi(tourBooking: TourBooking) {
    const url = process.env.VUE_APP_BASE_URL.concat(tour_booking);
    const config = {
      method: "POST",
      headers: {
        "mode": "no-cors",
        "Content-type":"application/json"
      },
      body: JSON.stringify(tourBooking)
    };
    return fetch(url, config)
      .then((response) => {
        
        alert("Reserva exitosa")
        return response.json();
      })
      .catch((error) => {
        console.log(error)
        throw error;
      });
  },
};