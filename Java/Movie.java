public class Movie{

	private String name;
	private int year;
	private String director;
	private String description;
	private int ratings;
	
	public Movie(String a){
		name = a;
	}

	public String getName(){
		return name;
	}

	public void setName(String a){
		name = a;
	}

	public int getYear(){
		return year;
	}

	public void setYear(int b){
		year = b;
	}

	public String getDirector(){
		return director;
	}

	public void setDirector(String c){
		director = c;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String d){
		description = d;
	}

	public int getRatings(){
		return ratings;
	}

	public void setRatings(int e){
		ratings = e;
	}

	public boolean equals(Object other){
		Movie Other = (Movie) other;
		return( this.getName().equals(Other.getName()) && this.getDirector().equals(Other.getDirector()) && this.getYear() == Other.getYear() );
	}

	public int compareTo(Movie other){
		if(this.getName().compareTo(other.getName()) == 0)
			return 0;
		else
			return( (this.getName().compareTo(other.getName()))/(Math.abs(this.getName().compareTo(other.getName()))) );
	}

	public String toString(){
		return (name + ", " + year + ", " + ratings);
	}


}