package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle;

import jakarta.persistence.*;

@Table(name = "battery")
@Entity
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "battery_type")
    private String batteryType;

    @Column(name = "battery_number_of_cells")
    private String batteryNumberOfCells;

    @Column(name = "battery_architecture")
    private String batteryArchitecture;

    @Column(name = "battery_useable_capacity")
    private String batteryUsableCapacity;

    @Column(name = "battery_cathode_material")
    private String batteryCathodeMaterial;

    @Column(name = "battery_pack_configuration")
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

    public String getBatteryArchitecture() {
        return batteryArchitecture;
    }

    public void setBatteryArchitecture(String batteryArchitecture) {
        this.batteryArchitecture = batteryArchitecture;
    }

    public String getBatteryUsableCapacity() {
        return batteryUsableCapacity;
    }

    public void setBatteryUsableCapacity(String batteryUsableCapacity) {
        this.batteryUsableCapacity = batteryUsableCapacity;
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

    @Override
    public String toString() {
        return "Battery{" +
                "id=" + id +
                ", batteryType='" + batteryType + '\'' +
                ", batteryNumberOfCells='" + batteryNumberOfCells + '\'' +
                ", batteryArchitecture='" + batteryArchitecture + '\'' +
                ", batteryUsableCapacity='" + batteryUsableCapacity + '\'' +
                ", batteryCathodeMaterial='" + batteryCathodeMaterial + '\'' +
                ", batteryPackConfiguration='" + batteryPackConfiguration + '\'' +
                '}';
    }
}
