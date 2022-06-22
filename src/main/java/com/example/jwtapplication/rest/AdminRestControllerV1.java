package com.example.jwtapplication.rest;

import com.example.jwtapplication.model.User;
import com.example.jwtapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestControllerV1 {

    @Autowired
    private UserService userService;

    @GetMapping(value = "users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long id) {
        User result = userService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
