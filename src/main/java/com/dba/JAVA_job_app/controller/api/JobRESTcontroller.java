package com.dba.JAVA_job_app.controller.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dba.JAVA_job_app.model.JobPost;
import com.dba.JAVA_job_app.service.JobService;

// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
// @CrossOrigin // disable crossorigin in dev mode
public class JobRESTcontroller {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public ResponseEntity<List<JobPost>> getAllJobsAPI() {
        return new ResponseEntity<>(service.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("jobPost/{postId}")
    public ResponseEntity<JobPost> getJobAPI(@PathVariable int postId) { // for multiple path variable i can specify the
                                                                         // variable ex: @PathVariable("postId")

        JobPost job = service.getJob(postId);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("jobPost/{postId}/image")
    public ResponseEntity<byte[]> getImageByPostIdAPI(@PathVariable int postId) {
        JobPost job = service.getJob(postId);
        return new ResponseEntity<>(job.getImageData(), HttpStatus.OK);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public ResponseEntity<List<JobPost>> searchByKeywordAPI(@PathVariable String keyword) {
        List<JobPost> jobs = service.searchByKeyword(keyword);
        if (jobs != null) {
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("jobPost")
    public ResponseEntity<?> addJobAPI(@RequestPart JobPost jobPost, @RequestPart MultipartFile imageFile) {
        JobPost addedJob;
        try {
            addedJob = service.addJob(jobPost, imageFile);
            return new ResponseEntity<>(addedJob, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("jobPost")
    public ResponseEntity<JobPost> updateJobAPI(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return new ResponseEntity<>(service.getJob(jobPost.getPostId()), HttpStatus.OK);
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJobAPI(@PathVariable int postId) {
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadDataq() {
        service.load();
        return "success";
    }

}