package com.lyphuc.eCommerce.security;

import com.lyphuc.eCommerce.role.Role;
import com.lyphuc.eCommerce.user.UserEntity;
import com.lyphuc.eCommerce.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserEntity user = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//        return new User(user.getUserName(),user.getPassword(),mapToGrandAuthority(user.getRoles()));
        return userRepository.findByEmail(email)
                .map(CustomUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
    public Collection<GrantedAuthority> mapToGrandAuthority(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
