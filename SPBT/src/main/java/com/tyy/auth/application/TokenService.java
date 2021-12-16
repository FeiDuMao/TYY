package com.tyy.auth.application;

import com.tyy.auth.domain.AuthorizedUser;

public interface TokenService {

    public String GenerateToken(AuthorizedUser authorizedUser);

    public AuthorizedUser getUserFromToken(String token);

}
