package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.repository;

import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnalysisRepository extends JpaRepository<Analysis, Integer> {

}
