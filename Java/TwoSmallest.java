public class TwoSmallest{

public static void main(String[] args){
	 
	System.out.println("Please enter your terminating value:");
	double terminatingValue = IO.readDouble();
	
	System.out.println("Enter the first number of the list: ");
	double input = IO.readDouble();

	while (input == terminatingValue){
		IO.reportBadInput();
		System.out.print("Please enter a different number than your terminating value: ");
	}

	double lowest = input;
	double secondLowest = input;

	System.out.println("Enter another number: ");
	input = IO.readDouble();
	
	while (input == terminatingValue){
		IO.reportBadInput();
		System.out.print("Please enter a different number than your terminating value: ");
	}

	secondLowest = Math.max(lowest,input);
	lowest = Math.min(lowest,input);
	
	while(input != terminatingValue){
		System.out.println("Enter another value or enter your terminating value: ");
		input = IO.readDouble();

		if (input == terminatingValue)
			break;
		else if (input < lowest){
			secondLowest = Math.max(lowest , input);
			lowest = Math.min(lowest , input);
		}else if (input > lowest){
			secondLowest = Math.min(secondLowest,input);
		}else secondLowest= input;
	
	}

	IO.outputDoubleAnswer(lowest);
	IO.outputDoubleAnswer(secondLowest);


	}
}