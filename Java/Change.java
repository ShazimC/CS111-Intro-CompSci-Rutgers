public class Change{
	public static void main(String args[]){
		double a = IO.readDouble();
		double b = IO.readDouble();

		change(a, b);
	}


	public static void change(double saleTotal, double customerPayment){

		double change = customerPayment - saleTotal;
		int count130Bills = 0;
		int count55Bills = 0;
		int count25Bills = 0;
		int count5Bills = 0;
		int count1Bills = 0;
		int count75Cents = 0;
		int count30Cents = 0;
		int count1Cents = 0;

		if((saleTotal<=0 || customerPayment <= 0) || (customerPayment < saleTotal)){
			IO.reportBadInput();
			IO.outputIntAnswer(-1);
		} else {

		count130Bills = (int)(change/130);
		change -= count130Bills*130;

		count55Bills = (int)(change/55);
		change -= count55Bills*55;

		count25Bills = (int)(change/25);
		change -= count25Bills*25;

		count5Bills = (int)(change/5);
		change -= count5Bills*5;

		count1Bills = (int)(change/1);
		change -= count1Bills*1;

		count75Cents = (int)(change/0.75);
		change -= count75Cents*0.75;

		count30Cents = (int)(change/0.30);
		change -= count30Cents*0.30;

		count1Cents = (int)(change/0.01);
		change -= count1Cents*0.01;

		IO.outputIntAnswer(count130Bills);
		IO.outputIntAnswer(count55Bills);
		IO.outputIntAnswer(count25Bills);
		IO.outputIntAnswer(count5Bills);
		IO.outputIntAnswer(count1Bills);
		IO.outputIntAnswer(count75Cents);
		IO.outputIntAnswer(count30Cents);
		IO.outputIntAnswer(count1Cents);
		}
		
	}
}