package com.romco;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {
    
    // == constants ==
    public static final String MAIN_MESSAGE = "game.main.message";
    public static final String WON_MESSAGE = "game.won";
    public static final String LOST_MESSAGE = "game.lost";
    public static final String INVALID_RANGE_MESSAGE = "game.invalid.range";
    public static final String FIRST_GUESS_MESSAGE = "game.first.guess";
    public static final String NUMBER_LOWER_MESSAGE = "game.number.lower";
    public static final String NUMBER_HIGHER_MESSAGE = "game.number.higher";
    public static final String REMAINING_GUESSES_MESSAGE = "game.remaining.guesses";
    
    
    // == fields ==
    private final Game game;
    private final MessageSource messageSource;
    
    // == constructors
    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }
    
    //== private methods
    @PostConstruct
    private void init() {
        log.info("value of game: {}", game.getNumber());
    }
    
    // == public methods
    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
//        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
    }
    
    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return getMessage(WON_MESSAGE, game.getNumber());
        } else if (game.isGameLost()) {
            return getMessage(LOST_MESSAGE, game.getNumber());
        } else if (!game.isValidNumberRange()) {
            return getMessage(INVALID_RANGE_MESSAGE);
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return getMessage(FIRST_GUESS_MESSAGE);
        } else {
            String direction = getMessage(NUMBER_LOWER_MESSAGE);
            if (game.getGuess() < game.getNumber()) {
                direction = getMessage(NUMBER_HIGHER_MESSAGE);
            }
            return getMessage(REMAINING_GUESSES_MESSAGE, direction, game.getRemainingGuesses());
        }
    }
    
    // == private methods
    private String getMessage(String code, Object... args) {
        log.info("Getting message by code: <{}> with args: {}", code, Arrays.toString(args));
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
    
}
