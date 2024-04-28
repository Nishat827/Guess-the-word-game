package com.nishatgaming.guesstheword.service;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class GameService {

	private String[] randomWords = {"father", "mother", "sister", "brother", "son", "daughter", "uncle", "aunt"};
	private String randomlyChoosenWord = "";
	private char[] allCharacterOfTheWords; 
	Random random = new Random();
	
	public GameService(){
		randomlyChoosenWord = randomWords[random.nextInt(randomWords.length)];
		allCharacterOfTheWords = new char[randomlyChoosenWord.length()];
		System.out.println(randomlyChoosenWord);
	}
	
	@Override
	public String toString() {
		
		String ret = "";
		for(char ch : allCharacterOfTheWords) {
			if(ch == '\u0000') {
				ret = ret + "_";
			} 
			else {
				ret = ret + ch;
			}
			ret = ret + ' ';
		}
		return ret;
	}

	public boolean addGuess(char guessedChar) {
		
		boolean isGuessCorrect = false;
		
		for(int i = 0; i < randomlyChoosenWord.length(); i++){
			if(guessedChar == randomlyChoosenWord.charAt(i)) {
				allCharacterOfTheWords [i] = guessedChar;
				isGuessCorrect = true;
			}
		}
		return isGuessCorrect;
	}
}
