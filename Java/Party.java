
public class Party{
	public static void main(String args[]){

		System.out.println("How many people are attending the party?: ");
		int peopleAttending = IO.readInt();

		System.out.println("How many slices of pizza is each person going to eat?: ");
		int slicesPerPerson = IO.readInt();

		System.out.println("How many cans of soda is each person going to drink?: ");
		int sodasPerPerson = IO.readInt();

		System.out.println("What is the cost of a pizza pie?: ");
		double pizzaPieCost = IO.readDouble();

		System.out.println("How many slices are in the pie?:");
		int slicesPerPie = IO.readInt();

		System.out.println("What is the cost of a case of soda?: ");
		double sodaCaseCost = IO.readDouble();

		System.out.println("How many cans are in the case of soda?:");
		int cansInSodaCase = IO.readInt();


		double totalPizzaCost = Math.ceil(((peopleAttending*slicesPerPerson)/(double)(slicesPerPie)))*pizzaPieCost;
		double totalSodaCost = Math.ceil((peopleAttending*sodasPerPerson)/(72.0))*sodaCaseCost;
		double totalCost = totalPizzaCost + totalSodaCost;

		//System.out.println(totalPizzaCost + " " + totalSodaCost);
		IO.outputDoubleAnswer(Math.round(totalCost*100.0)/100.0);


		
	}
}