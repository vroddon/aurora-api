package project.aurora.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.aurora.api.entity.DemoSite;

@Repository
public interface DemoSiteRepository extends JpaRepository<DemoSite, Long>{

}
