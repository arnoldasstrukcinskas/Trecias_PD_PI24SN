package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service;

import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO.ResponseDto;
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
    }

    public List<ResponseDto> getVehicle(String make, String model, Integer totalPower){

        boolean hasMake = make != null && !make.isBlank();
        boolean hasModel = model != null && !model.isBlank();
        boolean hasTotalPower = totalPower != null && totalPower > 0;

        if (hasMake && !hasModel && !hasTotalPower){
            return getEvByMake(make);
        }

        if (!hasMake && hasModel && !hasTotalPower) {
            return getEvByModel(model);
        }

        if (!hasMake && !hasModel && hasTotalPower) {
            return getEvByTotalPower(totalPower);
        }

        if (hasMake && hasModel && !hasTotalPower) {
            return getEvByMakeAndModel(make, model);
        }

        return null;
    }

    public List<ResponseDto> getEvByMake(String make){
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

    public List<ResponseDto> getEvByModel(String model){
        System.out.println("Calling external API: electricvehicle?model=" + model);
        List<ResponseDto> eVehicle = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("v1/electricvehicle")
                        .queryParam("model", model)
                        .build())
                .header("X-Api-Key", apiKey)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ResponseDto>>() {});
        return eVehicle;
    }

    public List<ResponseDto> getEvByTotalPower(int totalPower){
        System.out.println("Calling external API: electricvehicle?model=" + totalPower);
        List<ResponseDto> eVehicle = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("v1/electricvehicle")
                        .queryParam("total_power", totalPower)
                        .build())
                .header("X-Api-Key", apiKey)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ResponseDto>>() {});
        return eVehicle;
    }

    public List<ResponseDto> getEvByMakeAndModel(String make, String model){
        System.out.println("Calling external API: electricvehicle?model=" + model);
        List<ResponseDto> eVehicle = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("v1/electricvehicle")
                        .queryParam("make", make)
                        .queryParam("model", model)
                        .build())
                .header("X-Api-Key", apiKey)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ResponseDto>>() {});
        return eVehicle;
    }
}
