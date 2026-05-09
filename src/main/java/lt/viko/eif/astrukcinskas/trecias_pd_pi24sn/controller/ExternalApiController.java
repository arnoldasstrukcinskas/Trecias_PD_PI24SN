package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.controller;

import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.CarAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.ExternalApiService;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO.ResponseDto;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    @Autowired
    private CarAnalysisService carAnalysisService;


    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseDto>> getVehicle(@RequestParam String make,
                                                  @RequestParam(required = false) String model,
                                                  @RequestParam(required = false) Integer totalPower){
        var response = externalApiService.getVehicle(make, model, totalPower);

        if (response == null){
            ResponseEntity.badRequest().build();
        }

        carAnalysisService.addCarsToMemory(response);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<String> clearVehicleMemmory(){
        var response = carAnalysisService.clearVehicleMemmory();

        if (response == null){
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(response);
    }
}
