package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.repository;

import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
