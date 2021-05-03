package com.webDevelopment.turistar.Shared.Intrastructure.Services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webDevelopment.turistar.Administrator.City.Domain.Ports.InformationService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GeoCodeInfoService implements InformationService {
    private static final String GEOCODE_RESOURCE = "https://maps.googleapis.com/maps/api/geocode/";
    private static final String API_KEY="AIzaSyCAAyegQUf9LkBGLcbcEg5ElE4we2GlA6w";
    @Override
    public boolean validate(String cityName, String cityCountry) {
        String body = "json?address="+cityName+"&sensors=true&components=country:"+cityCountry+"&key="+API_KEY;
        HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(GEOCODE_RESOURCE+body))
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
            GeocodeResult responseObject = new ObjectMapper().readValue(response.body(),GeocodeResult.class);
            return responseObject.isValid();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //TODO: Implementar el otro servicio

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static final class GeocodeResult{
        @JsonProperty("results")
        private List<GeocodeObject> results;
        @JsonProperty("status")
        private String status;
        public GeocodeResult() {
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public List<GeocodeObject> getResults() {
            return results;
        }
        public void setResults(List<GeocodeObject> results) {
            this.results = results;
        }
        public boolean isValid(){
            return this.status.equals("OK");
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static final class GeocodeObject{
        @JsonProperty("address_components")
        private List<AddressComponent> addressComponents;
        @JsonProperty("formatted_address")
        private String formattedAddress;
        GeocodeGeometry geometry;
        public GeocodeObject() {
        }
        public List<AddressComponent> getAddressComponents() {
            return addressComponents;
        }
        public void setAddressComponents(List<AddressComponent> addressComponents) {
            this.addressComponents = addressComponents;
        }
        public String getFormattedAddress() {
            return formattedAddress;
        }
        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }
        public GeocodeGeometry getGeometry() {
            return geometry;
        }
        public void setGeometry(GeocodeGeometry geometry) {
            this.geometry = geometry;
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class AddressComponent {
        @JsonProperty("long_name")
        private String longName;
        @JsonProperty("short_name")
        private String shortName;

        public AddressComponent() {
        }
        public String getLongName() {
            return longName;
        }
        public void setLongName(String longName) {
            this.longName = longName;
        }
        public String getShortName() {
            return shortName;
        }
        public void setShortName(String shortName) {
            this.shortName = shortName;
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static final class GeocodeGeometry {
        @JsonProperty("location")
        private GeocodeLocation geocodeLocation;
        public GeocodeGeometry() {
        }
        public GeocodeLocation getGeocodeLocation() {
            return geocodeLocation;
        }
        public void setGeocodeLocation(GeocodeLocation geocodeLocation) {
            this.geocodeLocation = geocodeLocation;
        }
    }
     @JsonIgnoreProperties(ignoreUnknown = true)
     private static final class GeocodeLocation {
        @JsonProperty("lat")
        private String latitude;
        @JsonProperty("lng")
        private String longitude;
        public GeocodeLocation() {
        }
        public String getLatitude() {
            return latitude;
        }
        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }
        public String getLongitude() {
            return longitude;
        }
        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }

}
