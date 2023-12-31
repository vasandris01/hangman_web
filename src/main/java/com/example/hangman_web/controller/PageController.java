package com.example.hangman_web.controller;

import com.example.hangman_web.model.Game;
import com.example.hangman_web.model.UserInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    Game game = new Game();

    @GetMapping({"", "/", "/home"})
    public String getHome(Model model) {
        model.addAttribute("input", new UserInput());
        model.addAttribute("game", game);
        return "home";
    }

    @PostMapping("/play")
    public String choose(@ModelAttribute("input") UserInput input) {
        game.useChoice(input.getChoice());
        if (game.isEnd()) {
            return "redirect:/game_end";
        }
        return "redirect:/home";
    }

    @GetMapping("/game_end")
    public String gameEnd(Model model) {
        model.addAttribute("message", game.getLife() == 0 ? "noob" : "gg");
        return "game_end";
    }

    @PostMapping("/new_game")
    public String newGame(){
        game = new Game();
        return "redirect:/home";
    }
}
