package com.dba.JAVA_job_app.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dba.JAVA_job_app.model.JobPost;
import com.dba.JAVA_job_app.service.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class JobRESTcontroller {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobsAPI() {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJobAPI(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJobAPI(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

}