package com.tyy.auth.application;

import com.tyy.auth.adapter.in.view.LoginBody;
import com.tyy.auth.adapter.in.view.RegisterBody;
import com.tyy.auth.domain.AuthorizedUser;

public interface LoginService {
    AuthorizedUser login(LoginBody loginBody);

    boolean register(RegisterBody registerBody) throws ClassNotFoundException;

    boolean validate(Object o);
}
