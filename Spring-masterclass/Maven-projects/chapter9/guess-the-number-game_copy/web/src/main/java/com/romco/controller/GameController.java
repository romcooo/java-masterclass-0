package com.romco.controller;

import com.romco.service.GameService;
import com.romco.util.AttributeNames;
import com.romco.util.GameMappings;
import com.romco.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class GameController {
    
    // == fields
    private final GameService gameService;
    
    // == constructors
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    
    // == request methods
    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model = {}", model);
        // If the game is over, go to the game over page, else keep playing by going to the play page.
        return gameService.isGameOver() ? ViewNames.GAME_OVER : ViewNames.PLAY;
    }
}
