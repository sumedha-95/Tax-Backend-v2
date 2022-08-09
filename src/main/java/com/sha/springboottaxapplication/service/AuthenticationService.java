package com.sha.springboottaxapplication.service;

import com.sha.springboottaxapplication.model.User;

/**
 * @author sa
 * @date 18.12.2021
 * @time 13:42
 */
public interface AuthenticationService
{
    User signInAndReturnJWT(User signInRequest);
}
