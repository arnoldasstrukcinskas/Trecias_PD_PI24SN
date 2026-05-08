package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BatteryDto {

    private String batteryType;
    private String batteryNumberOfCells;
    private int batteryArchitecture;
    private float batteryUseableCapacity;
    private String batteryCathodeMaterial;
    private String batteryPackConfiguration;

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBatteryNumberOfCells() {
        return batteryNumberOfCells;
    }

    public void setBatteryNumberOfCells(String batteryNumberOfCells) {
        this.batteryNumberOfCells = batteryNumberOfCells;
    }

    public int getBatteryArchitecture() {
        return batteryArchitecture;
    }

    public void setBatteryArchitecture(int batteryArchitecture) {
        this.batteryArchitecture = batteryArchitecture;
    }

    public String getBatteryCathodeMaterial() {
        return batteryCathodeMaterial;
    }

    public void setBatteryCathodeMaterial(String batteryCathodeMaterial) {
        this.batteryCathodeMaterial = batteryCathodeMaterial;
    }

    public float getBatteryUseableCapacity() {
        return batteryUseableCapacity;
    }

    public void setBatteryUseableCapacity(float batteryUseableCapacity) {
        this.batteryUseableCapacity = batteryUseableCapacity;
    }

    public String getBatteryPackConfiguration() {
        return batteryPackConfiguration;
    }

    public void setBatteryPackConfiguration(String batteryPackConfiguration) {
        this.batteryPackConfiguration = batteryPackConfiguration;
    }
}
