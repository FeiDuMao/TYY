package com.tyy.auth.config;

import com.tyy.auth.application.TokenService;
import com.tyy.auth.domain.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private static final String HEADER="Authorization";
    private static final String HEAD="Bearer";

    @Autowired
    public JwtFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(HEADER);

        if (null!=authHeader&&authHeader.startsWith(HEAD)){
            String token = authHeader.substring(HEAD.length()+1);
            AuthorizedUser authorizedUser = tokenService.getUserFromToken(token);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (null==authentication&&null!=authorizedUser){
                UsernamePasswordAuthenticationToken authenticationToken=new
                        UsernamePasswordAuthenticationToken(authorizedUser,null, null);
                authenticationToken.setDetails(new
                        WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

        }

        filterChain.doFilter(request,response);

    }
}
