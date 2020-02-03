package com.romco.oreillyexercise;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.accessibility.AccessibleContext;
import java.text.NumberFormat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContextTests {
    @Autowired
    private ApplicationContext context;
    
    @Autowired
    @Qualifier("defaultCurrencyFormat")
    private NumberFormat format;
    
    @Test
    public void defaultCurrency() {
        double amount = 123123.932d;
        System.out.println(format.format(amount));
    }
    
    @Test
    public void germanCurrency() {
        double amount = 123123.932d;
        NumberFormat germanNF = context.getBean("germanCurrencyFormat", NumberFormat.class);
        System.out.println(germanNF.format(amount));
    }
    @Test
    public void contextLoads() {
        int count = context.getBeanDefinitionCount();
        log.info("There are {} beans in the context", count);
        for (String name : context.getBeanDefinitionNames()) {
            log.info(name);
        }
    }
}
