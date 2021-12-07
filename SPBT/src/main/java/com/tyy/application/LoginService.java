package com.tyy.application;

import com.tyy.adapter.entity.LoginBody;
import com.tyy.application.entity.AuthorizedUser;

public interface LoginService {
    AuthorizedUser login(LoginBody loginBody);
}
