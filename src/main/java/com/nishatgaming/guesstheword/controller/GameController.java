package com.nishatgaming.guesstheword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nishatgaming.guesstheword.service.GameService;
import com.nishatgaming.guesstheword.utils.GameUtils;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameUtils gameUtils;
	
	@GetMapping("/")
	public String homePage() {
		return "home-page";
	}
	
	@GetMapping("/game-home")
	public String showGameHomePage(@RequestParam(value = "guessedChar", required = false) String guessedChar, Model model) {
		
		String randomWord = gameService.toString();
		System.out.println("Guessed character : " + guessedChar);
		if(guessedChar != null && guessedChar != "") {
			boolean addGuess = gameService.addGuess(guessedChar.charAt(0));
			randomWord = gameService.toString();
			if(addGuess == false) {
				gameUtils.reduceTry();
			}
		}
		System.out.println("Number of tries remaining : " + gameUtils.getTriesRemaining());
		model.addAttribute("wordToDisplay", randomWord);
		model.addAttribute("triesLeft", gameUtils.getTriesRemaining());
		return "game-home-page";
	}
	
	@GetMapping("/reload")
	public String reloadGame() {	
		gameService = gameUtils.reload();
		gameUtils.resetTries();
		return "redirect:/game-home";
	}
}
