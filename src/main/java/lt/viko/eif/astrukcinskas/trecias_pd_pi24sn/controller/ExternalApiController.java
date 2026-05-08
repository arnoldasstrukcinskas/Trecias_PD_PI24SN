package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.ExternalApiService;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.ResponseDto;

import java.util.List;

@RestController
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/model")
    public ResponseEntity<List<ResponseDto>> getCarByModel(@RequestParam String model){
        var response = externalApiService.getEvByMake(model);

        return ResponseEntity.ok(response);
    }

}
