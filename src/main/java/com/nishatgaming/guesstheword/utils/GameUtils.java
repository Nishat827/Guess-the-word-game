package com.nishatgaming.guesstheword.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.nishatgaming.guesstheword.service.GameService;

@Component
public class GameUtils {

	@Autowired
	ConfigurableApplicationContext applicationContext;
	int MAX_TERIES = 5;
	
	public int reduceTry() {
		MAX_TERIES = MAX_TERIES - 1;
		return MAX_TERIES;
	}
	
	public int getTriesRemaining(){
		return MAX_TERIES;
	}
	
	public void resetTries() {
		MAX_TERIES = 5;
	}
	
	public GameService reload() {
		GameService gameService = applicationContext.getBean(GameService.class);
		return gameService;
	}
}
