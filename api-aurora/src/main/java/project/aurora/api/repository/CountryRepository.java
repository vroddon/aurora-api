package project.aurora.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.aurora.api.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}
