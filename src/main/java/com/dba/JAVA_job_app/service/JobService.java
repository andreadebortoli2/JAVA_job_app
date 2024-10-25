package com.dba.JAVA_job_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dba.JAVA_job_app.model.JobPost;
import com.dba.JAVA_job_app.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public void addJob(JobPost JobPost) {
        repository.addJob(JobPost);
    }

    public List<JobPost> getAllJobs() {
        return repository.getAllJobs();
    }

    public JobPost getJob(int postId) {
        return repository.getJob(postId);
    }

    public void updateJob(JobPost jobPost) {
        repository.updateJob(jobPost);
    }

    public void deleteJob(int postId) {
        repository.deleteJob(postId);
    }
}
