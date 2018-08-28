/*
 * The Movie class
 *
 * @author runb-cs111
 */

public class Movie implements Comparable <Movie> {

	private String name;         // the movie name
	private String director;     // the director's name
	private int year;            // movie release year
	private String description;  // movie short description
	private int ratings;         // rating from 1 (didn't like) to 5 (loved it)

	/*
	 * Constructor initializes the new Movie object.
	 * @param name This is the movie name
	 */
	public Movie ( String name ) {
		setName ( name );
	}

	/*
	 * Updates the movie's name.
	 * @param name is the new name
	 */
	public void setName ( String name ) {
		this.name = name;
	}

	/*
	 * Returns this movie name
	 * @return String the movie name
	 */
	public String getName () {
		return name;
	}

	/*
	 * Updates the director's name.
	 * @param director is the new director's name
	 */
	public void setDirector ( String director ) {
		this.director = director;
	}

	/*
	 * Returns the director's name
	 * @return String the director's name
	 */
	public String getDirector () {
		return director;
	}

	/*
	 * Updates the movie's description
	 * @param description is the new short description
	 */
	public void setDescription ( String description ) {
		this.description = description;
	}

	/*
	 * Return the movie's description
	 * @return String the short movie's description
	 */
	public String getDescription () {
		return description;
	}

	/*
	 * Updates the release year
	 * @param year is the new year
	 */
	public void setYear ( int year ) {
		this.year = year;
	}

	/*
	 * Returns the year the movie was released
	 * @return int the year
	 */
	public int getYear () {
		return year;
	}

	/*
	 * Updates the movie's ratings
	 * @param ratings is the new rating
	 */
	public void setRatings ( int ratings ) {
		this.ratings = ratings;
	}

	/*
	 * Returns the movie rating
	 * @return int the rating
	 */
	public int getRatings () {
		return ratings;
	}

	/*
	 * Returns the string representation of the movie.
	 * @return String the string representation
	 */
	public String toString () {
		return String.format("%s - %d [Rate: %d]\n", name, year, ratings);
	}

	/*
	 * Check is two movies have the same name
	 * @return boolean true if other'name is the same as this.name, or false if they don't
	 */
	public boolean equals ( Object other ) {
		if ( other == null || !(other instanceof Movie) ) {
			return false;
		}
		Movie o = (Movie) other;
		return this.name.equals(o.name) && this.year == o.year && this.director.equals(o.director);
	}
	/*
	 * Compares this movie name against @other lexicographically.
	 * @return int positive number if s1 > s2, negative number if s1 < s2, zero if s1 == s2
	 */
	public int compareTo (Movie other) {
		return this.name.compareTo(other.name);
	}
}
