import { City } from "@/types/City";
//import toursApi from "@/services/tours";
import { cities_all } from "@/config/urls";

export const apiCities = {

  getToursApi(): Promise<City[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(cities_all);
    const config = {
      method: "GET",
      header: {"mode": "no-cors"}

    };
    return fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al cargar los tours");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
};