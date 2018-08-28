public class MatrixOps{

	public static double[][] multiply(double[][] A, double[][] B){
		double[][] ADotB;
		int temp = 0;
		int columnsA = A[0].length;


		if(columnsA == B.length){
		ADotB = new double[A.length][B[0].length];
		for(int i= 0; i<ADotB.length; i++ ){
		
			for(int d = 0; d<ADotB[i].length; d++){
			
				for(int f = 0; f<A[i].length && f<B.length; f++){
					temp += A[i][f]*B[f][d];
					ADotB[i][d] = temp;
				}
				temp = 0;
			}
		
		}
			return 	ADotB;
		}
			else return null;
	}
		
}