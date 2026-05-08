package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle;

import jakarta.persistence.*;

@Table(name = "charger")
@Entity
public class Charger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "charge_port")
    private String chargePort;

    @Column(name = "charge_port_location")
    private String chargePortLocation;

    @Column(name = "charge_power")
    private String chargePower;

    @Column(name = "charge_speed")
    private String chargeSpeed;

    @Column(name = "charge_power_max")
    private String chargePowerMax;

    @Column(name = "charge_power_10p_80p")
    private String chargePower10p80p;

    @Column(name = "autocharge_supported")
    private String autochargeSupported;

    @Column(name = "plug_charge_supported")
    private String plugChargeSupported;

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

    @Override
    public String toString() {
        return "Charger{" +
                "id=" + id +
                ", chargePort='" + chargePort + '\'' +
                ", chargePortLocation='" + chargePortLocation + '\'' +
                ", chargePower='" + chargePower + '\'' +
                ", chargeSpeed='" + chargeSpeed + '\'' +
                ", chargePowerMax='" + chargePowerMax + '\'' +
                ", chargePower10p80p='" + chargePower10p80p + '\'' +
                ", autochargeSupported='" + autochargeSupported + '\'' +
                ", plugChargeSupported='" + plugChargeSupported + '\'' +
                '}';
    }
}
