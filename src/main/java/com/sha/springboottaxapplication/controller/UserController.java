package com.sha.springboottaxapplication.controller;

import com.sha.springboottaxapplication.exception.UserNotFoundException;
import com.sha.springboottaxapplication.model.Product;
import com.sha.springboottaxapplication.model.Role;
import com.sha.springboottaxapplication.model.User;
import com.sha.springboottaxapplication.repository.UserRepository;
import com.sha.springboottaxapplication.security.UserPrinciple;
import com.sha.springboottaxapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author sa
 * @date 18.12.2021
 * @time 13:57
 */
@RestController
@RequestMapping("api/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PutMapping("change/{role}")//api/user/change/{role}
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrinciple userPrinciple, @PathVariable Role role)
    {
        userService.changeRole(role, userPrinciple.getUsername());

        return ResponseEntity.ok(true);
    }

    @GetMapping("/getAllUser")
    List<User> getAllUsers()
    {
        List<User> allUsrs = userService.findAllUsers();
        return allUsrs;
    }

    @GetMapping("/getUser/{id}")
    public Optional<User> getUserByid(@PathVariable Long id){
        return userService.getUserByid(id);

    }

//    @DeleteMapping("{userId}") //api/user/{userId}
//    public ResponseEntity<?> deleteuser(@PathVariable Long userId)
//    {
//        userService.deleteuser(userId);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PostMapping //api/user
    public ResponseEntity<?> saveNewUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.saveNewUser(user), HttpStatus.CREATED);
    }

//    @PutMapping("/update/{id}") //api/user
//    public ResponseEntity<?> updateUser(@RequestBody User user)
//    {
//        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
//    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setLastname(newUser.getLastname());
            user.setName(newUser.getName());
            return userRepository.save(user);
        }).orElseThrow(() ->new UserNotFoundException(id));
    }

    @DeleteMapping("user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id "+  id  + "has been deleted success";
    }


}
