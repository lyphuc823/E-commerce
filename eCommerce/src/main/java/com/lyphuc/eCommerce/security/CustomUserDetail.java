package com.lyphuc.eCommerce.security;

import com.lyphuc.eCommerce.user.UserEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CustomUserDetail implements UserDetails {
    private String username;
    private String password;
    private boolean isEnabled;
    private List<GrantedAuthority> grantedAuthorities;

    public CustomUserDetail(UserEntity userEntity) {
        this.username = userEntity.getEmail();
        this.password = userEntity.getPassword();
        this.isEnabled = userEntity.isEnabled();
        this.grantedAuthorities = Arrays.stream(userEntity.getRoles().toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
