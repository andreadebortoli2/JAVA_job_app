package com.dba.JAVA_job_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dba.JAVA_job_app.model.User;
import com.dba.JAVA_job_app.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User savUser(User user) {
        return repo.save(user);
    }
}