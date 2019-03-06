package projectHangman.categories;

import projectHangman.Language;

public class People extends Category{


	protected String [] people={"fireman","mum","brother"};
	protected String [] ludzie = {"mama", "tata", "siostra"};

	protected String [][]peopleInLanguages = {people,ludzie};

		
public People(Language lan) {
	name= "people";
	language = lan;
	passwordsLanguageVersions=peopleInLanguages;	
}
		
}
