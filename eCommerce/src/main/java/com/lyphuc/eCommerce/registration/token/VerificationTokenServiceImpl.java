package com.lyphuc.eCommerce.registration.token;

import com.lyphuc.eCommerce.user.UserEntity;
import com.lyphuc.eCommerce.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService {
    private final VerificationTokenRepository tokenRepository;
    private final UserRepository userRepository;
    @Override
    public String validateToken(String token) {
        Optional<VerificationToken> theToken = tokenRepository.findByToken(token);
        if(theToken.isEmpty()){
            return "invalid";
        }
        UserEntity user = theToken.get().getUser();
        Calendar calendar = Calendar.getInstance();
        if((theToken.get().getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){
            return "expired";
        }
        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }

    @Override
    public void saveVerificationTokenForUser(UserEntity user, String token) {
        var verificationToken = new VerificationToken(token, user);
        tokenRepository.save(verificationToken);
    }

    @Override
    public Optional<VerificationToken> findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
