package projectHangman;

import org.omg.CORBA.portable.ApplicationException;

import projectHangman.categories.Category;

public class Password {
	//class represents one  password randomly chosen for the game (in certain language and category)

	private String password;

	public Password (Language e, Category d){ 
		try {
			password = d.getNewPassword(e);
		}
		catch (ApplicationException exc ) {
		}
	}

	public String getPassword() {
		return password.toUpperCase();
	}
	
	public String getPasswordHidden() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<password.length();i++) {
			sb.append("_ ");
	}
		return sb.toString();
	}
	
	public boolean checkPasswordForLetter(String c) {
		
	for (int i=0; i<password.length();i++) {
	if (password.toUpperCase().charAt(i)==c.charAt(0)) {
		return true;
	}
	}
	return false;
}
	public String displayAfterGuess(String guessLetter,String previouslyDisplayed) {
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<password.length();i++) {
			if (password.toUpperCase().charAt(i)==guessLetter.charAt(0)) {
				sb.append(guessLetter);
			}
				else 
					sb.append(previouslyDisplayed.replaceAll(" ", "").charAt(i));
			}
		StringBuilder newSB= new StringBuilder();
		for (int i=0; i<sb.length();i++) {
			newSB.append(sb.charAt(i));
			newSB.append(" ");
		}
	return	newSB.toString();
}
	
	public boolean checkPasswordForWord(String s) {
	if (password.toUpperCase().equals(s)) {
		return true;
	}
		else
	return false;
}
	}
	
