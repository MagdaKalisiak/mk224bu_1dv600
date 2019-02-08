package project;

import java.util.ArrayList;

public class Hangman {

	private String wordToGuess;
	private Version version;
	private Category category;
	private final int possibleGuesses = 10;  // I am not sure yet I will maybe change it
	ArrayList <Character> lettersTriedWrong =  new ArrayList <Character>();
	
	
	public Hangman() {
		wordToGuess = getRandomWord();
		version = setVersion();
		category = setCategory();
		playGame();
	}
	public Category setCategory() {
		return null;
	}
	public Version setVersion() {
		return null;
	}
	private String getRandomWord() {
		return null;
	}
	public void playGame (){
	}
public void finishGame() {
}
public void printTheWord(){
}
public void displayApicture() {
}

}

