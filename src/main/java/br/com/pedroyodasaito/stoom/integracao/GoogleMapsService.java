package br.com.pedroyodasaito.stoom.integracao;

import br.com.pedroyodasaito.stoom.integracao.dto.LocationDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GoogleMapsService {

    public static LocationDTO getGeometry(String zipCode, String pais) {
        LocationDTO dto = new LocationDTO();
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity("https://maps.googleapis.com/maps/api/geocode/json?address="
                    +zipCode+"+"+pais+
                    "&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw", String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode results = root.path("results");
            JsonNode geometry = results.get(0).path("geometry");
            JsonNode location = geometry.path("location");
            dto.setLat(location.get("lat").asText());
            dto.setLng(location.get("lng").asText());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return dto;
    }

}
