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

}
