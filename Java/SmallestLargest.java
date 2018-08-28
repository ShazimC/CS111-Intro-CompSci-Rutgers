public class SmallestLargest{
	public static void main(String args[]){
		
		System.out.println("Please enter the terminating value: ");
		double end = IO.readDouble();

		System.out.println("Enter input #1: ");
		double input = IO.readDouble();
		

		int i = 1; // count
		double max = input;
		double min = input;
		
		if(i < 2 && input == end){
				IO.reportBadInput();
		} else{

		while(input != end){

			i++; // next value
			if(i == 2)
				System.out.println("Enter input #" +i+":" );
			else System.out.println("Enter terminating value or input # " +i+":" );
			input = IO.readDouble();

			if(input == end)
				break;

			max = Math.max(max, input);
			min = Math.min(min, input);

		}

		IO.outputDoubleAnswer(min);
		IO.outputDoubleAnswer(max);
		}
	}
}
