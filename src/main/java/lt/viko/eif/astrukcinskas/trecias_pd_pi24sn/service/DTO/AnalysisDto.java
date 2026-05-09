package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Analysis;

@JsonPropertyOrder({
        "id",
        "analysis"
})
public class AnalysisDto {

    private int id;
    private String analysis;

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
}
