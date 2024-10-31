package com.dba.JAVA_job_app.controller.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
class HomeRESTcontroller {

    @GetMapping("/")
    public String homeAPI() {
        return "Homepage Welcome";
    }

}