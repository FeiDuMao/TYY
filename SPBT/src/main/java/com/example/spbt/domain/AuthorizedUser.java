package com.example.spbt.domain;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

@Data
public class AuthorizedUser implements UserDetails {

    String username;
    String password;
    String token;
    boolean enabled;
    LocalDate loginDate;

    //List<String> Authorities;

    public AuthorizedUser(User user){
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.enabled =user.enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
