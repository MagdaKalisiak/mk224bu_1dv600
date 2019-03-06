package projectHangman;

import projectHangman.categories.Birds;
import projectHangman.categories.Category;
import projectHangman.categories.Food;
import projectHangman.categories.Mixed;
import projectHangman.categories.People;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Optional;

import images.PictureQueue;
import images.TreePictureQueue;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

public class PlayGameMain extends Application{

	private  Language languageChosen;
	private  Category categoryChosen;
	private  Version versionChosen;
	private PlayGame game; 
	private int countWrong=0;
	private PictureQueue pictures = new TreePictureQueue();

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hangman");
		primaryStage.setScene(makeChoice(primaryStage));
		primaryStage.show();
	}
	//___________________________________________________________________________________________________________________________________________________
	//my Scene for Menu
	public Scene makeChoice(Stage ps) {
		Scene scene1 = new Scene(createLayout1(ps), 1200, 900);
		return scene1;
	}
	//___________________________________________________________________________________________________________________________________________________
	//my Scene for PlayGame
	public Scene playScene(Stage ps) {
		Scene scene2= new Scene(createLayout2(ps), 1200, 900);
		return scene2;
	}
	//____________________________________________________________________________________________________________________________________________________
	//method to create layout for MENU
	public VBox createLayout1(Stage p){

		//THE LAYOUT:
		VBox layout1 = new VBox();
		layout1.setAlignment(Pos.TOP_CENTER);
		layout1.setPadding(new Insets(5, 5, 5, 5));
		layout1.setSpacing(5);
		Label heading = new Label("Hangman ");
		heading.setFont(new Font("Comfortaa", 35));


		//version
		HBox version = new HBox();
		version.setAlignment(Pos.TOP_LEFT);
		version.setPadding(new Insets(20, 20, 0, 20));
		version.setSpacing(10);


		final Label chooseVer = new Label("Choose version:  ");

		Button hang = new Button("Hangman");
		Button tree = new Button("Apple Tree");

		version.getChildren().addAll(chooseVer,hang,tree);
		//language
		HBox language = new HBox();
		language.setAlignment(Pos.TOP_LEFT);
		language.setPadding(new Insets(10, 20, 0, 20));
		language.setSpacing(5);


		final Label chooseLan = new Label("Choose language: ");
		Button eng = new Button("ENGLISH");	
		Button pl = new Button("POLISH");
		language.getChildren().addAll(chooseLan,eng,pl);



		//category
		HBox category = new HBox();
		category.setAlignment(Pos.TOP_LEFT);
		category.setPadding(new Insets(10, 20, 20, 20));
		category.setSpacing(5);


		final Label chooseCat = new Label("Choose category: ");
		Button people = new Button("PEOPLE");
		Button birds = new Button("BIRDS");
		Button food = new Button("FOOD");
		Button mixed = new Button("MIXED");
		category.getChildren().addAll(chooseCat,people,birds,food,mixed);
		//change button		
		HBox change = new HBox();
		Button chang = new Button("Change choice");
		Button confirm = new Button("Confirm choice");
		change.setAlignment(Pos.TOP_LEFT);
		change.getChildren().addAll(chang,confirm);


		//start and image
		HBox imagebox = new HBox();
		imagebox.setPadding(new Insets(20, 20, 20, 40));	
		imagebox.setAlignment(Pos.TOP_LEFT);
		imagebox.setSpacing(100);


		Button start = new Button("PLAY GAME");
		start.setFont(new Font("Comfortaa", 35));
		start.setDisable(true);  
		Image welcomeImage = new Image(getClass().getResourceAsStream("/welcome.png"));
		ImageView imageviewsWelcome= new ImageView () ;
		imageviewsWelcome.setPreserveRatio(true);
		imageviewsWelcome.setFitWidth(500);
		imageviewsWelcome.setImage(welcomeImage);
		Button quit = new Button("QUIT");
		quit.setFont(new Font("Comfortaa", 20));
		imagebox.getChildren().addAll(start,imageviewsWelcome,quit);
		layout1.getChildren().addAll(heading,version,language, category,change,imagebox);

		//*********************ACTIONS*****************************************************************************************************************
		//version
		hang.setOnAction(e -> {
			tree.setDisable(true);
			versionChosen= Version.HANGMAN;		
		});	

		tree.setOnAction(e -> {
			hang.setDisable(true);
			versionChosen= Version.TREE;
		});	
		//language
		eng.setOnAction(e -> {
			pl.setDisable(true);
			languageChosen= Language.ENGLISH;		
		});	
		pl.setOnAction(e -> {
			eng.setDisable(true);
			languageChosen= Language.POLISH;		
		});	
		//category
		people.setOnAction(e -> {
			birds.setDisable(true);
			food.setDisable(true);
			mixed.setDisable(true);
			categoryChosen= new People(languageChosen);		
		});	
		birds.setOnAction(e -> {
			people.setDisable(true);
			food.setDisable(true);
			mixed.setDisable(true);
			categoryChosen= new Birds(languageChosen);		
		});	
		food.setOnAction(e -> {
			birds.setDisable(true);
			people.setDisable(true);
			mixed.setDisable(true);
			categoryChosen= new Food(languageChosen);		
		});	
		people.setOnAction(e -> {
			birds.setDisable(true);
			food.setDisable(true);
			mixed.setDisable(true);
			categoryChosen= new Birds(languageChosen);		
		});	
		mixed.setOnAction(e -> {
			birds.setDisable(true);
			food.setDisable(true);
			people.setDisable(true);
			categoryChosen= new Mixed(languageChosen);		
		});	
		// button change
		chang.setOnAction(e -> {
			birds.setDisable(false);
			food.setDisable(false);
			mixed.setDisable(false);
			people.setDisable(false);
			eng.setDisable(false);
			pl.setDisable(false);
			hang.setDisable(false);
			tree.setDisable(false);
		});	
		//button confirmation
		confirm.setOnAction(e -> {
			start.setDisable(false);	
		});	
		//button Start - action changes Scene to playscene
		start.setOnAction(e -> {
			p.close();
			p.setScene(playScene(p));
			p.show();

		});	
		quit.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Quit confirmation");
			alert.setHeaderText("Do you want to quit the game?");
			alert.setContentText("Press OK to confirm or CANCEL to continue.");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				System.exit(-1);    
			} 
		});
		return layout1;
	}
	//_____________________________________________________________________________________________________________________________________________________
	//___________________________________________________________________________________________________________________________________________________
	//method to create layout for Playgame
	public VBox createLayout2(Stage prs){

		//THE LAYOUT:
		VBox layout2 = new VBox();
		layout2.setAlignment(Pos.BOTTOM_LEFT);
		layout2.setPadding(new Insets(20,20, 20, 80));
		layout2.setSpacing(5);
		//images
		HBox imagebox = new HBox();
		imagebox.setPadding(new Insets(20, 20, 20, 40));	
		imagebox.setAlignment(Pos.BOTTOM_LEFT);
		imagebox.setSpacing(100);
		Image welcomeImage = new Image(getClass().getResourceAsStream("/tree01.png"));
		ImageView imageviewMain= new ImageView () ;
		imageviewMain.setPreserveRatio(true);
		imageviewMain.setFitHeight(500);
		imageviewMain.setImage(welcomeImage);
		Image wonImage = new Image(getClass().getResourceAsStream("/won.jpg"));
		Image lostImage = new Image(getClass().getResourceAsStream("/lost.jpg"));

		//button start
		Button start = new Button("START ");
		start.setFont(new Font("Comfortaa", 35));
		start.setTextFill(Color.GREEN);
	

		//button quit		
		Button quit = new Button("QUIT");
		quit.setFont(new Font("Comfortaa", 20));
		quit.setTextFill(Color.RED);
		imagebox.getChildren().addAll(start,imageviewMain,quit);

		//label password - THE DASHED PASSWORD TO GUESS
		Label password = new Label();
		password.setFont(new Font("Comfortaa", 80));

		//Hbox -guess the password 
		HBox guess = new HBox();
		guess.setAlignment(Pos.BOTTOM_LEFT);
		guess.setPadding(new Insets(20, 20, 20, 60));
		guess.setSpacing(5);

		//label before guess
		final Label guessThe = new Label("Guess the letter or password: ");

		//textfield to check guess
		final TextField textGuess = new TextField();
		textGuess.setPrefSize(100, 40);

		//button check
		Button check = new Button("CHECK"); 

		//label with your current guess displayed
	//	Label yourguess = new Label();

		//label with advice
		Label advice = new Label();
		advice.setFont(new Font("Comfortaa", 22));
		advice.setTextFill(Color.DARKCYAN);
		
		guess.getChildren().addAll(guessThe,textGuess,check,advice);
		//Hbox with wrong guesses
		//wrong guesses
		HBox wrong = new HBox();
		wrong.setAlignment(Pos.BOTTOM_LEFT);
		guess.setPadding(new Insets(0, 0, 60, 0));
		guess.setSpacing(5);
		Label wrongL = new Label("Wrong letters:  ");
		Label wrongLetters = new Label();
		wrongLetters.setFont(new Font("Comfortaa", 15));
		wrongLetters.setTextFill(Color.DARKMAGENTA);
		wrong.getChildren().addAll(wrongL,wrongLetters);
		layout2.getChildren().addAll(imagebox,password,guess,wrong );

		//*******************ACTIONS*************************************************************************************************************************
		//button start
		start.setOnAction(e -> {
			game = new PlayGame(languageChosen,categoryChosen);             //new game !!! with new PlayGame object - it creates new password
			password.setText(game.getPassword().getPasswordHidden());
			start.setDisable(true);
		});	
		//button check
		check.setOnAction(e -> {
			String gs = textGuess.getText().toUpperCase();				
			//yourguess.setText(gs);

			Guess guessObject = new Guess(gs);   //creating new Guess object from the str written in textGuess textfield
			if (gs.length()==0) 
				advice.setText("The game is waiting for the letter or word");    
			else {
				if (guessObject.checkIsOneLetter(gs)) { //if is one letter
					if(guessObject.alreadyTriedThatLetter(wrongLetters)) {
						advice.setText("You have already tried this letter");                                                        //if already tried
					}
					else {
						if (guessObject.checkIsLetter(gs)) {     //if is letter not number or so
							if(game.getPassword().checkPasswordForLetter(gs)) {             //check if this letter is in password              
								advice.setText("Good guess!");
								password.setText(game.getPassword().displayAfterGuess(gs,password.getText()));     						

								if (game.getPassword().checkIfPasswordGuessedWithLetters(password.getText())) {        //if letters addad led to guess
									advice.setText("You won" );   
									imageviewMain.setImage(wonImage);
									winLost(start, check,prs);                                                                 //WON!
								}
							}
							else {
								countWrong++;
								imageviewMain.setImage(pictures.takeOnePictureDequeue());
								wrongLetters.setText(guessObject.updateWrongGuess(gs,wrongLetters));
								advice.setText("Wrong guess.");
								if (countWrong==13) {
									advice.setText("You lost.The pasword was: "+game.getPassword().getPassword() );
									imageviewMain.setImage(lostImage);
									winLost(start, check,prs);                                                              //Lost!!!
								}
							}
						}
						else {
							advice.setText("The input should be one letter or word");
						}
					}
				}
				else {
					if(game.getPassword().checkPasswordForWord(gs)) {
						password.setText(game.getPassword().getPassword());                   //WON!
						advice.setText("You won");
						imageviewMain.setImage(wonImage);

						winLost(start, check,prs);
					}
					else{
						countWrong++;
						imageviewMain.setImage(pictures.takeOnePictureDequeue());
						advice.setText("Wrong guess.");
						if (countWrong==13) {
							advice.setStyle("You lost. The pasword was: "+game.getPassword().getPassword());
							imageviewMain.setImage(lostImage);                                                              //lost!!!
							winLost(start, check,prs);
						}
					}
				}
			}
			textGuess.clear();
		});	
		//button quit


		quit.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Quit confirmation");
			alert.setHeaderText("Do you want to quit the game?");
			alert.setContentText("Press OK to confirm or CANCEL to continue.");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				System.exit(-1);    
			} 
		});


		//	

		return layout2;
	}

public void winLost(Button startb, Button checkc,Stage p){
	startb.setDisable(false);
	checkc.setDisable(true);
	startb.setText("START AGAIN");
	startb.setFont(new Font("Comfortaa", 35));
	startb.setTextFill(Color.GREEN);
	startb.setOnAction(e -> {
		p.close();
		p.setScene(makeChoice(p));
		p.show();
	});	
}
}




