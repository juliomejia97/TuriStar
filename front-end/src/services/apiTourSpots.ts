import { TourSpot } from "@/types/TourSpot";
import { tour_booking, tour_spot_all } from "../config/urls";
import { TourBooking } from "../types/TourBooking";

export const apiTourSpots = {

    getTourSpotApi(): Promise<TourSpot[]> {
        const url = process.env.VUE_APP_BASE_URL.concat(tour_spot_all);
        const config = {
          method: "GET",
          header: {"mode": "no-cors"}
        };
        return fetch(url, config)
          .then((response) => {
            if (!response.ok) {
              throw new Error("Error al cargar el tourSpot");
            }
            return response.json()
          })
          .catch((error) => {
            throw error;
          });
      }
};