import java.util.Random;
import java.util.Scanner;


public class Calculator {
	
		private  int col, row;
		private  double myMatrix [][];
	
	    
	     //constructor of calculator class
	     Calculator()
	     {
	         col = row = 0;
	        
	         //ChooseOperation();
	     }
	     /*following function get dimension for matrix from user*/
	     
	     private  void getDimension() 
	     {
	    	System.out.println("Please enter diemensions for your matrix");
	    	System.out.println("Rows:");
	    	
	    	Scanner input1= new Scanner(System.in); // diemension request for  matrix row
	    	row= input1.nextInt();
	    	
	    	System.out.println("Columns:");
	    	
	    	Scanner input2= new Scanner(System.in);  // diemension request for  matrix column
	    	col= input2.nextInt();

	        
	        if(col<1||row<1) {
	        	System.out.println("Sorry, you entered wrong diemensions :("); // conditions for matrix diemensions
	        	System.out.println("please try again...");
	        	newMatrix();    // function call for retype diemension choice for user .
	        }
	        
	        
	     }
	     /* following function fill out matrix with some random numbers according to user desired diemensions*/
	     
	     private void setElements() 
	     {
	    	 System.out.println("Your matrix");
	    	 myMatrix = new double [row][col];  // matrix initialization
	    	 for(int i=0;i<row;i++) {
	    		 for(int j=0; j<col;j++) {
	    			
	    			 Random rand=new Random();    //random number generator
	    			 myMatrix [i][j]=rand.nextInt(10);
	    			 System.out.print("\t"+myMatrix[i][j]); // show matrix on console
	    		 }
	    		 System.out.println("\n");
	    	 }
	     }
		
	     /*following function callled getDimension function and setElement function*/
	     private  void newMatrix ()
	     {        
	         getDimension();
	         setElements();
	     }
	     // following function multiply one matrix with other matrix
	     
	    public double[][] multiplication(Calculator B) {
	    	 double tempMatrix[][] = new double[row][B.col]; //temporary matrix generate for output
	    	 int sum=0;
	    	 
	    	 if(col==B.row) {   // condition for multiplication rule . if possible or not
	    		
	    		 for(int i=0;i<row;i++) {
	    			 for(int j=0;j<B.col;j++) {
	    				 for(int k=0;k<col;k++) {
	    					
	    				sum+=myMatrix[i][k] * B.myMatrix[k][j]; // matrix multiplication
	    				
	    			
	    					
	    				 }
	    				 tempMatrix[i][j] = sum;
	    				 sum=0;
	    				 
	    			 }
	    		 }
	    		 viewMatrix(tempMatrix);  //function call for resultant matrix display
	    		
	    	 }
	    	 else {
	    		 System.out.println("Error: your matrix multiplication is impossible ... We are sorry diemension are not suitable for multiplication");
	    		
	    	 }
	    	 return tempMatrix;
	     }
	    // following function sum two matrix
	     public double[][] matrixSum(Calculator B){
	 		double temp[][];
	 		temp = new double[row][col];
	 		if (row != B.row || col != B.col) {  // condition for matrix addition 
	 			System.out.println("ERROR: Order in not eqaul of both matrices");
	 			for(int i = 0; i < row; i++) {
	 				for(int j = 0; j < col; j++) {
	 					temp[i][j] = 0;
	 				}
	 			}
	 		}
	 		else {
	 			for(int i = 0; i < row; i++) {
	 				for(int j = 0; j < col; j++) {
	 					temp[i][j] = myMatrix[i][j] + B.myMatrix[i][j];  //addition methodology
	 				}
	 			}
	 		}
	 		viewMatrix(temp);  // function call for display of resultant matrix
	 		return temp;
	 	}
	     // following function perform subtraction of two matrix
	     public double[][] matrixDiff(Calculator B){
	 		double temp[][];
	 		temp = new double[row][col];
	 		if (row != B.row || col != B.col) { // condition for matrix subtraction
	 			System.out.println("ERROR: Order in not eqaul of both matrices");
	 			for(int i = 0; i < row; i++) {
	 				for(int j = 0; j < col; j++) {
	 					temp[i][j] = 0;
	 				}
	 			}
	 		}
	 		else {
	 			for(int i = 0; i < row; i++) {
	 				for(int j = 0; j < col; j++) {
	 					temp[i][j] = myMatrix[i][j] - B.myMatrix[i][j];   //subtraction methodology
	 				}
	 			}
	 		}
	 		viewMatrix(temp); //function call for resultant matrix display
	 		return temp;
	 	}
	     // following function perform scalar multiplication of a matrix
	 	
	 	public double[][] matrixScalerMul(int num){
	 		double temp[][];
	 		temp = new double[row][col];
	 		for(int i = 0; i < row; i++) {
	 			for(int j = 0; j < col; j++) {
	 				temp[i][j] = 0;
	 			}
	 		}
	 		for(int i = 0; i < row; i++) {
	 			for(int j = 0; j < col; j++) {
	 				temp[i][j] = myMatrix[i][j] * num;
	 			}
	 		}
	 		viewMatrix(temp); //function caal for displaye of resultant matrix
	 		return temp;
	 	}
	 						// transpose of a matrix
	 	public double[][] matrixTranspose(){
	 		double temp[][];
	 		temp = new double[row][col];
	 		if (row != col) {
	 			System.out.println("ERROR: Matrix must be a square matrix");
	 			for(int i = 0; i < row; i++)
	 				for(int j = 0; j < col; j++)
	 					temp[i][j] = 0;
	 		}
	 		else {
	 			for(int i = 0; i < row; i++) {
	 				for(int j = 0; j < col; j++) {
	 					temp[i][j] = myMatrix[j][i];
	 				}
	 			}
	 		}
	 		viewMatrix(temp);
	 		return temp;
	 	}

	 	// inverse of matrix can be find out through this function 
	 	private  double[][] matrixInverse() {
	 		double temp[][];
	 		temp = new double[row][col];
	 		for(int i = 0; i < row; i++)
	 			for(int j = 0; j < col; j++)
	 				temp[i][j] = myMatrix[i][j];
	 		if(col != row) {
	 			System.out.println("ERROR: Matrix must be a square matrix");
	 			for(int i = 0; i < row; i++)
	 				for(int j = 0; j < col; j++)
	 					temp[i][j] = 0;
	 		}
	 		else {
	 			double[][] invertMatrix = invert(temp);
	 			System.out.println("The inverse is: ");
	 			
	 			for (int i=0; i<row; ++i) {
	 				for (int j=0; j<row; ++j) {
	 					System.out.print(invertMatrix[i][j] + "\t\t");
	 				}
	 				System.out.println();
	 			}    
	 		}
	 		return temp;
	 	}


	 	public static double[][] invert(double a[][]) { // for inverse of matrix
	 		int n = a.length;
	 		double x[][] = new double[n][n];
	 		double b[][] = new double[n][n];
	 		int index[] = new int[n];
	 		for (int i=0; i<n; ++i) 
	 		b[i][i] = 1; // Transform the matrix into an upper triangle
	 		gaussian(a, index); // Update the matrix b[i][j] with the ratios stored.... function call
	 		for (int i=0; i<n-1; ++i)
	 			for (int j=i+1; j<n; ++j)
	 				for (int k=0; k<n; ++k)
	 					b[index[j]][k] -= a[index[j]][i]*b[index[i]][k]; // Perform backward substitutions
	 		for (int i=0; i<n; ++i) {
	 			x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
	 			for (int j=n-2; j>=0; --j) {
	 				x[j][i] = b[index[j]][i];
	 				for (int k=j+1; k<n; ++k) {
	 					x[j][i] -= a[index[j]][k]*x[k][i];
	 				}
	 				x[j][i] /= a[index[j]][j];
	 			}
	 		}
	 		return x;
	 	}
		// Method to carry out the partial-pivoting Gaussian
		// elimination.  Here index[] stores pivoting order.    
		public static void gaussian(double a[][], int index[]) {
			int n = index.length;
			double c[] = new double[n]; // Initialize the index
			for (int i=0; i<n; ++i) 
			index[i] = i; // Find the rescaling factors, one from each row
			for (int i=0; i<n; ++i) {
				double c1 = 0;
				for (int j=0; j<n; ++j) {
					double c0 = Math.abs(a[i][j]);
					if (c0 > c1) c1 = c0;
				}
				c[i] = c1;
			} 
			// Search the pivoting element from each column
			int k = 0;
			for (int j=0; j<n-1; ++j) {
				double pi1 = 0;
				for (int i=j; i<n; ++i) {
					double pi0 = Math.abs(a[index[i]][j]);
					pi0 /= c[index[i]];
					if (pi0 > pi1) {
						pi1 = pi0;
						k = i;
					}
				}   // Interchange rows according to the pivoting order
				int itmp = index[j];
				index[j] = index[k];
				index[k] = itmp;
				for (int i=j+1; i<n; ++i) {
					double pj = a[index[i]][j]/a[index[j]][j]; // Record pivoting ratios below the diagonal
					a[index[i]][j] = pj; // Modify other elements accordingly
					for (int l=j+1; l<n; ++l)
					a[index[i]][l] -= pj*a[index[j]][l];
				}
			}
		}

	 	/*
	 	 * print any 2D array in matrix form
	 	 * @param b is the 2D array that is to be displayed
	 	 */
	 	public void viewMatrix(double b[][]) {
	 		System.out.println("Showing Matrix: ");
	 		for(int i = 0; i < row; i++) {
	 			for(int j = 0; j < col; j++) {
	 				System.out.print("\t" + b[i][j]);   // function to display matrix
	 			}
	 			System.out.println();
	 		}
	 	}
	 	

 
	     // main method start from here.....
	public static void main(String[] args) {
			System.out.println("Please type for your first matrix");
			
			System.out.println("First matrix name=");
			Scanner x1=new Scanner(System.in);   // user input for matrix name
			String firstMatrix=x1.nextLine();
			
			 Calculator m1 = new Calculator ();  // calculator class object created...  . first matrix
			 m1.newMatrix();
		 
			System.out.println("Please type for your second matrix");
			
			System.out.println("Second matrix name=");
			Scanner x2=new Scanner(System.in);  //user input for matrix name
			String secondMatrix=x2.nextLine(); 
			
			 Calculator m2 = new Calculator ();  // calculator class object created...  . second matrix
			 m2.newMatrix();
			 
			 System.out.println("\n");
			 int choice=0;
			 while(choice!=-1) {
			 System.out.println("You can perform following functions: ");  // calculator menu ....
			 
			 System.out.println("sum(a + b) , difference(a - b) , multiply(a * b) , transpose(a ^ t) , inverse(a ^ -1) , scalar multiplication(a mul 3) ");
			 
			 System.out.println("press -1 to exit");
			 System.out.println("\n");
			 Scanner eq=new Scanner(System.in);
			 System.out.println("please enter your equation with spaces e.g a + b..\n Enter eq:");
			 
			 String equation =eq.nextLine(); // user input for equation
			 String result[]=equation.split(" ");
			 
			 
				 
			 if(result[0].equals("-1")) {
				 break;                               // to exit from menu loop
			 }
	 
			 if(result[0].equals(firstMatrix)) {
				                                                        // conditions for equation
				 	if(result[2].equals(secondMatrix)) {
				 		
				 			if(result[1].equals("+")) {
				 				
				 				m1.matrixSum(m2);        //  function call
				 			}
				 			else if(result[1].equals("-")) {
				 				
				 				m1.matrixDiff(m2);       //  function call
				 			}
				 			else if(result[1].equals("*")) {
				 				
				 				m1.multiplication(m2);   //  function call
				 			}
				 			
				 	}
				 	else if(result[2].equals(firstMatrix)) {
					 		
					 		if(result[1].equals("+")) {
					 			
				 				m1.matrixSum(m1);        //  function call
				 			}
				 			else if(result[1].equals("-")) {
				 				
				 				m1.matrixDiff(m1); //  function call
				 			}
				 			else if(result[1].equals("*")) {
				 				
				 				m1.multiplication(m1);  //  function call
				 			}
				 	}
			 		else if(result[2].equals("-1")) {
			 				m1.matrixInverse();  //  function call
			 		}
			 		else if(result[2].equals("t")) {
			 			m1.matrixTranspose();  //  function call
				 	}
					else if(result[1].equals("mul")){
						int i=Integer.parseInt(result[2]);
						m1.matrixScalerMul(i);  //  function call
					}
					else {
				 		System.out.println("Variable "+result[2]+" not exist.");
			 }

			 }else if(result[0].equals(secondMatrix)) {
				 	if(result[2].equals(firstMatrix)) {
				 		
					 		if(result[1].equals("+")) {  //  function call
				 				m2.matrixSum(m1);
				 			}
				 			else if(result[1].equals("-")) {
				 				m2.matrixDiff(m1);  //  function call
				 			}
				 			else if(result[1].equals("*")) {
				 				m2.multiplication(m1);  //  function call
				 			}
			 			
				 		
				 	}
				 	else if(result[2].equals(secondMatrix)) {
						 		if(result[1].equals("+")) {  //  function call
					 				m2.matrixSum(m2);
					 			}
					 			else if(result[1].equals("-")) {
					 				m2.matrixDiff(m2);
					 			}  //  function call
					 			else if(result[1].equals("*")) {
					 				m2.multiplication(m2);  //  function call
					 			}
				 	}
					 else if(result[2].equals("-1")) {
					 	m2.matrixInverse();	//  function call
					 }
					else if(result[2].equals("t")) {
					 	m2.matrixTranspose();		//  function call
				 	}
					else if(result[1].equals("mul")){
						int i=Integer.parseInt(result[2]);
						m2.matrixScalerMul(i);   	//  function call
					}
					else {
				 		System.out.println("Variable "+result[2]+" not exist.");
				 	}
			 }else {
				 System.out.println("Variable "+result[0]+" not exist.");
			 		}
			}
			System.out.println("Good bye");    //end of calculator
	 }    
}
