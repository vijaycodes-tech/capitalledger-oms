package com.capitalledger.identity.repository;

import com.capitalledger.identity.entity.RefreshToken;
import com.capitalledger.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {

    // Find a active token by its string value
    Optional<RefreshToken> findByTokenValue(String tokenValue);

    // Helper to clear out old tokens for a user during sign-out or password changes
    void deleteByUser(User user);
}