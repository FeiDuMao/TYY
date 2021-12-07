package com.tyy.application.entity;

import com.tyy.domain.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
public class AuthorizedUser implements UserDetails, Serializable {

    String username;
    String password;
    String token;
    boolean enabled;

    public AuthorizedUser(User user) {
        this.username =user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();

    }
    public AuthorizedUser(String username,String token){
        this.username=username;
        this.token=token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
