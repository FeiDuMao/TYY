package com.tyy.application;

import com.tyy.adapter.in.view.LoginBody;
import com.tyy.adapter.in.view.RegisterBody;
import com.tyy.domain.AuthorizedUser;

public interface LoginService {
    AuthorizedUser login(LoginBody loginBody);

    boolean register(RegisterBody registerBody) throws ClassNotFoundException;
}
