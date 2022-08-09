package com.sha.springboottaxapplication.controller;

import com.sha.springboottaxapplication.model.Product;
import com.sha.springboottaxapplication.model.Role;
import com.sha.springboottaxapplication.model.User;
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
@RequestMapping("api/user")//pre-path
public class UserController
{
    @Autowired
    private UserService userService;

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

    @DeleteMapping("{userId}") //api/user/{userId}
    public ResponseEntity<?> deleteuser(@PathVariable Long userId)
    {
        userService.deleteuser(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping //api/user
    public ResponseEntity<?> saveNewUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.saveNewUser(user), HttpStatus.CREATED);
    }

}
