package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.controller;

import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Vehicle;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.CarAnalysisService;
import org.hibernate.boot.model.internal.CreateKeySecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.ExternalApiService;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO.ResponseDto;

import java.util.List;

@RestController
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    @Autowired
    private CarAnalysisService carAnalysisService;


    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/make")
    public ResponseEntity<List<ResponseDto>> getEvByMake(@RequestParam String make){
        var response = externalApiService.getEvByMake(make);

        carAnalysisService.addCarsToMemory(response);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/model")
    public ResponseEntity<List<ResponseDto>> getEvByModel(@RequestParam String model){
        var response = externalApiService.getEvByModel(model);

        carAnalysisService.addCarsToMemory(response);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/totalPower")
    public ResponseEntity<List<ResponseDto>> getEvByTotalPower(@RequestParam int totalPower){
        var response = externalApiService.getEvByTotalPower(totalPower);

        carAnalysisService.addCarsToMemory(response);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/makeAndModel")
    public ResponseEntity<List<ResponseDto>> getEvByMakeAndModel(@RequestParam String make,
                                                                 @RequestParam String model){
        var response = externalApiService.getEvByMakeAndModel(make, model);

        carAnalysisService.addCarsToMemory(response);

        return ResponseEntity.ok(response);
    }
}
