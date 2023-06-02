package project.aurora.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.aurora.api.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, String>{
	Boolean existsByAccessToken(String accessToken);
	Optional<Token> findByAccessToken(String accessToken);
	Optional<Token> findByRefreshToken(String refreshToken);

}
