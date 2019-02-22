package projectHangman;

import projectHangman.categories.Birds;
import projectHangman.categories.Category;
import projectHangman.categories.Food;
import projectHangman.categories.Mixed;
import projectHangman.categories.People;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

	//my Scenes
	public Scene makeChoice(Stage ps) {
		Scene scene1 = new Scene(createLayout1(ps), 1200, 900);
		return scene1;
	}
	public Scene playScene(Stage ps) {
		Scene scene2= new Scene(createLayout2(ps), 1200, 900);
		return scene2;
	}


	public VBox createLayout1(Stage p){
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
		hang.setOnAction(e -> {
			tree.setDisable(true);
			versionChosen= Version.HANGMAN;		
		});	

		tree.setOnAction(e -> {
			hang.setDisable(true);
			versionChosen= Version.TREE;
		});	

		eng.setOnAction(e -> {
			pl.setDisable(true);
			languageChosen= Language.ENGLISH;		
		});	
		pl.setOnAction(e -> {
			eng.setDisable(true);
			languageChosen= Language.POLISH;		
		});	
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
		confirm.setOnAction(e -> {
			start.setDisable(false);	
		});	
		start.setOnAction(e -> {
			p.close();
			p.setScene(playScene(p));
			p.show();

		});	
		return layout1;
	}

	public VBox createLayout2(Stage prs){
		VBox layout2 = new VBox();
		layout2.setAlignment(Pos.TOP_CENTER);
		layout2.setPadding(new Insets(5, 5, 5, 5));
		layout2.setSpacing(5);
		HBox imagebox = new HBox();
		imagebox.setPadding(new Insets(20, 20, 20, 40));	
		imagebox.setAlignment(Pos.TOP_LEFT);
		imagebox.setSpacing(100);


		Button start = new Button("START ");
		start.setFont(new Font("Comfortaa", 35));
		Image welcomeImage = new Image(getClass().getResourceAsStream("/tree01.png"));
		ImageView imageviewsWelcome= new ImageView () ;
		imageviewsWelcome.setPreserveRatio(true);
		imageviewsWelcome.setFitHeight(600);;
		imageviewsWelcome.setImage(welcomeImage);
		Button quit = new Button("QUIT");
		quit.setFont(new Font("Comfortaa", 20));
		imagebox.getChildren().addAll(start,imageviewsWelcome,quit);
		//password
		Label password = new Label();
		password.setFont(new Font("Comfortaa", 80));

		//guess the password
		HBox guess = new HBox();
		guess.setAlignment(Pos.CENTER);
		guess.setPadding(new Insets(20, 20, 20, 60));
		guess.setSpacing(5);


		final Label guessThe = new Label("Guess the letter or password: ");
		final TextField textGuess = new TextField();
		textGuess.setPrefSize(100, 40);
		Button check = new Button("CHECK");
		Label yourguess = new Label();
		Label advice = new Label();
		guess.getChildren().addAll(guessThe,textGuess,check,yourguess,advice);

		//wrong guesses
		HBox wrong = new HBox();
		wrong.setAlignment(Pos.CENTER);
		guess.setPadding(new Insets(0, 0, 60, 0));
		guess.setSpacing(5);
		Label wrongL = new Label("Wrong letters:  ");
		Label wrongLetters = new Label();
		wrong.getChildren().addAll(wrongL,wrongLetters);
		layout2.getChildren().addAll(imagebox,password,guess,wrong );

		start.setOnAction(e -> {
			game = new PlayGame(languageChosen,categoryChosen);
			password.setText(game.getPassword().getPasswordHidden());
			start.setDisable(true);
		});	
		check.setOnAction(e -> {
			String gs = textGuess.getText().toUpperCase()	;

			yourguess.setText(gs);
			Guess guessObject = new Guess(gs);
			if (guessObject.checkIsOneLetter(gs)) {
				if (guessObject.checkIsLetter(gs)) {
					if(game.getPassword().checkPasswordForLetter(gs)) {
						advice.setText("Good guess!");
						password.setText(game.getPassword().displayAfterGuess(gs,password.getText()));
						if (password.getText().replaceAll(" ", "")==game.getPassword().getPassword()) {        //not working check!
							advice.setText("You won");
						}
					}
					else {
						countWrong++;
						imageviewsWelcome.setImage(pictures.takeOnePictureDequeue());
						wrongLetters.setText(guessObject.updateWrongGuess(gs,wrongLetters));
						advice.setText("Wrong guess.");
						if (countWrong==13)
							advice.setText("You lost.The pasword was: "+game.getPassword().getPassword() );
					}
				}
				else {
					advice.setText("The input should be one letter or word");
				}
			}
			else {
				if(game.getPassword().checkPasswordForWord(gs)) {
					password.setText(game.getPassword().getPassword());
					advice.setText("You won");
				}
				else{
					countWrong++;
					imageviewsWelcome.setImage(pictures.takeOnePictureDequeue());
					advice.setText("Wrong guess.");
					if (countWrong==13)
						advice.setStyle("You lost. The pasword was: "+game.getPassword().getPassword());
				}
			}
			textGuess.clear();
		});	

		quit.setOnAction(e -> {
			System.exit(-1);                                                   // better solution - with confirmation on the next iteration
			
		});	
		//	

		return layout2;
	}


}



