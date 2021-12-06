package com.tyy.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 
 * </p>
 *
 * @author tyy
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String token;

    private String logintime;

    private String expiretime;

    private String enabled;

    private String leve;

    private Set<String> permissions;

    private List<SimpleGrantedAuthority> authorities;


    public LoginUser(Student student){
        this.username=student.getUsername();
        this.password=student.getPassword();
        this.leve=student.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(leve);

        return authorities;
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
        return true;
    }
}
