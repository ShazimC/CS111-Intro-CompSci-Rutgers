public class Compress{

    public static void main(String [] args){

        String word = "";

        while(word.equals("0") == false){
            System.out.println("Please enter a word to compress: ");
            word = IO.readString();

            System.out.println(compress(word));
        }

    }
    
    public static String compress ( String original ){

        String output = "";
        int charCount = 1;
        int i;

        for(i=0; i<original.length()-1; i++){
            
            char prev = original.charAt(i);

            if(prev == original.charAt(i+1)){
                charCount++;

                if(i == original.length()-2) {
                    output += charCount + original.substring(i, original.length()-1);
                }
            }else {
                if(charCount == 1){
                    output += original.substring(i, i+1);
                }else{
                    output += charCount + original.substring(i, i+1);
                    charCount = 1;
                }
            }

        }

        if(i == original.length()-1 && charCount == 1)
            output += original.substring(i, original.length());

        return output;    
    }
}