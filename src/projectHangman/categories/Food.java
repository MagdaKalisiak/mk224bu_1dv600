package projectHangman.categories;

import projectHangman.Language;

public class Food extends Category {
	

	protected String [] food={"pasta","pizza","apple"};
	protected String [] jedzenie = {"ziemniaki", "truskawka", "malina"};

	protected String [][]foodInLanguages = {food,jedzenie};

		
public Food(Language lan) {
	name= "food";
	language = lan;
	passwordsLanguageVersions=foodInLanguages;	
}
		

}
