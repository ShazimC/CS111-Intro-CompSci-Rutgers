/**
  * Rutgers, The State University of New Jersey
  * CS 111 Movie Driver
  * Joseph A. Boyle (joseph.a.boyle@rutgers.edu)
  * April 4, 2018
  */

class MovieDriver{

	public static void main(String[] args){
		MovieApp app = new MovieApp();

		printSeparator();
		System.out.println("Created a Movie app with the default constructor.");
		System.out.println("Would you like to load in the first 20 movies? (Y for yes or n for no)");
		if(IO.readBoolean()) loadAllMovies(app, getSampleMovies1());

		System.out.println("Would you like to load in the last of the movies? (Y for yes or n for no)");
		if(IO.readBoolean()) loadAllMovies(app, getSampleMovies2());
		printSeparator();

		printSeparator();
		printSeparator();

		System.out.println("You have loaded a total of: " + app.getNumberOfItems() + " movies.");
		System.out.println("Now entering user interactivity mode.");

		printSeparator();
		printSeparator();


		userActivityMode(app);
	}

	public static void userActivityMode(MovieApp app){
		String operation = "";
		while(!operation.equals("exit")){
			printSeparator();

			System.out.println("Possible Commands:");
				System.out.println("\tprint:\t\tprint all of the movies.");
				System.out.println("\tdirector:\tget all movies by a director.");
				System.out.println("\tyear:\t\tget all movies by a year.");
				System.out.println("\trating:\t\tget all movies about a certain rating.");
				System.out.println("\tremove:\t\tRemoves a movie at a certain index.");
				System.out.println("\tupdate:\t\tUpdate the ratings of a movie.");
				System.out.println("\texit:\t\tstop the program.");
			System.out.println("");
			System.out.println("What would you like to do? (use the commands above. For example, type print to print all movies): ");
			System.out.println("You may type exit or press Control C to stop this program.");

			operation = IO.readString();
			
			switch(operation){
				case "exit":
					return;
				case "print":
					appPrint(app);
					break;
				case "director":
					appDirector(app);
					break;
				case "remove":
					appRemove(app);
					break;
				case "update":
					appUpdate(app);
					break;
				case "year":
					appYear(app);
					break;
				case "rating":
					appRating(app);
					break;
				default:
					System.out.println("Unknown command: " + operation);
					break;
			}

			System.out.println("Please press enter to continue.");
			IO.readString(); // we ignore whatever is entered, we just was confirmation before continuing.

			printSeparator();
		}
	}

	public static void appPrint(MovieApp app){
		System.out.println("Printing all of the movies stored in the app.");
		app.print();
	}

	public static void appDirector(MovieApp app){
		System.out.println("Which director would you like to search by?");
		String director = IO.readString();

		Movie[] byDirector = app.getMoviesByDirector(director);

		System.out.println("Found " + byDirector.length + " movies by director " + director + ":");
		for(Movie m : byDirector){
			System.out.println(m.toString());
		}
	}

	public static void appYear(MovieApp app){
		System.out.println("Which Year would you like to search by?");
		int year = IO.readInt();

		Movie[] byYear = app.getMoviesByYear(year);

		System.out.println("Found " + byYear.length + " movies in year " + year + ":");
		for(Movie m : byYear){
			System.out.println(m.toString());
		}
	}

	public static void appRating(MovieApp app){
		System.out.println("What is the minimum rating would you like to search by?");
		int rating = IO.readInt();

		Movie[] byRating = app.getMoviesWithRatingsGreaterThan(rating);

		System.out.println("Found " + byRating.length + " movies with a rating at least " + rating + ":");
		for(Movie m : byRating){
			System.out.println(m.toString());
		}
	}

	public static void appUpdate(MovieApp app){
		System.out.println("Here are all of the movies with their numbers:");
		Movie[] movies = app.getMovies();
		for(int i = 0; i < app.getNumberOfItems(); i ++){
			System.out.println("[" + i + "]: " + movies[i].toString());
		}

		System.out.println("Please enter the number of the movie you'd like to update");
		int i = IO.readInt();
		if(i < 0 || i >= app.getNumberOfItems()){
			System.out.println("i out of bounds.");
			return;
		}

		System.out.println("Updating movie " + i + ": " + movies[i].toString());

		System.out.println("Enter the new rating for the movie [1 through 5]");
		int newRating = IO.readInt();

		app.updateRating(movies[i], newRating);

	}

	public static void appRemove(MovieApp app){
		System.out.println("Here are all of the movies with their numbers:");
		Movie[] movies = app.getMovies();
		for(int i = 0; i < app.getNumberOfItems(); i ++){
			System.out.println("[" + i + "]: " + movies[i].toString());
		}

		System.out.println("Please enter the number of the movie you'd like to remove");
		int i = IO.readInt();
		if(i < 0 || i >= app.getNumberOfItems()){
			System.out.println("i out of bounds.");
			return;
		}

		System.out.println("Removing movie " + i + ": " + movies[i].toString());

		app.removeMovie(movies[i]);
	}

	public static void printSeparator(){
		System.out.println("====================================================");
	}

	public static void loadAllMovies(MovieApp app, Movie[] movies){
		for(int i = 0; i < movies.length; i ++){
			System.out.println("Loading Movie #" + (i + 1) + ": " + movies[i].toString());
			app.addMovie(movies[i]);
		}
	}

	public static Movie[] getSampleMovies2(){
		int numMovies = 6;

		String[] names = 		{"Patton", "Braveheart", "Jurassic Park", "The Exorcist", "The Grapes of Wrath", "The Green Mile"};
		String[] directors = 	{"Franklin J. Schaffner", "Mel Gibson", "Steven Spielberg", "William Friedkin", "John Ford", "Frank Darabont"};
		int[] years = 			{1970, 1995, 1993, 1973, 1940, 1999};
		int[] ratings = 		{1, 4, 5, 3, 1, 5};
		String[] descriptions = {"It's all about WWII", "Freeeeeedoooooom", "Dinosaurs make a Comeback", "Quite Scary", "Some awfuly angry Grapes", "I'd be Wrong to not include a Steven King book"};
		
		Movie[] movies = new Movie[numMovies];
		for(int i = 0; i < numMovies; i ++){
			Movie m = new Movie(names[i]);
			m.setDirector(directors[i]);
			m.setYear(years[i]);
			m.setRatings(ratings[i]);
			m.setDescription(descriptions[i]);
			movies[i] = m;
		}

		return movies;
	}

	// A bunch of movies, 20 in total.
	// These should be loaded first.
	public static Movie[] getSampleMovies1(){
		int numMovies = 20;

		String[] names = 		{"The Shawshank Redemption","Schindler's List",	"The Wizard of Oz",	"One Flew Over the Cuckoo's Nest",	"Forrest Gump", "The Sound of Music", "West Side Story", "Star Wars IV", "2001: A Space Odyssey", "E.T", "The Silence of the Lambs", "It's a Wonderful Life", "The Lord of The Rings: Return of the Kind", "Gladiator", "Titanic", "Saving Private Ryan", "Raiders of the Lost Arc", "Rocky I", "To Kill a Mockingbird", "Jaws"};
		String[] directors = {"Frank Darabont", "Steven Spielberg", "Victor Flemming", "Milos Forman", "Robert Zemeckis", "Robert Wise", "Robert Wise", "George Lucas", "Stanley Kubrik", "Steven Spielberg", "Jonathan Demme", "Frank Capra", "Peter Jackson", "Ridley Scott", "James Cameron", "Steven Spielberg", "Steven Spielberg", "John G. Avildsen", "Robert Mulligan", "Steven Spielberg"};
		int[] years = {1994, 1993, 1939, 1975, 1994, 1965, 1961, 1977, 1968, 1982, 1992, 1946, 2003, 2000, 1997, 1998, 1981, 1976, 1962, 1975};
		int[] ratings = {5, 5, 4, 5, 4, 5, 3, 4, 3, 2, 3, 1, 1, 5, 3, 4, 2, 5, 2, 4};
		String[] descriptions = {"Prison Break", "It's a classic", "Follow the Road", "Don't mess with Big Nurse", "Bubba Gump Shrimp", "Do re me fa so la te do", "Not to be confused with the musical", "Use the Force, Luke", "Ground Control to Major Tom...", "E.T. Phone Home", "Surprisingly not about butterflies", "What a Wonderful World", "You're chosen, Bilbo Baggins", "A Film about Vengence", "Talk about Sinking Ships", "No man left behind", "Don't forget your hat, Indiana", "Win, Rocky!", "Two birds, one stone", "Sharks, in New Jersey"};
	
		Movie[] movies = new Movie[numMovies];
		for(int i = 0; i < numMovies; i ++){
			Movie m = new Movie(names[i]);
			m.setDirector(directors[i]);
			m.setYear(years[i]);
			m.setRatings(ratings[i]);
			m.setDescription(descriptions[i]);
			movies[i] = m;
		}

		return movies;
	}


}
