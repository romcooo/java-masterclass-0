package com.romco.service;

import org.springframework.stereotype.Service;

// kind of like @Component. Typically, @Service holds business logic.
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this demo app!";
    }
}
