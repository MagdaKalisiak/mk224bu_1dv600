package projectHangman.categories;

import projectHangman.Language;

public class Birds extends Category{
	
	protected String [] birds={"parrot","tit","hawk"};
	protected String [] ptaki = {"kaczka", "sikorka", "sowa"};

	protected String [][]birdsInLanguages = {birds,ptaki};

		
public Birds(Language lan) {
	name= "birds";
	language = lan;
	passwordsLanguageVersions=birdsInLanguages;	
}
	

}
