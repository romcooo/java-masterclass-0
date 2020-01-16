package com.romco.console;

import com.romco.AppConfig;
import com.romco.Game;
import com.romco.MessageGenerator;
import com.romco.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
//    public static final String CONFIG_LOCATION = "src/main/unused/beans.xml";
    
    public static void main(String[] args) {
        log.info("Guess the Number Game.");
        
        //create context (container)
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get numberGenerator bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        
        //call method next() to get a random number
        int number = numberGenerator.next();
        
        //log generated number
        log.info("number = {}", number);
        
        // get game bean from context (container)
        Game game = context.getBean(Game.class);
        
        // call reset method
//        game.reset();
    
        // get message generator bean from context
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        
        log.info("getMainMessage: {}", messageGenerator.getMainMessage());
        log.info("getResultMessage: {}", messageGenerator.getResultMessage());
        
        //close context (container)
        context.close();
        
    }
}
