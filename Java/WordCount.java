public class WordCount{
	public static void main(String [] args){

		System.out.println("Please enter a sentence: ");
		String sentence = IO.readString();

		System.out.println("Please enter max length: ");
		int mL = IO.readInt();

		System.out.println("Number of words of this length in this sentence: " + countWords(sentence, mL));
	}

	public static int countWords( String original, int maxLength ){
		int countWords = 0;
		String word;

		if(original.length() < 1){
			return 0;

		}else if(original.indexOf(" ") < 0 ){

			if(countLetters(original) > 0 && countLetters(original) <= maxLength)
				countWords ++;

		}else{

			for(int k = 0; k < original.length()-1; k++){

				while(original.charAt(k) == ' '){
					k++;
				}

				if(original.indexOf(" ", k) > -1){
					word = original.substring(k, original.indexOf(" ", k));
					k += countLetters(word);
				}
				else {
					word = original.substring(k, original.length());
					k += countLetters(word);
				}

				if( countLetters(word) > 0 && countLetters(word) <= maxLength )
					countWords ++;

			}
		}

		return countWords;
	}

	public static int countLetters( String word ){
		int countLetters = 0;

		for(int i = 0; i < word.length(); i++){
			if((word.charAt(i)>='A' && word.charAt(i)<='Z') || (word.charAt(i)>='a' && word.charAt(i)<='z'))
				countLetters++;
		}

		return countLetters;
	}
}