package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDto {

    // Basic fields
    private String make;

    private String model;

    @JsonProperty("year_start")
    private int yearStart;

    private String drive;

    private String Segment;

    @JsonProperty("total_power")
    private String totalPower;

    @JsonProperty("acceleration_0_100_kmh")
    private String acceleration0100Kmh;

    @JsonProperty("vehicle_fuel_equivalent")
    private String vehicleFuelEquivalent;

    //Battery fields
    @JsonProperty("battery_type")
    private String batteryType;

    @JsonProperty("battery_number_of_cells")
    private String batteryNumberOfCells;

    @JsonProperty("battery_architecture")
    private String batteryArchitecture;

    @JsonProperty("battery_useable_capacity")
    private String batteryUseableCapacity;

    @JsonProperty("battery_cathode_material")
    private String batteryCathodeMaterial;

    @JsonProperty("battery_pack_configuration")
    private String batteryPackConfiguration;

    // Charger fields

    @JsonProperty("charge_port")
    private String chargePort;

    @JsonProperty("charge_port_location")
    private String chargePortLocation;

    @JsonProperty("charge_power")
    private String chargePower;

    @JsonProperty("charge_speed")
    private String chargeSpeed;

    @JsonProperty("charge_power_max")
    private String chargePowerMax;

    @JsonProperty("charge_power_10p_80p")
    private String chargePower10p80p;

    @JsonProperty("autocharge_supported")
    private String autochargeSupported;

    @JsonProperty("plug_charge_supported")
    private String plugChargeSupported;

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

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getVehicleFuelEquivalent() {
        return vehicleFuelEquivalent;
    }

    public void setVehicleFuelEquivalent(String vehicleFuelEquivalent) {
        this.vehicleFuelEquivalent = vehicleFuelEquivalent;
    }

    public String getBatteryNumberOfCells() {
        return batteryNumberOfCells;
    }

    public void setBatteryNumberOfCells(String batteryNumberOfCells) {
        this.batteryNumberOfCells = batteryNumberOfCells;
    }

    public String getBatteryArchitecture() {
        return batteryArchitecture;
    }

    public void setBatteryArchitecture(String batteryArchitecture) {
        this.batteryArchitecture = batteryArchitecture;
    }

    public String getBatteryUseableCapacity() {
        return batteryUseableCapacity;
    }

    public void setBatteryUseableCapacity(String batteryUseableCapacity) {
        this.batteryUseableCapacity = batteryUseableCapacity;
    }

    public String getBatteryCathodeMaterial() {
        return batteryCathodeMaterial;
    }

    public void setBatteryCathodeMaterial(String batteryCathodeMaterial) {
        this.batteryCathodeMaterial = batteryCathodeMaterial;
    }

    public String getBatteryPackConfiguration() {
        return batteryPackConfiguration;
    }

    public void setBatteryPackConfiguration(String batteryPackConfiguration) {
        this.batteryPackConfiguration = batteryPackConfiguration;
    }

    public String getChargePort() {
        return chargePort;
    }

    public void setChargePort(String chargePort) {
        this.chargePort = chargePort;
    }

    public String getChargePortLocation() {
        return chargePortLocation;
    }

    public void setChargePortLocation(String chargePortLocation) {
        this.chargePortLocation = chargePortLocation;
    }

    public String getChargePower() {
        return chargePower;
    }

    public void setChargePower(String chargePower) {
        this.chargePower = chargePower;
    }

    public String getChargeSpeed() {
        return chargeSpeed;
    }

    public void setChargeSpeed(String chargeSpeed) {
        this.chargeSpeed = chargeSpeed;
    }

    public String getChargePowerMax() {
        return chargePowerMax;
    }

    public void setChargePowerMax(String chargePowerMax) {
        this.chargePowerMax = chargePowerMax;
    }

    public String getChargePower10p80p() {
        return chargePower10p80p;
    }

    public void setChargePower10p80p(String chargePower10p80p) {
        this.chargePower10p80p = chargePower10p80p;
    }

    public String getAutochargeSupported() {
        return autochargeSupported;
    }

    public void setAutochargeSupported(String autochargeSupported) {
        this.autochargeSupported = autochargeSupported;
    }

    public String getPlugChargeSupported() {
        return plugChargeSupported;
    }

    public void setPlugChargeSupported(String plugChargeSupported) {
        this.plugChargeSupported = plugChargeSupported;
    }
}
