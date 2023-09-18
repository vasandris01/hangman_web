package com.example.hangman_web.controller;

import com.example.hangman_web.model.UserInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    @GetMapping({"","/","/home"})
    public String getHome(Model model){
        model.addAttribute("input", new UserInput());
        return "home";
    }

    @PostMapping("/play")
    public String choose(@ModelAttribute("input") UserInput input){
        return "redirect:/home";
    }
}
