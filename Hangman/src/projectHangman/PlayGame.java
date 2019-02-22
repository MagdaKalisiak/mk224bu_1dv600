package projectHangman;

import org.omg.CORBA.portable.ApplicationException;

import projectHangman.categories.Category;

public class PlayGame {
	//represents the new game played after the start menu
	private Language langugeChosen;
	private Category categoryChosen;
	private Password password;
	
	
	
public PlayGame (Language e, Category d) {
	langugeChosen=e;
	categoryChosen=d;
	password = new Password(e,d);
	}

	
	
public Password getPassword(){
	return password;
}


}

	
	


