package com.sha.springboottaxapplication.security.jwt;

import com.sha.springboottaxapplication.security.UserPrinciple;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sa
 * @date 18.12.2021
 * @time 13:13
 */
public interface JwtProvider
{
    String generateToken(UserPrinciple auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
