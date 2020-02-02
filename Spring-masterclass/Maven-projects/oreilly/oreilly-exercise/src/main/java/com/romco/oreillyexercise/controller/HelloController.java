package com.romco.oreillyexercise.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class HelloController {
    
    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "World", required = false) String name, Model model) {
        log.info("In sayHello");
        model.addAttribute("user", name);
        return "hello";
    }
}
