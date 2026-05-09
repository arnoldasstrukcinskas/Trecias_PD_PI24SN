package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle;

import jakarta.persistence.*;

@Table(name = "vehicles")
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year_start")
    private int yearStart;

    @Column(name = "drive")
    private String drive;

    @Column(name = "segment")
    private String segment;

    @Column(name = "total_power")
    private String totalPower;

    @Column(name = "acceleration_0_100_kmh")
    private String acceleration0100Kmh;

    @Column(name = "vehicle_fuel_equivalent")
    private String vehicleFuelEquivalent;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "battery_id")
    private Battery battery;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "charger_id")
    private Charger charger;

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

    public String getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(String totalPower) {
        this.totalPower = totalPower;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
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

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Charger getCharger() {
        return charger;
    }

    public void setCharger(Charger charger) {
        this.charger = charger;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearStart=" + yearStart +
                ", drive='" + drive + '\'' +
                ", segment='" + segment + '\'' +
                ", totalPower='" + totalPower + '\'' +
                ", acceleration0100Kmh='" + acceleration0100Kmh + '\'' +
                ", vehicleFuelEquivalent='" + vehicleFuelEquivalent + '\'' +
                ", battery=" + battery +
                ", charger=" + charger +
                '}';
    }
}
