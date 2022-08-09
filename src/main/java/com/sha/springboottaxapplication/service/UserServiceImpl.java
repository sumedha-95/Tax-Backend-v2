package com.sha.springboottaxapplication.service;

import com.sha.springboottaxapplication.model.Product;
import com.sha.springboottaxapplication.model.Role;
import com.sha.springboottaxapplication.model.User;
import com.sha.springboottaxapplication.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:22
 */
@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }


    @Override
    @Transactional //Transactional is required when executing an update/delete query.
    public void changeRole(Role newRole, String username)
    {
        userRepository.updateUserRole(username, newRole);
    }

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByid(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteuser(Long id)
    {
        userRepository.deleteById(id);
    }

    @Override
    public User saveNewUser(User user)
    {
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }
}
