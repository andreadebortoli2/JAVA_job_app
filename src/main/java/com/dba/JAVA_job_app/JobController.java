package com.dba.JAVA_job_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dba.JAVA_job_app.model.JobPost;

@Controller
public class JobController {

    @GetMapping({ "/", "home" })
    public String home() {
        return "home";
    }

    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost JobPost) {
        return "success";
    }
}
