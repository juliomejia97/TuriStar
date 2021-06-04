import { Tour } from "@/types/Tour";
//import toursApi from "@/services/tours";
import { tours_all } from "@/config/urls";

export const apiTours = {
//   getTours(): Promise<Tour[]> {
//     return new Promise((resolve) => {
//       resolve(toursApi);
//     });
//   },

  getToursApi(): Promise<Tour[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(tours_all);
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

  getTourApi(id: string): Promise<Tour> {
    const url = process.env.VUE_APP_BASE_URL.concat(tours_all + "/" + id);
    const config = {
      method: "GET",
      header: {"mode": "no-cors"}

    };
    return fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al cargar el tour");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  }
};