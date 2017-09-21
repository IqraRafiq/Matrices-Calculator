import java.util.Random;
import java.util.Scanner;

public class Calculator {
	
		private  int col, row;
		private  int myMatrix [][];
		private  double tempMatrix [][];
	     private  int lastCol , lastRow ;
	     
	     Calculator()
	     {
	         col = row = 0;
	        
	         //ChooseOperation();
	     }
	     
	     private  void getDimension() 
	     {
	    	System.out.println("Please enter diemensions for your matrix");
	    	System.out.println("Rows:");
	    	
	    	Scanner input1= new Scanner(System.in);
	    	row= input1.nextInt();
	    	
	    	System.out.println("Columns:");
	    	
	    	Scanner input2= new Scanner(System.in);
	    	col= input2.nextInt();

	        
	        if(col<1||row<1) {
	        	System.out.println("Sorry, you entered wrong diemensions :(");
	        	System.out.println("please try again...");
	        	newMatrix();
	        }
	        
	        
	     }
	     
	     private void setElements() 
	     {
	    	 System.out.println("Please fill your matrix");
	    	 for(int i=0;i<row;i++) {
	    		 for(int j=0; j<col;j++) {
	    			 myMatrix = new int [row][col];
	    			 Random rand=new Random();
	    			 myMatrix [i][j]=rand.nextInt(10);
	    			 System.out.print("\t"+myMatrix[i][j]);
	    		 }
	    		 System.out.println("\n");
	    	 }
	     }
		

	     private  void newMatrix ()
	     {        
	         getDimension();
	         setElements();
	     }
	     private  void multiplication(Calculator B) {
	    	 System.out.println(this.row);
	    	 System.out.println(this.col);
	    	 System.out.println(B.row);
	    	 System.out.println(B.col);
	    	 
	    	 if(col==B.row) {
	    		 int tempMatrix[][]=new int[row][B.col];
	    		 for(int i=0;i<row;i++) {
	    			 for(int j=0;j<B.col;j++) {
	    				 for(int k=0;k<col;k++) {
	    					 tempMatrix[i][j] = tempMatrix[i][j] + myMatrix[i][k] * B.myMatrix[k][j];
	    				 }
	    			 }
	    		 }
		    	 for(int i=0;i<row;i++) {
		    		 for(int j=0; j<B.col;j++) {
		    			 System.out.print("\t"+tempMatrix[i][j]);
		    		 } 
		    		 System.out.println("\n");
	    	 }
	    	 }
	    	 else {
	    		 System.out.println("Error: your matrix multiplication is impossible ...");
	    	 }
	     }
	     
	public static void main(String[] args) {
		System.out.println("Please type for your first matrix");
		 Calculator m1 = new Calculator ();
		 m1.newMatrix();
			System.out.println("Please type for your second matrix");
			 Calculator m2 = new Calculator ();
			 m2.newMatrix();
			 System.out.println("\n");
			 System.out.println("You can perform following functions: ");
			 System.out.println("\n");
			 System.out.println("Sum  , Subtraction  , Multiplication  , ");
			m1. multiplication(m2);
	}

}
