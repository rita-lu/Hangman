//Authors: Fiony Van & Rita Lu
//Teacher: Ms. Jansen
//Date: June 6, 2015
//Class code: ICS3U1-01
//School: Harbord Collegiate Institute

//Purpose: This game, "Hangman", will require a user to guess the letters to a given word in a chosen category. 
//Every time a right letter is guessed, underscore(s) will be replaced
//Every time a wrong letter is guessed, a new body part will be drawn on the hangman. The user has 9 lives.

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hangman {

	static Random ran = new Random ();
	static Scanner in = new Scanner (System.in);

	//declaration and assigning of global variables
	private static JFrame frame;
	public static int num; // declares a variable to hold a random integer
	public static int score; // declares a variable to hold the score
	public static String name; //string variable to store user's name
	public static boolean check= false; //boolean variable to check if user entered number from 1-6 when selecting a category
	public static boolean winner = false; //boolean variable to check if the user has won
	private static int chances=0; // integer variable to count the number of lives left

	// declaration of arrays to hold the random integers generated and declaration of integers to hold the position of that array
	public static int randomSongs1 = 0;
	public static int randomSongs [] = new int [10];

	public static int randomMovies1=0;
	public static int randomMovies [] = new int [10];

	public static int randomShows1=0;
	public static int randomShows [] = new int [10];

	public static int randomRiddles1=0;
	public static int randomRiddles [] = new int [10];

	public static int randomAnimals1=0;
	public static int randomAnimals [] = new int [10];

	public static int randomCelebrities1=0;
	public static int randomCelebrities [] = new int [10];

	//declaration of arrays for "songs" method
	public static String songs1 [] = {"my heart will go on", "thinking out loud", "hey jude", "somewhere over the rainbow", "let it go", "i believe i can fly", "as long as you love me", "just the way you are", "yellow submarine", "you raise me up"};
	public static char arraySongs []= new char [songs1[num].length()];

	//declaration of arrays for "movies" method
	public static String movies1 [] = {"despicable me", "frozen", "fast and furious", "the hunger games", "rush hour", "the avengers", "the karate kid", "pitch perfect", "big hero six", "the fault in our stars"};
	public static char arrayMovies [] = new char [movies1[num].length()];

	//declaration of arrays for "shows" method
	public static String shows1 [] = {"breaking bad", "arrow", "the flash", "daredevil", "dexter", "orange is the new black", "lost", "how i met your mother", "the big bang theory", "suits"};
	public static char arrayShows [] = new char [shows1[num].length()];

	//declaration of arrays for "riddles" method
	public static String riddles1 [] = {"a cold", "a plant", "an automobile", "a breath", "one", "a promise", "timmy", "the pupil","a stamp", "fingerprints"};
	public static char arrayRiddles []= new char [riddles1[num].length()];

	//declaration of arrays for "animals" method
	public static String animals1 [] = {"horse", "flamingo", "dolphin", "dinosaur", "kangaroo", "elephant", "tiger", "giraffe", "otter", "polar bear"};
	public static char arrayAnimals []= new char [animals1[num].length()];

	//declaration of arrays for "celebrities" method
	public static String celebrities1 [] = {"justin bieber", "johnny depp", "taylor swift", "leonardo di caprio", "tom cruise", "angelina jolie", "michael jackson", "adele", "celine dion", "will smith"};
	public static char arrayCelebrities []= new char [celebrities1[num].length()];

	// draws the hangman stand
	public static void draw0 (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g. fillRect(50, 460, 270, 15 ); //base
		g. fillRect(80, 60, 10, 400 ); //vertical pole
		g. fillRect(80, 60, 135, 10 ); //horizontal pole
		g. fillRect(210, 60, 5, 70 ); //hanger
	}

	//returns the hangman stand
	public static JPanel panel0(){
		JPanel panel0 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw0(g);               
			}
		};
		return panel0;
	}

	// draws the head
	public static void draw1 (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.drawOval(160, 130, 100, 100);    
	}

	//returns everything before and the head
	public static JPanel panel1(){
		JPanel panel1 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw0(g);
				draw1(g);               
			}
		};
		return panel1;
	}

	//draws the body
	public static void draw2 (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g.drawLine (210, 230, 210, 350); //body
	}

	//returns everything before and the body
	public static JPanel panel2(){
		JPanel panel2 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw0(g);
				draw1(g);   
				draw2(g);
			}
		};
		return panel2;
	}

	// draws the right arm
	public static void draw3 (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g.drawLine (210, 260, 260, 300);
	}

	//returns everything before and the right arm
	public static JPanel panel3(){
		JPanel panel3 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw0(g);
				draw1(g);   
				draw2(g);
				draw3(g);
			}
		};
		return panel3;
	}

	// draws the left arm
	public static void draw4 (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g.drawLine (210, 260, 160, 300);
	}

	//returns everything before and the left arm
	public static JPanel panel4(){
		JPanel panel4 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw0(g);
				draw1(g);   
				draw2(g);
				draw3(g);
				draw4(g);

			}
		};
		return panel4;
	}

	// draws the left leg
	public static void draw5 (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g.drawLine (210, 350, 170, 420);
	}

	//returns everything before and the left leg
	public static JPanel panel5(){
		JPanel panel5 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw0(g);
				draw1(g);   
				draw2(g);
				draw3(g);
				draw4(g);
				draw5(g);
			}
		};
		return panel5;
	}

	// draws the right leg
	public static void draw6 (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g.drawLine (210, 350, 250, 420); 
	}

	//returns everything before and the right leg
	public static JPanel panel6(){
		JPanel panel6 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw0(g);
				draw1(g);   
				draw2(g);
				draw3(g);
				draw4(g);
				draw5(g);
				draw6(g);
			}
		};
		return panel6;
	}

	// draws the left eye
	public static void draw7 (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillOval(187, 160, 10, 10);
	}

	//returns everything before and the left eye
	public static JPanel panel7(){
		JPanel panel7 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw0(g);
				draw1(g);   
				draw2(g);
				draw3(g);
				draw4(g);
				draw5(g);
				draw6(g);
				draw7(g);
			}
		};
		return panel7;
	}

	// draws the right eye
	public static void draw8 (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillOval(225, 160, 10, 10);
	}

	//returns everything before and the right eye
	public static JPanel panel8(){
		JPanel panel8 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw0(g);
				draw1(g);   
				draw2(g);
				draw3(g);
				draw4(g);
				draw5(g);
				draw6(g);
				draw7(g);
				draw8(g);
			}
		};
		return panel8;
	}

	// draws the mouth
	public static void draw9 (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g.drawLine (196, 200, 225, 200); //mouth
	}

	//returns everything before and the mouth
	public static JPanel panel9(){
		JPanel panel9 = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw0(g);
				draw1(g);   
				draw2(g);
				draw3(g);
				draw4(g);
				draw5(g);
				draw6(g);
				draw7(g);
				draw8(g);
				draw9(g);
			}
		};
		return panel9;
	}


	//Main method
	public static void main(String[] args) {

		//assigns all the positions in the array that stores the random integers generated to a number (10) that will be replaced.
		for (int i = 0; i<randomSongs.length; i++){
			randomSongs [i] = 10;
		}

		for (int i = 0; i<randomMovies.length; i++){
			randomMovies [i] = 10;
		}

		for (int i = 0; i<randomShows.length; i++){
			randomShows [i] = 10;
		}

		for (int i = 0; i<randomRiddles.length; i++){
			randomRiddles [i] = 10;
		}

		for (int i = 0; i<randomAnimals.length; i++){
			randomAnimals [i] = 10;
		}

		for (int i = 0; i<randomCelebrities.length; i++){
			randomCelebrities [i] = 10;
		}

		//draws JFrame
		frame = new JFrame("Hangman");
		frame.setSize(385,540); 
		frame.setVisible(true);
		frame.setAlwaysOnTop(true); //set frame to always be on top
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//calls on other methods in order
		intro ();
		category ();  
	}

	// Intro method - Asks user for their name and welcome them to the program with instructions
	public static void intro (){
		System.out.print ("Hi, please enter your name: "); 
		name = in.nextLine();
		System.out.println ("");
		System.out.println ("Welcome to Hangman, " + name + "!!!!!");
		System.out.println ("");
		String s = "Instructions: \n";
		s += "First, choose a category. A word will be chosen for you. \n";
		s += "To play, input letters until you guess the word. You have nine guesses. \n";      
		System.out.println(s);
	}

	// Category method - Asks and the user to select a category for their word and directs them to the method for the chosen category
	public static void category (){

		//displays the hangman stand
		frame.add(panel0());
		frame.setVisible(true); 

		System.out.println ("Categories:");
		System.out.println ("1. Songs");
		System.out.println ("2. Movies");
		System.out.println ("3. TV shows");
		System.out.println ("4. Riddles");
		System.out.println ("5. Animals");
		System.out.println ("6. Celebrities \n");

		//asks the user to choose a category and calls up a specific method (also error checks to see if number entered is 1-6)
		while (check == false) {
			System.out.print(name + ", please choose a category (enter 1-6): ");
			try { // try and catch blocks to prevent user from crashing the program by entering a string
				String input = in.next(); // gets user's choice of category
				int choice = Integer.parseInt(input); // parse input into integer
				System.out.println("");
				if (choice == 1) {
					songs();
					check = true;
				} else if (choice == 2) {
					movies();
					check = true;
				} else if (choice == 3) {
					shows();
					check = true;
				} else if (choice == 4) {
					riddles();
					check = true;
				} else if (choice == 5) {
					animals();
					check = true;
				} else if (choice == 6) {
					celebrities();
					check = true;
				} else if (choice > 6 || choice < 1)
					System.out.println("Sorry you did not enter a number from 1-6. Please try again.\n");
			} catch (Exception e) { // catch user inputing a string
				System.out.println("Sorry you did not enter a number from 1-6. Please try again.\n");
			}
		}  
	}

	//Asks user if they want to play again after guessing the word with an error check. If yes, they are directed back to choose a category.
	public static void playAgain () {
		System.out.print ("\nDo you want to play again? (Y/N): ");
		char ans = in.next().charAt(0);   
		System.out.println ("");
		if (ans == 'y' || ans == 'Y'){
			category ();
		}
		else if (ans == 'n' || ans == 'N'){
			System.out.println ("Thank you for playing " + name + "!!!");
			System.out.println ("Your final score is: " + score); // prints final score
			System.exit(0); // manually terminate (closes JFrame, and terminates console)
		}     
		else {
			System.out.println ("Error. You did not enter (Y/N). Please try again.");
			playAgain ();
		}

	}

	// Check method for songs - Checks if the user has won the game by checking if there are any unguessed letters ('_') remaining in the array
	public static boolean checkSongs (){
		boolean test;
		test = true;
		for (int i=0; i<arraySongs.length; i++){
			if (arraySongs [i]=='_'){
				test = false;
				break;
			}
		}
		return test;
	}

	// Check method for movies - Checks if the user has won the game by checking if there are any unguessed letters ('_') remaining in the array
	public static boolean checkMovies (){
		boolean test;
		test = true;
		for (int i=0; i<arrayMovies.length; i++){
			if (arrayMovies [i]=='_'){
				test = false;
				break;
			}
		}
		return test;
	}

	// Check method for shows - Checks if the user has won the game by checking if there are any unguessed letters ('_') remaining in the array
	public static boolean checkShows (){
		boolean test;
		test = true;
		for (int i=0; i<arrayShows.length; i++){
			if (arrayShows [i]=='_'){
				test = false;
				break;
			}
		}
		return test;
	}

	// Check method for riddles - Checks if the user has won the game by checking if there are any unguessed letters ('_') remaining in the array
	public static boolean checkRiddles (){
		boolean test;
		test = true;
		for (int i=0; i<arrayRiddles.length; i++){
			if (arrayRiddles [i]=='_'){
				test = false;
				break;
			}
		}
		return test;
	}

	// Check method for animals - Checks if the user has won the game by checking if there are any unguessed letters ('_') remaining in the array
	public static boolean checkAnimals (){
		boolean test;
		test = true;
		for (int i=0; i<arrayAnimals.length; i++){
			if (arrayAnimals [i]=='_'){
				test = false;
				break;
			}
		}
		return test;
	}

	// Check method for celebrities - Checks if the user has won the game by checking if there are any unguessed letters ('_') remaining in the array
	public static boolean checkCelebrities (){
		boolean test;
		test = true;
		for (int i=0; i<arrayCelebrities.length; i++){
			if (arrayCelebrities [i]=='_'){
				test = false;
				break;
			}
		}
		return test;
	}


	//Songs category method 
	public static void songs (){    

		boolean test1=true;
		boolean check=true;	

		// When the user has finished all 10 questions for a category, tells the user to choose another category.
		if (randomSongs1==10){
			System.out.println ("Sorry, you finished all the questions in this category. Please choose another category.");
			category();
		}	

		//check to see if random integer generated is in array already and if it is, generate another random integer
		//if not, store use that integer and store it into the array
		while (test1==true){
			num = ran.nextInt (10); //generates a random integer from 0-9 for generating a random word
			test1=false;

			for (int i=0; i<randomSongs.length; i++){
				if (num == randomSongs [i]){
					check=false;
					test1=true;
				}
			}
			if (check==true){
				test1=false;
				randomSongs [randomSongs1]= num;
				randomSongs1++;
			}
			check=true;		
		}	

		test1=true;
		check=true;


		//array of hints for songs
		String hintSongs [] = {"Titantic.", "Famous song from Album, 'X'.","The Beatles.", "Song starred in The Wizard of Oz. Last word: 7 colours.",
				"Frozen.","Sung by R.Kelly. Soundtrack to the film 'Space Jam'.", "Sung by Justin Bieber. From album 'Believe'.", 
				"Sung by Bruno Mars. Title of song has a valuable message.",  "Album and a United Artists' film is named after this song. 'Colour; object that travels underwater.'",
		"Song was covered a lot of singers: Josh Groban, Westlife, etc. Originally composed by the duo 'Secret Garden'."};

		char numSongs [] = new char [26]; // declaring an array to store the letters already entered by the user

		System.out.println (hintSongs[num]); //outputs the hint for the word

		arraySongs = new char[songs1[num].length()]; // array for underscore characters

		// assigns the array with underscores for the word
		for (int i = 0; i<songs1[num].length(); i++){ 
			arraySongs[i]='_';
			if (songs1[num].charAt(i) == ' '){
				arraySongs [i] = ' ';
			}               
		}

		// outputs the underscores of the word
		for (int i=0; i<arraySongs.length; i++){
			System.out.print (arraySongs[i] + " ");
		}

		int count = 0; // stores index for "numSongs" array

		// while the user has not guessed all the correct letters, asks the user to enter a letter and check if the letter is already entered
		// or is a letter in the word
		while (winner == false){
			boolean checkChances=true;
			System.out.println ("\n");
			System.out.print ("Please enter a letter: ");
			
			// Error checks that user only enters a letter and not a number or special character.
			while (!in.hasNext("[A-Za-z]+")) {
		        System.out.print("Sorry, you did not enter a letter. Please enter a letter: ");
		        in.next();		        
		    }
			
			//converts all letters entered into lower case before checking if the letter is in the word
			String input = in.next().toLowerCase();
			char ch = input.charAt(0); // gets character from the user
			
			// checks if user has already entered the character before
			for (int i=0; i<numSongs.length; i++){ 
				if (ch == numSongs[i]){
					System.out.println("Error. Letter was already entered. Please enter another letter.");
					checkChances=false;
					break;
				}    
			}

			boolean entered=true;

			//checks if character entered is already stored in array 'numShows'
			for (int i=0; i<numSongs.length; i++){
				if (numSongs[i] == ch){
					entered=false;		
					break;
				}
			}

			// if letter is not already in 'numMovies', stores entered character into the array 
			if (entered==true){
				numSongs[count] = ch;
				count++;
			}

			// checks if the letter entered is in the word by going through each letter of the word. If it is, the character replaces the underscore.
			for (int k = 0; k < songs1[num].length(); k++) { //
				if (ch == songs1[num].charAt(k)) {
					arraySongs[k] = ch;
					checkChances = false;
				}
			}

			// if the letter entered is not in the word, the user loses one chance
			if (checkChances==true){
				chances++;
			}

			//draws a hangman part every time the user guesses an incorrect letter
			if (chances == 1) {
				frame.add(panel1());
				frame.setVisible(true);           
			} else if (chances == 2) {
				frame.add(panel2());
				frame.setVisible(true);
			} else if (chances == 3) {
				frame.add(panel3());
				frame.setVisible(true);
			} else if (chances == 4) {
				frame.add(panel4());
				frame.setVisible(true);
			} else if (chances == 5) {
				frame.add(panel5());
				frame.setVisible(true);
			} else if (chances == 6) {
				frame.add(panel6());
				frame.setVisible(true);
			} else if (chances == 7) {
				frame.add(panel7());
				frame.setVisible(true);
			} else if (chances == 8) {
				frame.add(panel8());
				frame.setVisible(true);
			} else if (chances == 9) {
				frame.add(panel9());
				frame.setVisible(true);
				System.out.println ("\nSorry " + name + ", you lose!");
				System.out.print ("The answer is: " + songs1[num]);
				break;
			}

			// outputs the new underscore array (some are replaced with letters if the user guesses a correct letter)
			for (int i=0; i<arraySongs.length; i++){
				System.out.print (arraySongs[i]+ " ");
			}        
			
			//displays the letters already entered by the user
			System.out.println ("\n\nLetters already entered:");
			for (int i=0; i<numSongs.length; i++){
				System.out.print (numSongs[i]+ " ");
			}   

			winner = checkSongs(); //checks if user has won by calling to "checkSongs" method
			if (winner==true){
				score++; //increases score by 1
			}
		}

		System.out.println ("\n\nYour score is: " + score);

		// After the user has won, clears "arraySongs" and replaces everything back to underscores
		for (int i=0; i<songs1[num].length(); i++){
			arraySongs[i] = '_';
		}

		winner = false;
		chances = 0;
		playAgain ();

		//checks to see if user has finished all the categories	
		if (randomSongs1==10 && randomMovies1==10 && randomShows1==10 && randomRiddles1==10 && randomAnimals1==10 && randomCelebrities1==10){
			end ();
		}

	}

	//Movies category method
	public static void movies (){

		boolean test1=true;
		boolean check=true;

		// When the user has finished all 10 questions for a category, tells the user to choose another category.
		if (randomMovies1==10){
			System.out.println ("Sorry, you finished all the questions in this category. Please choose another category.");
			category();
		}	

		//check to see if random integer generated is in array already and if it is, generate another random integer
		//if not, store use that integer and store it into the array
		while (test1==true){
			num = ran.nextInt (10); //generates a random integer from 0-9 for generating a random word
			test1=false;
			for (int i=0; i<randomMovies.length; i++){
				if (num == randomMovies [i]){
					check=false;
					test1=true;
				}
			}
			if (check==true){
				test1=false;
				randomMovies [randomMovies1]= num;
				randomMovies1++;
			}
			check=true;		
		}

		test1=true;
		check=true;

		//array of hints for movies
		String hintMovies [] = {"Cartoon, with a yellow squad.", "Disney, ice.", "Vroom Vroom, with action.", "Poisonious Nightlock berries.",
				"Martial arts, Action, Comedy. Police detectives.", "Gathering of Heroes.", "Kung Fu, taught by a master.", 
				"American musical comedy. The cup song.", "Disney animation featuring Marvel Comics characters.", "Stage 4 Thyroid Cancer."};

		char numMovies [] = new char [26]; // declaring an array to store the letters already entered by the user

		System.out.println (hintMovies[num]); //outputs the hint for the word

		// array for underscore characters
		arrayMovies = new char[movies1[num].length()];

		// assigns the array with underscores for the word
		for (int i = 0; i<movies1[num].length(); i++){
			arrayMovies[i]='_';
			if (movies1[num].charAt(i) == ' '){
				arrayMovies [i] = ' ';
			}               
		}

		// outputs the underscores of the word
		for (int i=0; i<arrayMovies.length; i++){
			System.out.print (arrayMovies[i] + " ");
		}

		int count = 0; // stores index for "numMovies" array

		// while the user has not guessed all the correct letters, asks the user to enter a letter and check if the letter is already entered
		// or is a letter in the word
		while (winner == false){
			boolean checkChances=true;
			System.out.println ("\n");
			System.out.print ("Please enter a letter: ");
			
			// Error checks that user only enters a letter and not a number or special character.
			while (!in.hasNext("[A-Za-z]+")) {
				System.out.print("Sorry, you did not enter a letter. Please enter a letter: ");
				in.next();
			}

			//converts all letters entered into lower case before checking if the letter is in the word
			String input = in.next().toLowerCase();
			char ch = input.charAt(0); // gets character from the user

			// checks if user has already entered the character before
			for (int i=0; i<numMovies.length; i++){
				if (ch == numMovies[i]){
					System.out.println("Error. Letter was already entered. Please enter another letter.");
					checkChances=false;
					break;
				}
			}

			boolean entered=true;

			//checks if character entered is already stored in array 'numMovies'
			for (int i=0; i<numMovies.length; i++){
				if (numMovies[i] == ch){
					entered=false;		
					break;
				}
			}

			// if letter is not already in 'numMovies', stores entered character into the array 
			if (entered==true){
				numMovies[count] = ch; 
				count++;
			}


			// checks if the letter entered is in the word by going through each letter of the word. If it is, the character replaces the underscore.
			for (int k=0; k<movies1[num].length(); k++){
				if (ch == movies1[num].charAt(k)){
					arrayMovies [k]  = ch;
					checkChances=false;
				}
			}

			// if the letter entered is not in the word, the user loses one chance
			if (checkChances==true){
				chances++;
			}

			//draws a hangman part every time the user guesses an incorrect letter
			if (chances == 1) {
				frame.add(panel1());
				frame.setVisible(true);
			} else if (chances == 2) {
				frame.add(panel2());
				frame.setVisible(true);
			} else if (chances == 3) {
				frame.add(panel3());
				frame.setVisible(true);
			} else if (chances == 4) {
				frame.add(panel4());
				frame.setVisible(true);
			} else if (chances == 5) {
				frame.add(panel5());
				frame.setVisible(true);
			} else if (chances == 6) {
				frame.add(panel6());
				frame.setVisible(true);
			} else if (chances == 7) {
				frame.add(panel7());
				frame.setVisible(true);
			} else if (chances == 8) {
				frame.add(panel8());
				frame.setVisible(true);
			} else if (chances == 9) {
				frame.add(panel9());
				frame.setVisible(true);
				System.out.println ("\nSorry " + name + ", you lose!");
				System.out.print ("The answer is: " + movies1[num]);
				break;
			}

			// outputs the new underscore array (some are replaced with letters if the user guesses a correct letter)
			for (int i=0; i<arrayMovies.length; i++){
				System.out.print (arrayMovies[i]+ " ");
			}        

			//displays the letters already entered by the user
			System.out.println ("\n\nLetters already entered:");
			for (int i=0; i<numMovies.length; i++){
				System.out.print (numMovies[i]+ " ");
			}   
			
			winner = checkMovies(); //checks if user has won by calling to "checkMovies" method
			if (winner==true){
				score++; //increases score by 1
			}
		}
		System.out.println ("\n\nYour score is: " + score);

		// After the user has won, clears "arraySongs" and replaces everything back to underscores
		for (int i=0; i<movies1[num].length(); i++){
			arrayMovies[i] = '_';
		}
		winner = false;
		chances = 0;
		playAgain (); 

		//checks to see if user has finished all the categories	
		if (randomSongs1==10 && randomMovies1==10 && randomShows1==10 && randomRiddles1==10 && randomAnimals1==10 && randomCelebrities1==10){
			end ();
		}
	}

	//Shows category method
	public static void shows (){

		boolean test1=true;
		boolean check=true;

		// When the user has finished all 10 questions for a category, tells the user to choose another category.
		if (randomShows1==10){
			System.out.println ("Sorry, you finished all the questions in this category. Please choose another category.");
			category();
		}	

		//check to see if random integer generated is in array already and if it is, generate another random integer
		//if not, store use that integer and store it into the array
		while (test1==true){
			num = ran.nextInt (10); //generates a random integer from 0-9 for generating a random word
			test1=false;
			for (int i=0; i<randomShows.length; i++){
				if (num == randomShows [i]){
					check=false;
					test1=true;
				}
			}
			if (check==true){
				test1=false;
				randomShows [randomShows1]= num;
				randomShows1++;
			}
			check=true;		
		}

		test1=true;
		check=true;


		//array of hints for movies
		String hintShows [] = {"Crime drama. Chemistry elements: Br- , Ba-", "Main Character: Billionaire, playboy. Shipwrecked.", 
				"Based on a comic. Speed." , "Based on a comic. Eyes.", "Crime drama. Serial Killer.", "Prison. Drug dealing women.", 
				"Planewrecked on a mysterious island.", "Popular sitcom. Comedy-drama.", "Popular sitcom. Nerdie. Science-related.",
		"Legal drama. Law and Lawyers."};

		char numShows [] = new char [26]; // declaring an array to store the letters already entered by the user

		System.out.println (hintShows [num]); //outputs the hint for the word

		arrayShows = new char[shows1[num].length()]; // array for underscore characters

		// assigns the array with underscores for the word
		for (int i = 0; i<shows1[num].length(); i++){
			arrayShows[i]='_';
			if (shows1[num].charAt(i) == ' '){
				arrayShows [i] = ' ';
			}               
		}

		// outputs the underscores of the word
		for (int i=0; i<arrayShows.length; i++){
			System.out.print (arrayShows[i] + " ");
		}

		int count = 0; // stores index for "numShows" array

		// while the user has not guessed all the correct letters, asks the user to enter a letter and check if the letter is already entered
		// or is a letter in the word
		while (winner == false){
			boolean checkChances=true;
			System.out.println ("\n");
			System.out.print ("Please enter a letter: ");
			
			// Error checks that user only enters a letter and not a number or special character.
			while (!in.hasNext("[A-Za-z]+")) {
				System.out.print("Sorry, you did not enter a letter. Please enter a letter: ");
				in.next();
			}

			//converts all letters entered into lower case before checking if the letter is in the word
			String input = in.next().toLowerCase();
			char ch = input.charAt(0); // gets character from the user

			// checks if user has already entered the character before
			for (int i=0; i<numShows.length; i++){
				if (ch == numShows[i]){
					System.out.println ("Error. Letter was already entered. Please enter another letter.");
					checkChances=false;
					break;
				}
			}

			boolean entered=true;

			//checks if character entered is already stored in array 'numShows'
			for (int i=0; i<numShows.length; i++){
				if (numShows[i] == ch){
					entered=false;		
					break;
				}
			}

			// if letter is not already in 'numMovies', stores entered character into the array 
			if (entered==true){
				numShows[count] = ch; 
				count++;
			}


			// checks if the letter entered is in the word by going through each letter of the word. If it is, the character replaces the underscore.
			for (int k=0; k<shows1[num].length(); k++){
				if (ch == shows1[num].charAt(k)){
					arrayShows [k]  = ch;
					checkChances = false;
				}
			}

			// if the letter entered is not in the word, the user loses one chance
			if (checkChances==true){
				chances++;
			}

			//draws a hangman part every time the user guesses an incorrect letter
			if (chances == 1) {
				frame.add(panel1());
				frame.setVisible(true);
			} else if (chances == 2) {
				frame.add(panel2());
				frame.setVisible(true);
			} else if (chances == 3) {
				frame.add(panel3());
				frame.setVisible(true);
			} else if (chances == 4) {
				frame.add(panel4());
				frame.setVisible(true);
			} else if (chances == 5) {
				frame.add(panel5());
				frame.setVisible(true);
			} else if (chances == 6) {
				frame.add(panel6());
				frame.setVisible(true);
			} else if (chances == 7) {
				frame.add(panel7());
				frame.setVisible(true);
			} else if (chances == 8) {
				frame.add(panel8());
				frame.setVisible(true);
			} else if (chances == 9) {
				frame.add(panel9());
				frame.setVisible(true);
				System.out.println ("\nSorry " + name + ", you lose!");
				System.out.print ("The answer is: " + shows1[num]);
				break;
			}

			// outputs the new underscore array (some are replaced with letters if the user guesses a correct letter)
			for (int i=0; i<arrayShows.length; i++){
				System.out.print (arrayShows[i]+ " ");
			}        

			//displays the letters already entered by the user
			System.out.println ("\n\nLetters already entered:");
			for (int i=0; i<numShows.length; i++){
				System.out.print (numShows[i]+ " ");
			}   
			
			winner = checkShows(); //checks if user has won by calling to "checkShows" method
			if (winner==true){
				score++; //increases score by 1
			}

		}
		System.out.println ("\n\nYour score is: " + score);

		// After the user has won, clears "arrayShows" and replaces everything back to underscores
		for (int i=0; i<shows1[num].length(); i++){
			arrayShows[i] = '_';
		}

		winner = false;
		chances = 0;
		playAgain ();

		//checks to see if user has finished all the categories	
		if (randomSongs1==10 && randomMovies1==10 && randomShows1==10 && randomRiddles1==10 && randomAnimals1==10 && randomCelebrities1==10){
			end ();
		}
	}

	//Riddles category method
	public static void riddles (){
		
		boolean test1=true;
		boolean check=true;

		// When the user has finished all 10 questions for a category, tells the user to choose another category.
		if (randomRiddles1==10){
			System.out.println ("Sorry, you finished all the questions in this category. Please choose another category.");
			category();
		}	
		
		//check to see if random integer generated is in array already and if it is, generate another random integer
		//if not, store use that integer and store it into the array
		while (test1==true){
			num = ran.nextInt (10); //generates a random integer from 0-9 for generating a random word
			test1=false;
			for (int i=0; i<randomRiddles.length; i++){
				if (num == randomRiddles [i]){
					check=false;
					test1=true;
				}
			}
			if (check==true){
				test1=false;
				randomRiddles [randomRiddles1]= num;
				randomRiddles1++;
			}
			check=true;		
		}

		test1=true;
		check=true;


		//array of hints for riddles
		String hintRiddles [] = {"What can you catch but not throw?", "You bury me when I'm alive, and dig me up when I'm dead. What am I?",
				"What has ten letters and starts with gas?","I'm light as a feather, yet the strongest man can't hold me for more than 5 minutes. What am I?", 
				"There are 6 sisters. Each sister has 1 brother. How many brothers are in the sisters' family?", 
				"What gets broken without being held?", "Timmy's mother has three children. The first was named April. The next was named May. What is the final one's name?", 
				"Different lights make me strange, for each one my size will change.", "I have no wallet but I pay my way. I travel the world but in the corner I stay.",
		"What is something that you always have with you but you always leave behind?"};

		char numRiddles [] = new char [26]; // declaring an array to store the letters already entered by the user

		System.out.println (hintRiddles[num]); //outputs the hint for the word

		arrayRiddles = new char[riddles1[num].length()]; // array for underscore characters

		// assigns the array with underscores for the word
		for (int i = 0; i<riddles1[num].length(); i++){
			arrayRiddles[i]='_';
			if (riddles1[num].charAt(i) == ' '){
				arrayRiddles [i] = ' ';
			}               
		}

		// outputs the underscores of the word
		for (int i=0; i<arrayRiddles.length; i++){
			System.out.print (arrayRiddles[i] + " ");
		}

		int count = 0; // stores index for "numRiddles" array

		// while the user has not guessed all the correct letters, asks the user to enter a letter and check if the letter is already entered
		// or is a letter in the word
		while (winner == false){
			boolean checkChances=true;
			System.out.println ("\n");
			System.out.print ("Please enter a letter: ");
			
			// Error checks that user only enters a letter and not a number or special character.
			while (!in.hasNext("[A-Za-z]+")) {
				System.out.print("Sorry, you did not enter a letter. Please enter a letter: ");
				in.next();
			}

			//converts all letters entered into lower case before checking if the letter is in the word
			String input = in.next().toLowerCase();
			char ch = input.charAt(0); // gets character from the user

			// checks if user has already entered the character before
			for (int i=0; i<numRiddles.length; i++){
				if (ch == numRiddles[i]){
					System.out.println("Error. Letter was already entered. Please enter another letter.");
					checkChances=false;
					break;
				}
			}

			boolean entered=true;

			//checks if character entered is already stored in array 'numShows'
			for (int i=0; i<numRiddles.length; i++){
				if (numRiddles[i] == ch){
					entered=false;		
					break;
				}
			}

			// if letter is not already in 'numMovies', stores entered character into the array 
			if (entered==true){
				numRiddles[count] = ch; 
				count++;
			}


			// checks if the letter entered is in the word by going through each letter of the word. If it is, the character replaces the underscore.
			for (int k=0; k<riddles1[num].length(); k++){
				if (ch == riddles1[num].charAt(k)){
					arrayRiddles [k]  = ch;
					checkChances = false;
				}
			}

			// if the letter entered is not in the word, the user loses one chance
			if (checkChances==true){
				chances++;
			}

			//draws a hangman part every time the user guesses an incorrect letter
			if (chances == 1) {
				frame.add(panel1());
				frame.setVisible(true);
			} else if (chances == 2) {
				frame.add(panel2());
				frame.setVisible(true);
			} else if (chances == 3) {
				frame.add(panel3());
				frame.setVisible(true);
			} else if (chances == 4) {
				frame.add(panel4());
				frame.setVisible(true);
			} else if (chances == 5) {
				frame.add(panel5());
				frame.setVisible(true);
			} else if (chances == 6) {
				frame.add(panel6());
				frame.setVisible(true);
			} else if (chances == 7) {
				frame.add(panel7());
				frame.setVisible(true);
			} else if (chances == 8) {
				frame.add(panel8());
				frame.setVisible(true);
			} else if (chances == 9) {
				frame.add(panel9());
				frame.setVisible(true);
				System.out.println ("\nSorry " + name + ", you lose!");
				System.out.print ("The answer is: " + riddles1[num]);
				break;
			}

			// outputs the new underscore array (some are replaced with letters if the user guesses a correct letter)
			for (int i=0; i<arrayRiddles.length; i++){
				System.out.print (arrayRiddles[i]+ " ");
			}        

			//displays the letters already entered by the user
			System.out.println ("\n\nLetters already entered:");
			for (int i=0; i<numRiddles.length; i++){
				System.out.print (numRiddles[i]+ " ");
			}   
			
			winner = checkRiddles(); //checks if user has won by calling to "checkRiddles" method
			if (winner==true){
				score++; //increases score by 1
			}
		}

		System.out.println ("\n\nYour score is: " + score);

		// After the user has won, clears "arraySongs" and replaces everything back to underscores
		for (int i=0; i<riddles1[num].length(); i++){
			arrayRiddles[i] = '_';
		}

		winner = false;
		chances = 0;
		playAgain ();   

		//checks to see if user has finished all the categories	
		if (randomSongs1==10 && randomMovies1==10 && randomShows1==10 && randomRiddles1==10 && randomAnimals1==10 && randomCelebrities1==10){
			end ();
		}
	}

	//Animals category method
	public static void animals (){

		boolean test1=true;
		boolean check=true;

		// When the user has finished all 10 questions for a category, tells the user to choose another category.
		if (randomAnimals1==10){
			System.out.println ("Sorry, you finished all the questions in this category. Please choose another category.");
			category();
		}	

		//check to see if random integer generated is in array already and if it is, generate another random integer
		//if not, store use that integer and store it into the array
		while (test1==true){
			num = ran.nextInt (10); //generates a random integer from 0-9 for generating a random word
			test1=false;
			for (int i=0; i<randomAnimals.length; i++){
				if (num == randomAnimals [i]){
					check=false;
					test1=true;
				}
			}
			if (check==true){
				test1=false;
				randomAnimals [randomAnimals1]= num;
				randomAnimals1++;
			}
			check=true;		
		}

		test1=true;
		check=true;


		//array of hints for animals
		String hintAnimals [] = {"Four legs. They can sleep both lying down and standing up.", "Stilt-like legs. Able to run on water.",
				"Travel in pods. Ability to use echolocation to locate objects", "Reptile. Discovered from fossils.", 
				"Hop on two legs. Usually live to around 6 years in the wild.", "Weigh up to 140 kg. Female infants are called cows.", 
				"Can sprint 96-120 km/h.", "Herbivores. About 5 m in height.", "Highly inteligent. Can have a tail that is a foot long.", 
		"Black skin but fur apepars white/transparent."};

		char numAnimals [] = new char [26]; // declaring an array to store the letters already entered by the user

		System.out.println (hintAnimals[num]); //outputs the hint for the word

		arrayAnimals = new char[animals1[num].length()]; // array for underscore characters

		// outputs the underscores for the word
		for (int i = 0; i<animals1[num].length(); i++){
			arrayAnimals[i]='_';
			if (animals1[num].charAt(i) == ' '){
				arrayAnimals [i] = ' ';
			}               
		}

		// outputs the underscores of the word
		for (int i=0; i<arrayAnimals.length; i++){
			System.out.print (arrayAnimals[i] + " ");
		}

		int count = 0; // stores index for "numAnimals" array

		// while the user has not guessed all the correct letters, asks the user to enter a letter and check if the letter is already entered
		// or is a letter in the word
		while (winner == false){
			boolean checkChances=true;
			System.out.println ("\n");
			System.out.print ("Please enter a letter: ");
			
			// Error checks that user only enters a letter and not a number or special character.
			while (!in.hasNext("[A-Za-z]+")) {
				System.out.print("Sorry, you did not enter a letter. Please enter a letter: ");
				in.next();
			}

			//converts all letters entered into lower case before checking if the letter is in the word
			String input = in.next().toLowerCase();
			char ch = input.charAt(0); // gets character from the user

			// checks if user has already entered the character before
			for (int i=0; i<numAnimals.length; i++){
				if (ch == numAnimals [i]){
					System.out.println("Error. Letter was already entered. Please enter another letter.");
					checkChances=false;
					break;
				}
			}

			boolean entered=true;

			//checks if character entered is already stored in array 'numShows'
			for (int i=0; i<numAnimals.length; i++){
				if (numAnimals[i] == ch){
					entered=false;		
					break;
				}
			}

			// if letter is not already in 'numMovies', stores entered character into the array 
			if (entered==true){
				numAnimals[count] = ch; 
				count++;
			}

			// checks if the letter entered is in the word by going through each letter of the word. If it is, the character replaces the underscore.
			for (int k=0; k<animals1[num].length(); k++){
				if (ch == animals1[num].charAt(k)){
					arrayAnimals [k]  = ch;
					checkChances = false;
				}
			}

			// if the letter entered is not in the word, the user loses one chance
			if (checkChances==true){
				chances++;
			}

			//draws a hangman part every time the user guesses an incorrect letter
			if (chances == 1) {
				frame.add(panel1());
				frame.setVisible(true);
			} else if (chances == 2) {
				frame.add(panel2());
				frame.setVisible(true);
			} else if (chances == 3) {
				frame.add(panel3());
				frame.setVisible(true);
			} else if (chances == 4) {
				frame.add(panel4());
				frame.setVisible(true);
			} else if (chances == 5) {
				frame.add(panel5());
				frame.setVisible(true);
			} else if (chances == 6) {
				frame.add(panel6());
				frame.setVisible(true);
			} else if (chances == 7) {
				frame.add(panel7());
				frame.setVisible(true);
			} else if (chances == 8) {
				frame.add(panel8());
				frame.setVisible(true);
			} else if (chances == 9) {
				frame.add(panel9());
				frame.setVisible(true);
				System.out.println ("\nSorry " + name + ", you lose!");
				System.out.print ("The answer is: " + animals1[num]);
				break;
			}

			// outputs the new underscore array (some are replaced with letters if the user guesses a correct letter)
			for (int i=0; i<arrayAnimals.length; i++){
				System.out.print (arrayAnimals [i]+ " ");
			}    
			
			//displays the letters already entered by the user
			System.out.println ("\n\nLetters already entered:");
			for (int i=0; i<numAnimals.length; i++){
				System.out.print (numAnimals[i]+ " ");
			}   

			winner = checkAnimals(); //checks if user has won by calling to "checkAniamls" method
			if (winner==true){
				score++; //increases score by 1
			}
		}
		System.out.println ("\n\nYour score is: " + score);

		// After the user has won, clears "arrayMovies" and replaces everything back to underscores
		for (int i=0; i<animals1[num].length(); i++){
			arrayAnimals[i] = '_';
		}

		winner = false;
		chances = 0;
		playAgain ();    

		//checks to see if user has finished all the categories	
		if (randomSongs1==10 && randomMovies1==10 && randomShows1==10 && randomRiddles1==10 && randomAnimals1==10 && randomCelebrities1==10){
			end ();
		}
	}

	//Celebrities category method
	public static void celebrities (){

		boolean test1=true;
		boolean check=true;

		// When the user has finished all 10 questions for a category, tells the user to choose another category.
		if (randomCelebrities1==10){
			System.out.println ("Sorry, you finished all the questions in this category. Please choose another category.");
			category();
		}	
		
		//checks to see if random integer generated is in array already and if it is, generate another random integer
		//if not, store use that integer and store it into the array
		while (test1==true){
			num = ran.nextInt (10); //generates a random integer from 0-9 for generating a random word
			test1=false;
			for (int i=0; i<randomCelebrities.length; i++){
				if (num == randomCelebrities [i]){
					check=false;
					test1=true;
				}
			}
			if (check==true){
				test1=false;
				randomCelebrities [randomCelebrities1]= num;
				randomCelebrities1++;
			}
			check=true;		
		}

		test1=true;
		check=true;

		//array of hints for celebrities
		String hintCelebrities [] = {"Young Singer, trending hair-style.", "Actor. Starring in 21 Jump Street.",
				"Famous singer. Won four Grammy awards.","Nominated for ten Golden Globe Awards. Starred in Romeo and Juliet.",
				"Won three Golden Globe Awards. Starred in Mission: Impossible.", "Actress. 'Oh shit Brad Pitt'.","King of Pop.",
				"British female singer. A James Bond film with a same name as one of her tracks.", 
				"Canadian female singer. Famous song starred in Titanic.",
		"Famous American actor in Action-comedy. Listed as the 'Richest 40' in America under the age of 40."};

		char numCelebrities [] = new char [26]; // declaring an array to store the letters already entered by the user

		System.out.println (hintCelebrities[num]); //outputs the hint for the word

		arrayCelebrities = new char[celebrities1[num].length()]; // array for underscore characters

		// outputs the underscores for the word
		for (int i = 0; i<celebrities1[num].length(); i++){
			arrayCelebrities[i]='_';
			if (celebrities1[num].charAt(i) == ' '){
				arrayCelebrities [i] = ' ';
			}               
		}

		// outputs the underscores of the word
		for (int i=0; i<arrayCelebrities.length; i++){
			System.out.print (arrayCelebrities[i] + " ");
		}

		int count = 0; //stores index for "numCelebrities" array

		// while the user has not guessed all the correct letters, asks the user to enter a letter and check if the letter is already entered
		// or is a letter in the word
		while (winner == false){
			boolean checkChances=true;
			System.out.println ("\n");
			System.out.print ("Please enter a letter: ");
			
			// Error checks that user only enters a letter and not a number or special character.
			while (!in.hasNext("[A-Za-z]+")) {
				System.out.print("Sorry, you did not enter a letter. Please enter a letter: ");
				in.next();
			}
			
			//converts all letters entered into lower case before checking if the letter is in the word
			String input = in.next().toLowerCase();
			char ch = input.charAt(0); // gets character from the user

			// checks if user has already entered the character before
			for (int i=0; i<numCelebrities.length; i++){
				if (ch == numCelebrities [i]){
					System.out.println("Error. Letter was already entered. Please enter another letter.");
					checkChances=false;
					break;
				}
			}

			boolean entered=true;

			//checks if character entered is already stored in array 'numShows'
			for (int i=0; i<numCelebrities.length; i++){
				if (numCelebrities[i] == ch){
					entered=false;		
					break;
				}
			}

			// if letter is not already in 'numMovies', stores entered character into the array 
			if (entered==true){
				numCelebrities[count] = ch; 
				count++;
			}

			// checks if the letter entered is in the word by going through each letter of the word. If it is, the character replaces the underscore.
			for (int k=0; k<celebrities1[num].length(); k++){
				if (ch == celebrities1[num].charAt(k)){
					arrayCelebrities [k]  = ch;
					checkChances = false;
				}
			}


			// if the letter entered is not in the word, the user loses one chance
			if (checkChances==true){
				chances++;
			}

			//draws a hangman part every time the user guesses an incorrect letter
			if (chances == 1) {
				frame.add(panel1());
				frame.setVisible(true);
			} else if (chances == 2) {
				frame.add(panel2());
				frame.setVisible(true);
			} else if (chances == 3) {
				frame.add(panel3());
				frame.setVisible(true);
			} else if (chances == 4) {
				frame.add(panel4());
				frame.setVisible(true);
			} else if (chances == 5) {
				frame.add(panel5());
				frame.setVisible(true);
			} else if (chances == 6) {
				frame.add(panel6());
				frame.setVisible(true);
			} else if (chances == 7) {
				frame.add(panel7());
				frame.setVisible(true);
			} else if (chances == 8) {
				frame.add(panel8());
				frame.setVisible(true);
			} else if (chances == 9) {
				frame.add(panel9());
				frame.setVisible(true);
				System.out.println ("\nSorry " + name + ", you lose!");
				System.out.print ("The answer is: " + celebrities1[num]);
				break;
			}

			// outputs the new underscore array (some are replaced with letters if the user guesses a correct letter)
			for (int i=0; i<arrayCelebrities.length; i++){
				System.out.print (arrayCelebrities [i]+ " ");
			}        

			//displays the letters already entered by the user
			System.out.println ("\n\nLetters already entered:");
			for (int i=0; i<numCelebrities.length; i++){
				System.out.print (numCelebrities[i]+ " ");
			}   
			
			winner = checkCelebrities(); //checks if user has won by calling to "checkCelebrities" method
			if (winner==true){
				score++; //increases score by 1
			}
		}

		System.out.println ("\n\nYour score is: " + score);

		// After the user has won, clears "arrayMovies" and replaces everything back to underscores
		for (int i=0; i<celebrities1[num].length(); i++){
			arrayCelebrities[i] = '_';
		}

		winner = false;
		chances = 0;
		playAgain ();

		//checks to see if user has finished all the categories	
		if (randomSongs1==10 && randomMovies1==10 && randomShows1==10 && randomRiddles1==10 && randomAnimals1==10 && randomCelebrities1==10){
			end ();
		}
	}

	// end method - congratulates the user for completing the entire game
	public static void end (){
		System.out.println ("Congratulations, you have finished the game! Your final score is: " + score + "/60");
		System.out.println ("Thank you for playing, " + name);
		System.exit(0); // manually terminate (closes JFrame, and terminates console)
	}
}
