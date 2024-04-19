package com.lyphuc.eCommerce.user;

import com.lyphuc.eCommerce.registration.RegisterDto;
import com.lyphuc.eCommerce.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.user.UserMapper.mapToUser;
import static com.lyphuc.eCommerce.user.UserMapper.mapToUserDto;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return getUserDtoList(users);
    }

    private List<UserDto> getUserDtoList(List<UserEntity> users) {
        return users.stream().map(user -> mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(int id) {
        Optional<UserEntity> result = userRepository.findById(id);
        UserEntity user = null;
        if (result.isPresent()){
            user = result.get();
        }else {
            throw new RuntimeException("Did not find user id: "+id);
        }
        return mapToUserDto(user);
    }

    @Override
    public void save(UserDto userDto) {
        UserEntity user = mapToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Username not found!!"));
    }

    @Override
    public UserEntity registerUser(RegisterDto registerDto) {
        UserEntity user = new UserEntity(
                registerDto.getEmail(),
                passwordEncoder.encode(registerDto.getPassword()),
                registerDto.getFirstName(),
                registerDto.getLastName(),
                registerDto.getAddress(),
                registerDto.getPhoneNumber(),
                LocalDateTime.now(),
                Arrays.asList(new Role("USER"))
        );
        return user;
    }
}
