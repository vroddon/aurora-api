package project.aurora.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.aurora.api.entity.PasswordCode;

@Repository
public interface PasswordCodeRepository  extends JpaRepository<PasswordCode, String>{
	Optional<PasswordCode> findByEmailAndConfirmationCode(String email, String confirmationCode);

}
