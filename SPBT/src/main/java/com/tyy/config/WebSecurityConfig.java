package com.tyy.config;


import com.tyy.application.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    UserDetailServiceImpl userDetailService;
    PasswordEncoder passwordEncoder;
    JwtFilter jwtFilter;

    @Autowired
    public WebSecurityConfig(UserDetailServiceImpl userDetailService,PasswordEncoder passwordEncoder,JwtFilter jwtFilter){
        this.userDetailService=userDetailService;
        this.passwordEncoder=passwordEncoder;
        this.jwtFilter=jwtFilter;
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/api/**").permitAll()
                    .anyRequest().authenticated()
                    .and().csrf().disable();

            http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
    }
}
