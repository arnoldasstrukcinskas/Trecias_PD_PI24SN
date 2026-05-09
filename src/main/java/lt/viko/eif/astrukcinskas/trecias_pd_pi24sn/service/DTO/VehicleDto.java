package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Vehicle;


@JsonPropertyOrder({
        "id",
        "make",
        "model",
        "yearStart",
        "drive",
        "segment",
        "totalPower",
        "acceleration0100Kmh",
        "vehicleFuelEquivalent"
})
public class VehicleDto {

    private int id;
    private String make;
    private String model;
    private int yearStart;
    private String drive;
    private String segment;
    private String totalPower;
    private String acceleration0100Kmh;
    private String vehicleFuelEquivalent;

    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.make = vehicle.getMake();
        this.model = vehicle.getModel();
        this.yearStart = vehicle.getYearStart();
        this.totalPower = vehicle.getTotalPower();
        this.drive = vehicle.getDrive();
        this.acceleration0100Kmh = vehicle.getAcceleration0100Kmh();
        this.vehicleFuelEquivalent = vehicle.getVehicleFuelEquivalent();
        this.segment = vehicle.getSegment();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearStart() {
        return yearStart;
    }

    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(String totalPower) {
        this.totalPower = totalPower;
    }

    public String getAcceleration0100Kmh() {
        return acceleration0100Kmh;
    }

    public void setAcceleration0100Kmh(String acceleration0100Kmh) {
        this.acceleration0100Kmh = acceleration0100Kmh;
    }

    public String getVehicleFuelEquivalent() {
        return vehicleFuelEquivalent;
    }

    public void setVehicleFuelEquivalent(String vehicleFuelEquivalent) {
        this.vehicleFuelEquivalent = vehicleFuelEquivalent;
    }
}
