package com.dba.JAVA_job_app.controller.api;

import org.springframework.web.bind.annotation.RestController;

import com.dba.JAVA_job_app.model.User;
import com.dba.JAVA_job_app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserRESTcontroller {

    @Autowired
    private UserService service;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("register")
    public User addUserAPI(@RequestBody User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        return service.saveUser(user);
    }

}
