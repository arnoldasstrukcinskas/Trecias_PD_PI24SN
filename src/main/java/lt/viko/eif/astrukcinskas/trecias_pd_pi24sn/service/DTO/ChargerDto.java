package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChargerDto {

    private String chargePort;
    private String chargePortLocation;
    private int chargePower;
    private int chargeSpeed;
    private int chargePowerMax;
    private int chargePower10p80p;
    private String autochargeSupported;
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

    public int getChargePower() {
        return chargePower;
    }

    public void setChargePower(int chargePower) {
        this.chargePower = chargePower;
    }

    public int getChargeSpeed() {
        return chargeSpeed;
    }

    public void setChargeSpeed(int chargeSpeed) {
        this.chargeSpeed = chargeSpeed;
    }

    public int getChargePowerMax() {
        return chargePowerMax;
    }

    public void setChargePowerMax(int chargePowerMax) {
        this.chargePowerMax = chargePowerMax;
    }

    public int getChargePower10p80p() {
        return chargePower10p80p;
    }

    public void setChargePower10p80p(int chargePower10p80p) {
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
