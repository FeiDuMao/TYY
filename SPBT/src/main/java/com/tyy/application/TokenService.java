package com.tyy.application;

import com.tyy.domain.AuthorizedUser;

public interface TokenService {

    public String GenerateToken(AuthorizedUser authorizedUser);

    public AuthorizedUser getUserFromToken(String token);

}
