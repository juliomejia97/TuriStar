import { TourSpot } from "./TourSpot";

export interface City {
    id: string; 
    country: string; 
    hotels: string[]; 
    cityActive: string;
    name: string;
    tourSpots: TourSpot[];
  }