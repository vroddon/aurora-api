package project.aurora.api.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.aurora.api.entity.HouseholdData;

public interface HouseholdDataRepository extends JpaRepository<HouseholdData, Long>{

	Optional<HouseholdData> findByIdAndUserId(Long id, Long userId);
	List<HouseholdData> findAllByUserId(Long userId);
	
	@Query(value = "SELECT COUNT(1) FROM household_data where user_id=:userId", nativeQuery = true)
	int existUser(@Param(value = "userId") Long userId);
	
	@Query(value = "SELECT distinct site_id FROM household_data WHERE user_id=:userId", nativeQuery = true)
	List<Long> getSiteIds(@Param(value = "userId") Long userId);
	
	@Query(value = "SELECT sum(number_of_days) as NOD, sum(electricity_consumption_per_capita) as ECPC, sum(thermal_consumption_per_capita) as TCPC, sum(emissions_electricity_consumption) as EEC, sum(emissions_thermal_consumption) as ETC FROM household_data WHERE user_id=:userId", nativeQuery = true)
	Map<String,Object> getSummaryUser(@Param(value = "userId") Long userId);
	
	@Query(value = "SELECT sum(number_of_days) as NOD, sum(electricity_consumption_per_capita) as ECPC, sum(thermal_consumption_per_capita) as TCPC, sum(emissions_electricity_consumption) as EEC, sum(emissions_thermal_consumption) as ETC FROM household_data WHERE user_id=:userId AND site_id=:siteId", nativeQuery = true)
	Map<String,Object> getSummaryUserPerSite(@Param(value = "userId") Long userId, @Param(value = "siteId") Long siteId);
}
