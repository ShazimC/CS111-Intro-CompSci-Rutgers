public class LuckySevens{
	public static void main(String args[]){
		System.out.println("Please enter the lowest range: ");
		int min = IO.readInt();
		System.out.println("Please enter the highest range: ");
		int max = IO.readInt();

		if(max <= min){
			IO.outputIntAnswer(-1);
		} else{

		int sevenCount = 0;
		
		for(int i = min; i<=max; i++) {
			for(int j = 1; j<=Math.abs(i); j*=10) {
				if(Math.abs((i/j)%10) == 7)
					sevenCount++;
			}
		}

		IO.outputIntAnswer(sevenCount);
		}
	}
}
