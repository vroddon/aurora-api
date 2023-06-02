package project.aurora.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.aurora.api.entity.TransportData;

public interface TransportDataRepository extends JpaRepository<TransportData, Long>{
	Optional<TransportData> findByIdAndUserId(Long id, Long userId);
	List<TransportData> findAllByUserId(Long userId);
	
	@Query(value = "SELECT count(distinct date_of_travel) as count FROM transport_data WHERE user_id=:userId", nativeQuery = true)
	int countDistinctDateOfTravel(@Param(value = "userId") Long userId);
	
	@Query(value = "SELECT sum(energy_consumption) as energy FROM transport_data WHERE user_id=:userId", nativeQuery = true)
	float sumEnergyConsumption(@Param(value = "userId") Long userId);
	
	@Query(value = "SELECT sum(emissions) as energy FROM transport_data WHERE user_id=:userId", nativeQuery = true)
	float sumEmissions(@Param(value = "userId") Long userId);
}
