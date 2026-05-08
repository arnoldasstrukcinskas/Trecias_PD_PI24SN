package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VechicleDto {

    private String make;
    private String model;
    private int yearStart;
    private String drive;
    private String Segment;
    private int totalPower;
    private float acceleration0100Kmh;
    private float vehicleFuelEquivalent;

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
        return Segment;
    }

    public void setSegment(String segment) {
        Segment = segment;
    }

    public int getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(int totalPower) {
        this.totalPower = totalPower;
    }

    public float getAcceleration0100Kmh() {
        return acceleration0100Kmh;
    }

    public void setAcceleration0100Kmh(float acceleration0100Kmh) {
        this.acceleration0100Kmh = acceleration0100Kmh;
    }

    public float getVehicleFuelEquivalent() {
        return vehicleFuelEquivalent;
    }

    public void setVehicleFuelEquivalent(float vehicleFuelEquivalent) {
        this.vehicleFuelEquivalent = vehicleFuelEquivalent;
    }
}
