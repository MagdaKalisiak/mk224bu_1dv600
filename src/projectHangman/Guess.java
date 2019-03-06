package projectHangman;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class Guess {

	private String guess;
	
	
	
	public Guess(String word) {
		guess =word;
}
	
	
	


public boolean checkIsOneLetter(String s) {
	if (s.length()==1) {
		return true;
	}
	else
		return false;
}

public boolean checkIsLetter(String s) {
		char i =s.charAt(0);
		if (Character.isLetter(i)) {
			return true;
		}
		else 
			return false;
	}
public String updateWrongGuess (String s,Label l) {
	StringBuilder sb= new StringBuilder();
	sb.append(l.getText());
	sb.append(s+" ");
	return sb.toString();
}
 public boolean alreadyTriedThatLetter(Label wrongLettersDisplayed){
	 
	 boolean triedLetter= false;
	 for (int i = 0;i < wrongLettersDisplayed.getText().length();i++) {
			if (wrongLettersDisplayed.getText().charAt(i) ==guess.charAt(0)) {
				triedLetter= true;
			break;
			}
	 }
				return triedLetter;
	 }
 }

