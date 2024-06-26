package com.app.restdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "welcome")
public class WelcomeController {

        @GetMapping(value = "/{name}")
        public String welcome(@PathVariable String name) {
            return "Welcome " + name;
        }
}