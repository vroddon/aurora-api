package project.aurora.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.aurora.api.entity.HeatingSource;

public interface HeatingsourceRepository extends JpaRepository<HeatingSource, Long>{

}
