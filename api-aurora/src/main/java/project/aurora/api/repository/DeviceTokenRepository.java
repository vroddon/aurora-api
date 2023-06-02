package project.aurora.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.aurora.api.entity.DeviceToken;

public interface DeviceTokenRepository extends JpaRepository<DeviceToken, Long>{

}
