package project.aurora.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.aurora.api.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
