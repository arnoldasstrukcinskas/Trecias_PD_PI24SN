package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Analysis;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Battery;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Charger;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Vehicle;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.repository.AnalysisRepository;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.repository.VehicleRepository;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarAnalysisService {

    @Autowired
    private AnalysisRepository analysisRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AnalyzerService analyzerService;

    private List<Vehicle> memmoryVehicles = new ArrayList<>();

    public List<Vehicle> addCarsToMemory(List<ResponseDto> vehicles){
        if (vehicles.isEmpty())
        {
            throw new InvalidParameterException("Car analysis service: there is no vehicles for adding");
        }

        for (ResponseDto response : vehicles){
            memmoryVehicles.add(convertFromResponseToVehicle(response));
        }

        return this.memmoryVehicles;
    }

    public String clearVehicleMemmory(){
        this.memmoryVehicles = new ArrayList<>();

        return "Car analysis service: vehicle memmory cleared";
    }

    public Analysis addAnalysisToDb(Analysis analysis) throws InvalidObjectException {
        if (analysis == null)
        {
            throw new InvalidObjectException("Car analysis service: Failed to add analysis to db, missing analysis");
        }

        vehicleRepository.saveAll(analysis.getVehicles());

        var response = analysisRepository.save(analysis);

        return response;
    }

    public int removeAnalysisFromDb(int id) throws InvalidObjectException {
        if (id <= 0)
        {
            throw new IllegalArgumentException("Car analysis service: Failed to remove analysis from db, missing analysis");
        }
        Analysis analysis = getAnalysisFromDbById(id);

        if (analysis == null)
        {
            throw new InvalidObjectException("Car analysis service: Failed to remove analysis from db, such analysis do not exists");
        }

        analysisRepository.deleteById(id);

        return id;
    }

    public Analysis updateAnalysisInDb(int id, String prompt) throws InvalidObjectException, JsonProcessingException {
        if (id <= 0)
        {
            throw new IllegalArgumentException("Car analysis service: Failed to update analysis by id - {d}, wrong id".formatted(id));
        }

        Analysis analysis = getAnalysisFromDbById(id);

        String newAnalysisMessage = analyzerService.createCarsAnalysis(analysis.getVehicles(), prompt);

        analysis.setAnalysis(newAnalysisMessage);

        var response = analysisRepository.save(analysis);

        return response;
    }

    public Analysis getAnalysisFromDbById(int id) throws InvalidObjectException {
        if (id <= 0)
        {
            throw new InvalidObjectException("Car analysis service: Failed to get analysis by id, missing analysis");
        }

        var response = analysisRepository.getReferenceById(id);

        return response;
    }


    //helpers

    public List<Vehicle> getMemmoryVehicles() {
        return memmoryVehicles;
    }

    private Vehicle convertFromResponseToVehicle(ResponseDto responseDto){
        Vehicle vehicle = new Vehicle();
        vehicle.setMake(responseDto.getMake());
        vehicle.setModel(responseDto.getModel());
        vehicle.setYearStart(responseDto.getYearStart());
        vehicle.setDrive(responseDto.getDrive());
        vehicle.setSegment(responseDto.getSegment());
        vehicle.setTotalPower(responseDto.getTotalPower());
        vehicle.setAcceleration0100Kmh(responseDto.getAcceleration0100Kmh());
        vehicle.setVehicleFuelEquivalent(responseDto.getVehicleFuelEquivalent());
//        int totalPower = Integer.parseInt(responseDto.getTotalPower().split(" ")[0]);
//        vehicle.setTotalPower(totalPower);
//
//        float acceleration = Float.parseFloat(responseDto.getAcceleration0100Kmh().split(" ")[0]);
//        vehicle.setAcceleration0100Kmh(acceleration);
//
//        float vehicleFuelEquivalent = Float.parseFloat(responseDto.getVehicleFuelEquivalent().split(" ")[0]);
//        vehicle.setVehicleFuelEquivalent(vehicleFuelEquivalent);

        vehicle.setBattery(convertFromResponseToBattery(responseDto));
        vehicle.setCharger(convertFromResponseToCharger(responseDto));

        return vehicle;


    }

    private Battery convertFromResponseToBattery(ResponseDto responseDto){
        Battery battery = new Battery();
        battery.setBatteryType(responseDto.getBatteryType());
        battery.setBatteryNumberOfCells(responseDto.getBatteryNumberOfCells());
        battery.setBatteryArchitecture(responseDto.getBatteryArchitecture());
        battery.setBatteryUsableCapacity(responseDto.getBatteryUseableCapacity());

//        int batteryArchitecture = Integer.parseInt(responseDto.getBatteryArchitecture().split(" ")[0]);
//        battery.setBatteryArchitecture(batteryArchitecture);
//
//        float batteryUsableCapacity = Float.parseFloat(responseDto.getBatteryUseableCapacity().split(" ")[0]);
//        battery.setBatteryUsableCapacity(batteryUsableCapacity);

        battery.setBatteryCathodeMaterial(responseDto.getBatteryCathodeMaterial());
        battery.setBatteryPackConfiguration(responseDto.getBatteryPackConfiguration());

        return battery;
    }

    private Charger convertFromResponseToCharger(ResponseDto responseDto){
        Charger charger = new Charger();
        charger.setChargePort(responseDto.getChargePort());
        charger.setChargePortLocation(responseDto.getChargePortLocation());
        charger.setChargePower(responseDto.getChargePower());
        charger.setChargeSpeed(responseDto.getChargeSpeed());
        charger.setChargePowerMax(responseDto.getChargePowerMax());
        charger.setChargePower10p80p(responseDto.getChargePower10p80p());

//        int chargerPower = Integer.parseInt(responseDto.getChargePower().split("")[0]);
//        charger.setChargePower(chargerPower);
//
//        int chargeSpeed = Integer.parseInt(responseDto.getChargeSpeed().split(" ")[0]);
//        charger.setChargeSpeed(chargeSpeed);
//
//        int chargePowerMax = Integer.parseInt(responseDto.getChargePower().split(" ")[0]);
//        charger.setChargePowerMax(chargePowerMax);
//
//        int chargePower10p80p = Integer.parseInt(responseDto.getChargePower10p80p().split(" ")[0]);
//        charger.setChargePower10p80p(chargePower10p80p);

        charger.setAutochargeSupported(responseDto.getAutochargeSupported());
        charger.setPlugChargeSupported(responseDto.getPlugChargeSupported());

        return charger;
    }
}
