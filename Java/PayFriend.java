public class PayFriend{
	public static void main(String args[]){

		double payment;
		double totalFee = 0;
		System.out.println("Please enter payment amount: ");
		payment = IO.readDouble();

		while(payment <= 0){
			System.out.println("Please enter positive payment: ");
			payment = IO.readDouble();
		} if(payment > 0 && payment <= 100){
			totalFee = 5;
		} else if(payment > 100 && payment < 1000){
			totalFee = Math.max(0.03*payment, 6.0);
		} else if(payment >= 1000 && payment < 10000){
			totalFee = Math.max(0.01*payment, 15.0);
		} else if(payment >=10000){
			if(payment >= 10000 && payment < 15000){
				totalFee = 100 + 0.02*(payment - 10000);
			} else if(payment >= 15000){
				totalFee = 200 + 0.03*(payment - 15000);
			}
		}

		IO.outputDoubleAnswer(totalFee);
	}
}