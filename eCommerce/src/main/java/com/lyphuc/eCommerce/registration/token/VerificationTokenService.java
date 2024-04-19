package com.lyphuc.eCommerce.registration.token;

import com.lyphuc.eCommerce.user.UserEntity;

import java.util.Optional;

public interface VerificationTokenService {
    String validateToken(String token);
    void saveVerificationTokenForUser(UserEntity user,String token);
    Optional<VerificationToken> findByToken(String token);
}
