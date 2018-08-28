/*
 * 
 * This class implements a library of movies
 *
 * @author runb-cs111
 *
 */
public class MovieApp {

    private Movie[] items;     // keep movies in an unsorted array
    private int numberOfItems; // number of movies in the array
	
    /*
     * Default constructor allocates array with capacity for 20 movies
     */
    MovieApp () {
	/** COMPLETE THIS METHOD **/
        numberOfItems = 0;
        items = new Movie [20];
    }
	
    /*
     * One argument constructor allocates array with user defined capacity
     *
     * @param capacity defines the capacity of the movie library
     */
    MovieApp (int capacity) {
	/** COMPLETE THIS METHOD **/
        numberOfItems = 0;
        items = new Movie [capacity];
    }

    /*
     * Add a movie into the library (unsorted array)
     *
     * Inserts @m into the first empty spot in the array.
     * If the array is full (there is no space to add another movie)
     *   - create a new array with double the size of the current array
     *   - copy all current movies into new array
     *   - add new movie
     *
     * @param m The movie to be added to the libary
     *
     */
    public void addMovie (Movie m) {
	/** COMPLETE THIS METHOD **/
        int emptySpot = -1;
        for(int i = 0; i < this.items.length; i++){
            if(this.items[i] ==  null){
                emptySpot = i;
                break;
            }
        }

        if(emptySpot == -1){
            Movie[] newMovieList = new Movie [items.length*2];

            for(int i = 0; i < this.items.length; i++){
                newMovieList[i] = items[i];
            }
            newMovieList[this.items.length] = m;
            this.items = newMovieList;
            numberOfItems ++;
        } else {
            this.items[emptySpot] = m;
            numberOfItems ++;
        }

    }

    /*
     * Removes a movie from the library. Returns true if movie is removed, false
     * otherwise.
     * The array should NOT become sparse after a remove, that is, all movies
     * should be in consecutive array indices.
     * 
     * @param m The movie to be removed
     * @return Returns true is movie is successfuly removed, false otherwise
     *
     */
    public boolean removeMovie (Movie m) {
	/** COMPLETE THIS METHOD **/
	// THE FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
	// Change as needed for your implementation

        if(this.movieIndex(m) > -1){

            int mIndex = this.movieIndex(m);
            this.items[mIndex] = null; // removing m

            for(int i = mIndex; i < this.numberOfItems-1; i++){
                Movie temp = this.items[i];
                items[i] = items[i+1];
                items[i+1] = temp; // moving everything back
            }
            numberOfItems--;
            return true;
        }else return false;

    }

    /*
     * Returns the library of movies
     *
     * @return The array of movies
     */
    public Movie[] getMovies () {
	/** COMPLETE THIS METHOD **/
	// THE FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
	// Change as needed for your implementation
	   return this.items;
    }

    /*
     * Returns the current number of movies in the library
     *
     * @return The number of items in the array
     */
    public int getNumberOfItems () {
	/** COMPLETE THIS METHOD **/
	// THE FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
	// Changed as needed for your implementation
	   return this.numberOfItems;
    }
    
    /*
     * Update the rating of movie @m to @ratings
     * 
     * @param @m The movie to have its ratings updated
     * @param @ratings The new ratings of @m
     * @return tue if update is successfull, false otherwise
     *
     */
    public boolean updateRating (Movie m, int ratings) {
	/** COMPLETE THIS METHOD **/
	// THE FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
	// Changed as needed for your implementation	

        if(this.movieIndex(m) > -1){
            int mIndex = this.movieIndex(m);
            this.items[mIndex].setRatings(ratings);
            return true;
        } else return false;
	
    }
    
    /*
     * Prints all movies
     */
    public void print () {
	/** COMPLETE THIS METHOD **/
        for( int i=0; i < this.items.length; i++){
            System.out.println(this.items[i]);
        }
    }

    /*
     * Return all the movies by @director. The array size should be the 
     * number of movies by @director.
     *
     * @param director The director's name
     * @return An array of all the movies by @director
     *
     */
    public Movie[] getMoviesByDirector (String director) {
	/** COMPLETE THIS METHOD **/
	// THE FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
	// Changed as needed for your implementation	

        int count = 0;

        for(int i = 0; i < this.numberOfItems; i++){
            if(this.items[i].getDirector().equals(director))
                count++;
        }

        Movie[] output = new Movie[count];
        int j = 0;

        for(int k = 0; k < this.numberOfItems; k++){
            if(this.items[k].getDirector().equals(director)){
                output[j] = this.items[k];
                j++;
            }
        }

	   return output;
    }
    
    /*
     * Returns all the movies made in @year. The array size should be the
     * number of movies made in @year.
     *
     * @param year The year the movies were made
     * @return An array of all the movies made in @year
     *
     */
    public Movie[] getMoviesByYear (int year) {
	/** COMPLETE THIS METHOD **/
	// THE FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
	// Changed as needed for your implementation	
        int count = 0;

        for(int i = 0; i < this.numberOfItems; i++){
            if(this.items[i].getYear() == year)
                count++;
        }

        Movie[] output = new Movie[count];
        int j = 0;

        for(int k = 0; k < this.numberOfItems; k++){
            if(this.items[k].getYear() == year){
                output[j] = this.items[k];
                j++;
            }
        }

       return output;
    }
	
    /*
     * Returns all the movies with ratings greater then @ratings. The array
     * size should match the number of movies with ratings greater than @ratings
     *
     * @param ratings
     * @return An array of all movies with ratings greater than @ratings
     *
     */
    public Movie[] getMoviesWithRatingsGreaterThan (int ratings) {
	/** COMPLETE THIS METHOD **/
	// THE FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
	// Changed as needed for your implementation	

        int count = 0;

        for(int i = 0; i < this.numberOfItems; i++){
            if(this.items[i].getRatings() >= ratings)
                count++;
        }

        Movie[] output = new Movie[count];
        int j = 0;

        for(int k = 0; k < this.numberOfItems; k++){
            if(this.items[k].getRatings() >= ratings){
                output[j] = this.items[k];
                j++;
            }
        }

       return output;

    }

    private int movieIndex (Movie a){
        
        int aIndex = -1;

        for(int i=0; i < this.items.length; i++){
            if(this.items[i].equals(a)){
                
                aIndex = i;
                break;
            }
        }

        return aIndex;
    }
}
