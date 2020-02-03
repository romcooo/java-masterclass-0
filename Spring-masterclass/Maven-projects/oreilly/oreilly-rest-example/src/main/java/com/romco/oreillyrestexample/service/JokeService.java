package com.romco.oreillyrestexample.service;

import com.romco.oreillyrestexample.json.JokeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class JokeService {
    public static final String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

    private RestTemplate restTemplate;

    @Autowired
    public JokeService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }
    
    public String getJoke( String first, String last) {
        String url = String.format("%s&firstName=%s&lastName=%s", BASE, first, last);
        JokeResponse response = restTemplate.getForObject(url, JokeResponse.class);
        String output = "";
        if (response != null) {
            output = response.getValue().getJoke();
        }
        return output;
    }
}
