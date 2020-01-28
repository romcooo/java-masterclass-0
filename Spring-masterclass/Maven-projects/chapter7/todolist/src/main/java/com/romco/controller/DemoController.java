package com.romco.controller;

import com.romco.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    private final DemoService service;

    // == constructors ==
    @Autowired
    public DemoController(DemoService service) {
        this.service = service;
    }

    // == request methods ==

    // http://localhost:8080/todo-list/hello
    @ResponseBody //indicates that the method response should be bound to the actual http response body
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // maps the welcome() method to the URL - http://localhost:8080/todo-list/welcome
    // maps the welcome() method to the URL - http://localhost:8080/todo-list/welcome?user=romco
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model) {
//        model.addAttribute("user", "Romco");
        model.addAttribute("helloUserMsg", service.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("model = {}", model.toString());
        return "welcome";
        // represents the name of the jsp file (prefix and suffix are specified in the view resolver)
        // WEB-INF/view/welcome.jsp
    }

    // == model attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return service.getWelcomeMessage();
    }
}
