package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Analysis;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Battery;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Charger;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Vehicle;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.AnalyzerService;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.CarAnalysisService;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO.AnalysisDto;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/analysis")
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

    @GetMapping
    public ResponseEntity<String> makeAnalysis(@RequestParam String message) throws JsonProcessingException {
        List<Vehicle> cars = carAnalysisService.getMemmoryVehicles();

        if (message.isEmpty() && message.isBlank()){
            return ResponseEntity.badRequest().build();
        }

        String response = analyzerService.createCarsAnalysis(cars, message);

        this.temporraryAnalysis = new Analysis();
        this.temporraryAnalysis.setAnalysis(response);
        this.temporraryAnalysis.setVehicles(cars);

        return ResponseEntity.ok(response);

    }

    @PostMapping
    public ResponseEntity<Analysis> saveAnalysis() throws InvalidObjectException {
        if (this.temporraryAnalysis == null){
            return ResponseEntity.notFound().build();
        }

        var response = carAnalysisService.addAnalysisToDb(temporraryAnalysis);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> RemoveAnalysisFromDb(@PathVariable int id) throws InvalidObjectException {
        if( id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var response = carAnalysisService.removeAnalysisFromDb(id);

        return ResponseEntity.noContent().build();
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
    public ResponseEntity<EntityModel<AnalysisDto>> GetAnalysisById(@PathVariable int id) throws InvalidObjectException {
        if( id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var analysis = carAnalysisService.getAnalysisFromDbById(id);
        var analysisDto = new AnalysisDto();
        analysisDto.setId(analysis.getId());
        analysisDto.setAnalysis(analysis.getAnalysis());

        EntityModel<AnalysisDto> model = EntityModel.of(analysisDto);

        model.add(linkTo(methodOn(AnalysisController.class)
                .GetAnalysisVehicles(id))
                .withRel("vehicles"));

        return ResponseEntity.ok(model);
    }

    @GetMapping("/{analysisId}/vehicles")
    public ResponseEntity<CollectionModel<EntityModel<VehicleDto>>> GetAnalysisVehicles (@PathVariable int analysisId) throws InvalidObjectException {

        Analysis analysis = carAnalysisService.getAnalysisFromDbById(analysisId);

        if (analysis == null) {
            return ResponseEntity.notFound().build();
        }
        List<EntityModel<VehicleDto>> vehicleModels = new ArrayList<>();

        for(Vehicle vehicle : analysis.getVehicles()){
            VehicleDto vehicleDto = new VehicleDto(vehicle);

            EntityModel<VehicleDto> model = EntityModel.of(vehicleDto);

               model.add(linkTo(methodOn(AnalysisController.class)
                    .GetVehicleBattery(analysisId, vehicle.getId()))
                    .withRel("battery"));

            model.add(linkTo(methodOn(AnalysisController.class)
                    .GetVehicleCharger(analysisId, vehicle.getId()))
                    .withRel("charger"));

            vehicleModels.add(model);
        }

        CollectionModel<EntityModel<VehicleDto>> collectionModel = CollectionModel.of(vehicleModels);

         return ResponseEntity.ok(collectionModel);
    }

    @GetMapping("/{analysisId}/vehicles/{vehicleId}")
    public ResponseEntity<EntityModel<VehicleDto>> GetAnalysisVehicle(@PathVariable int analysisId,
                                                      @PathVariable int vehicleId) throws InvalidObjectException {

        Analysis analysis = carAnalysisService.getAnalysisFromDbById(analysisId);

        if (analysis == null) {
            return ResponseEntity.notFound().build();
        }

        Vehicle vehicle = analysis.getVehicles()
                .stream()
                .filter(v -> v.getId() == vehicleId)
                .findFirst()
                .orElse(null);

        VehicleDto vehicleDto = new VehicleDto(vehicle);

        EntityModel<VehicleDto> model = EntityModel.of(vehicleDto);

        model.add(linkTo(methodOn(AnalysisController.class)
                .GetVehicleBattery(analysisId, vehicleId))
                .withRel("battery"));

        model.add(linkTo(methodOn(AnalysisController.class)
                .GetVehicleCharger(analysisId, vehicleId))
                .withRel("charger"));

        return ResponseEntity.ok(model);
    }

    @GetMapping("/{analysisId}/vehicles/{vehicleId}/charger")
    public ResponseEntity<Charger> GetVehicleCharger(@PathVariable int analysisId,
                                                     @PathVariable int vehicleId) throws InvalidObjectException {

        Analysis analysis = carAnalysisService.getAnalysisFromDbById(analysisId);

        if (analysis == null) {
            return ResponseEntity.badRequest().build();
        }

        Vehicle vehicle = analysis.getVehicles()
                .stream()
                .filter(v -> v.getId() == vehicleId)
                .findFirst()
                .orElse(null);

        Charger charger = vehicle.getCharger();

        return ResponseEntity.ok(charger);
    }

    @GetMapping("/{analysisId}/vehicles/{vehicleId}/battery")
    public ResponseEntity<Battery> GetVehicleBattery(@PathVariable int analysisId,
                                                     @PathVariable int vehicleId) throws InvalidObjectException {

        Analysis analysis = carAnalysisService.getAnalysisFromDbById(analysisId);

        if (analysis == null) {
            return ResponseEntity.badRequest().build();
        }

        Vehicle vehicle = analysis.getVehicles()
                .stream()
                .filter(v -> v.getId() == vehicleId)
                .findFirst()
                .orElse(null);

        Battery battery = vehicle.getBattery();

        return ResponseEntity.ok(battery);
    }
}
