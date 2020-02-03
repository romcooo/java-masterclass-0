package com.romco.oreillyrestexample.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class JokeServiceTest {
//    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JokeService service;

    @Test
    void getJoke() {
        String joke = service.getJoke("mark", "webber");
        assertTrue(joke.contains("mark") || joke.contains("webber"));
        log.info("Joke: " + joke);
    }

}