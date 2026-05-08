package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ExternalApiService {

    private final RestClient restClient;
    private final String apiKey;

    public ExternalApiService(RestClient restClient, @Value("${external.api.key}") String apiKey) {
        this.restClient = restClient;
        this.apiKey = apiKey;
        System.out.println(apiKey);
    }

    public List<ResponseDto> getEvByMake(String make){
        System.out.println("Calling external API: electricvehicle?model=" + make);
        List<ResponseDto> eVehicle = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("v1/electricvehicle")
                        .queryParam("make", make)
                        .build())
                .header("X-Api-Key", apiKey)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ResponseDto>>() {});
        return eVehicle;
    }
}
