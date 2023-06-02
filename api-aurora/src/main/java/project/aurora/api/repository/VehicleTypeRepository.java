package project.aurora.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.aurora.api.entity.VehicleType;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long>{

}
