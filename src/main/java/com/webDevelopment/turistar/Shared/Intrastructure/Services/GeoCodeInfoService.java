package com.webDevelopment.turistar.Shared.Intrastructure.Services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webDevelopment.turistar.Shared.Domain.Ports.InformationDetailService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GeoCodeInfoService  implements InformationDetailService {
    private static final String GEOCODE_RESOURCE = "https://maps.googleapis.com/maps/api/geocode/";
    private static final String API_KEY="AIzaSyCAAyegQUf9LkBGLcbcEg5ElE4we2GlA6w";

    @Override
    public Optional<List<Double>> latitudeLongitudeInfo(String tourName, String cityName) {
        String body = "json?address="+tourName.replace(" ","%20")+","+
                cityName.replace(" ","%20")+"&sensors=true&key="+API_KEY;
        String url  = GEOCODE_RESOURCE+ body;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
            GeocodeResult responseObject = new ObjectMapper().readValue(response.body(),GeocodeResult.class);
            return responseObject.getLatLong(cityName);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<String> addressInfo(String hotelName, String cityName) {
        String body = "json?address="+hotelName.replace(" ","%20")+","+
                cityName.replace(" ","%20")+"&sensors=true&key="+API_KEY;
        String url  = GEOCODE_RESOURCE+ body;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());
            GeocodeResult responseObject = new ObjectMapper().readValue(response.body(),GeocodeResult.class);
            return responseObject.getLocationAddress(cityName);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


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
        public boolean isValid(String cityName){
            Optional<AddressComponent> address = this.results.get(0).addressComponents.stream().
                    filter(name -> Normalizer.normalize(name.getLongName(),Normalizer.Form.NFKD)
                            .replaceAll("[^a-z,^A-Z,^0-9]", "")
                            .equalsIgnoreCase(Normalizer.normalize(cityName,Normalizer.Form.NFKD).
                                    replaceAll("[^a-z,^A-Z,^0-9]", ""))
                            || Normalizer.normalize(name.getShortName(),Normalizer.Form.NFKD).
                            replaceAll("[^a-z,^A-Z,^0-9]", "").
                            equalsIgnoreCase(Normalizer.normalize(cityName,Normalizer.Form.NFKD).
                                    replaceAll("[^a-z,^A-Z,^0-9]", "")))
                    .findAny();
            return this.status.equals("OK") && address.isPresent();
        }
        public Optional<List<Double>> getLatLong(String cityName){
            if(isValid(cityName)){
                List<Double> data = new ArrayList<>();
                Double latitude = Double.parseDouble(results.get(0).geometry.getGeocodeLocation().getLatitude());
                Double longitude = Double.parseDouble(results.get(0).geometry.getGeocodeLocation().getLongitude());
                data.add(latitude);
                data.add(longitude);
                return Optional.of(data);
            }else{
                return Optional.empty();
            }
        }

        public Optional<String> getLocationAddress(String cityName) {
            if(isValid(cityName)){
                return Optional.of(results.get(0).getFormattedAddress());

            }else{
                return Optional.empty();            }
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
