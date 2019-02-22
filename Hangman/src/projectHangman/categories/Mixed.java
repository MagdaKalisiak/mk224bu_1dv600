package projectHangman.categories;

import projectHangman.Language;

public class Mixed extends Category {

	protected String [] mixed={"book","lion","computer"};
	protected String [] rozne = {"krowa", "smok", "kotek"};

	protected String [][]mixedInLanguages = {mixed,rozne};

		
public Mixed(Language lan) {
	name= "mixed";
	language = lan;
	passwordsLanguageVersions=mixedInLanguages;	
}
		
}
