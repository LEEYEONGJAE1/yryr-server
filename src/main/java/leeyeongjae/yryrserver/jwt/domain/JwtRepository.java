package leeyeongjae.yryrserver.jwt.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JwtRepository extends JpaRepository<RefreshToken,Integer> {
    Optional<RefreshToken> findByUsername(String UserName);
}
