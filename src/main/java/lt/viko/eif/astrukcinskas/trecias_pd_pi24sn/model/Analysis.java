package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Vehicle;

import java.util.List;

@JsonPropertyOrder({
        "id",
        "vehicles",
        "analysis"
})
@Table(name = "analysis")
@Entity
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Lob
    @Column(name = "ai_analysis", columnDefinition = "TEXT")
    private String analysis;

    @ManyToMany
    @Column(name = "vehicles")
    private List<Vehicle> vehicles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
