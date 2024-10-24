package com.dba.JAVA_job_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobController {

    @GetMapping({ "/", "home" })
    public String home() {
        System.out.println("here");
        return "home";
    }

    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }

}
