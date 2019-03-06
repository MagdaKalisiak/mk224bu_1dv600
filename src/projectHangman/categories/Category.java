package projectHangman.categories;

import java.util.Random;

import org.omg.CORBA.portable.ApplicationException;

import projectHangman.Language;

public abstract class  Category {

	protected String name;
	protected  String[][] passwordsLanguageVersions;  //an array of arrays containing the passwords for language versions of the category
	protected Language language;

	
	//to get new password in certain category and language random choice of the index in the certain array
	public String getNewPassword(Language lang) throws ApplicationException {
//choosing the language
		String [] chosenLanguageVersion;

		switch (lang) {
		case ENGLISH:
			chosenLanguageVersion=passwordsLanguageVersions[0] ;
			break;
		case POLISH:
			chosenLanguageVersion=passwordsLanguageVersions[1] ;       
			break;
		default:
			throw new ApplicationException("The language should be ENGLISH or POLISH",null);	
		}
	//geting a random password	- random array index
		Random rand=new Random();
	
		return chosenLanguageVersion[rand.nextInt(chosenLanguageVersion.length)];	
	}	
}