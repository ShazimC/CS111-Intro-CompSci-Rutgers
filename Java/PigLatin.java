public class PigLatin{
	
	public static String translate( String original ) {
		
		if(original.substring(0, 1).equalsIgnoreCase("A") || original.substring(0, 1).equalsIgnoreCase("E") || original.substring(0, 1).equalsIgnoreCase("I") || original.substring(0, 1).equalsIgnoreCase("O") || original.substring(0, 1).equalsIgnoreCase("U")) {
			return original + "vai";
		}else {
				original = original.substring(1, original.length()) + original.charAt(0) + "ai";
				return original;
		}
	
	}
}