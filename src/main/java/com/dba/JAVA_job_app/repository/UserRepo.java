package com.dba.JAVA_job_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dba.JAVA_job_app.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
