package project.aurora.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.aurora.api.entity.EmailCode;

@Repository
public interface EmailCodeRepository  extends JpaRepository<EmailCode, String>{
	Optional<EmailCode> findByEmailAndConfirmationCode(String email, String confirmationCode);

}
