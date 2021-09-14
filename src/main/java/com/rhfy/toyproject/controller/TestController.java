package com.rhfy.toyproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {

    @GetMapping("/healthcheck")
    public Object hello(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(200);
        return "response Status 200!\n server is up!";
    }
}
