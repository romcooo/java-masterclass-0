package com.romco.console;

import com.romco.Game;
import com.romco.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {
//        implements ApplicationListener<ContextRefreshedEvent> -> in this case, @Override would be valid below

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == fields ==
    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;

    // == events ==

//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        log.info("Container ready for use.");
//    }

//    @EventListener
//    public void start(ContextRefreshedEvent event) {
//        log.info("start() -> Container ready for use.");
//    }

    @EventListener(ContextRefreshedEvent.class) // here, we're providing the type of event which we are interested in
    // this is an alternative to having the specific event as the argument to the method (above), and the better practice
    // in case the event is not used in the method at all (like below).
    public void start() {
        log.info("start() -> Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine().trim();

                if (!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }

                game.reset();
            }


        }
    }
}
