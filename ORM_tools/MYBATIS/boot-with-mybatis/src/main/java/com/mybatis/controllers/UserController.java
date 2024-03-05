package com.mybatis.controllers;

import com.mybatis.exception.ResourceNotFoundException;
import com.mybatis.models.User;
import com.mybatis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // get all users
    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // create user rest API
    @PostMapping("/save")
    public Map<String, Boolean> createUser(@RequestBody User user) {

        Map<String, Boolean> response = new HashMap<>();
        Boolean bool = userRepository.insert(user) > 0 ?
                response.put("created", Boolean.TRUE) :
                response.put("created", Boolean.FALSE);

        return response;

    }

    // get user by id rest api
    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id) {
        return userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
    }

    // update user rest api
    @PutMapping("/update/{id}")
    public Map<String, Boolean> updateUser(@PathVariable Integer id,
                                           @RequestBody User userDetails) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
        userDetails.setId(id);
        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = userRepository.update(userDetails) > 0 ?
                response.put("updated", Boolean.TRUE) :
                response.put("updated", Boolean.FALSE);

        return response;
    }

    // delete user rest api
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = userRepository.deleteById(user.getId()) > 0 ?
                response.put("deleted", Boolean.TRUE) :
                response.put("deleted", Boolean.FALSE);
        return response;
    }
}
