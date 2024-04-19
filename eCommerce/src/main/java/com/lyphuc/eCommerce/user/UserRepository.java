package com.lyphuc.eCommerce.user;

import com.lyphuc.eCommerce.registration.RegisterDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String username);
//    UserEntity registerUser(RegisterDto registerDto);
}
