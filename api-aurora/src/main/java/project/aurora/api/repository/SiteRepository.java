package project.aurora.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.aurora.api.entity.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long>{
	
	@Query(value = "SELECT primary_house FROM sites WHERE id=:siteId", nativeQuery = true)
	boolean isPrimaryHouse(@Param(value = "siteId") Long siteId);

}
