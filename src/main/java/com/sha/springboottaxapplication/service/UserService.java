package com.sha.springboottaxapplication.service;

import com.sha.springboottaxapplication.model.Role;
import com.sha.springboottaxapplication.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:22
 */
public interface UserService
{
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);

    List<User> findAllUsers();

    Optional<User> getUserByid(Long id);

    void deleteuser(Long userId);

    User saveNewUser(User user);
}
