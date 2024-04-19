package com.lyphuc.eCommerce.user;

import com.lyphuc.eCommerce.registration.RegisterDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(int id);
    void save(UserDto user);
    void deleteById(int id);
    UserEntity findByEmail(String username);
    UserEntity registerUser(RegisterDto registerDto);
}
