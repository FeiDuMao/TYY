package com.example.spbt.application;

import com.example.spbt.application.entity.UnAuthorizedUser;
import com.example.spbt.application.exceptioin.TokenExpiredException;
import com.example.spbt.domain.AuthorizedUser;
import org.springframework.stereotype.Service;


public interface TokenService {

    public void validateToken(String token) throws TokenExpiredException;

    public String GenerateToken(AuthorizedUser authorizedUser);


}
