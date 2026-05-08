package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Analysis;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Vehicle;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.AnalyzerService;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.CarAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AnalysisController {

    @Autowired
    private final AnalyzerService analyzerService;

    @Autowired
    private final CarAnalysisService carAnalysisService;

    private Analysis temporraryAnalysis;

    public AnalysisController(AnalyzerService carAnalysisService, CarAnalysisService carAnalysisService1) {
        this.analyzerService = carAnalysisService;
        this.carAnalysisService = carAnalysisService1;
    }

    @GetMapping("/analysis")
    public ResponseEntity<String> makeAnalysis(@RequestParam String message) throws JsonProcessingException {
        List<Vehicle> cars = carAnalysisService.getMemmoryVehicles();

        String response = analyzerService.createCarsAnalysis(cars, message);

        this.temporraryAnalysis = new Analysis();
        this.temporraryAnalysis.setAnalysis(response);
        this.temporraryAnalysis.setVehicles(cars);

        return ResponseEntity.ok(response);

    }

    @PostMapping("/addAnalysis")
    public ResponseEntity<Analysis> AddAnalysisDoDb() throws InvalidObjectException {
        if (this.temporraryAnalysis == null){
            return ResponseEntity.notFound().build();
        }

        var response = carAnalysisService.addAnalysisToDb(temporraryAnalysis);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Analysis> RemoveAnalysisFromDb(@PathVariable int id) throws InvalidObjectException {
        if( id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var response = carAnalysisService.removeAnalysisFromDb(id);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Analysis> UpdateAnalysisInDb(@PathVariable int id,
                                                       @RequestParam String prompt) throws InvalidObjectException, JsonProcessingException {
        if( id <= 0 || prompt.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var response = carAnalysisService.updateAnalysisInDb(id, prompt);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analysis> GetAnalysisById(@PathVariable int id) throws InvalidObjectException {
        if( id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var response = carAnalysisService.getAnalysisFromDbById(id);

        return ResponseEntity.ok(response);
    }
}
