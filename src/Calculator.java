import java.util.Random;
import java.util.Scanner;

import java.util.StringTokenizer;

public class Calculator {
	
		private  int col, row;
		private  double myMatrix [][];
	
	    
	     
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
	    	 myMatrix = new double [row][col];
	    	 for(int i=0;i<row;i++) {
	    		 for(int j=0; j<col;j++) {
	    			
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
	     
	    public double[][] multiplication(Calculator B) {
	    	 double tempMatrix[][] = new double[row][B.col];
	    	 int sum=0;
	    	 
	    	 if(col==B.row) {
	    		
	    		 for(int i=0;i<row;i++) {
	    			 for(int j=0;j<B.col;j++) {
	    				 for(int k=0;k<col;k++) {
	    					
	    				sum+=myMatrix[i][k] * B.myMatrix[k][j];
	    				
	    			
	    					
	    				 }
	    				 tempMatrix[i][j] = sum;
	    				 sum=0;
	    				 
	    			 }
	    		 }
	    		 viewMatrix(tempMatrix);
	    		
	    	 }
	    	 else {
	    		 System.out.println("Error: your matrix multiplication is impossible ...");
	    		
	    	 }
	    	 return tempMatrix;
	     }

	     public double[][] matrixSum(Calculator B){
	 		double temp[][];
	 		temp = new double[row][col];
	 		if (row != B.row || col != B.col) {
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
	 					temp[i][j] = myMatrix[i][j] + B.myMatrix[i][j];
	 				}
	 			}
	 		}
	 		viewMatrix(temp);
	 		return temp;
	 	}
	     public double[][] matrixDiff(Calculator B){
	 		double temp[][];
	 		temp = new double[row][col];
	 		if (row != B.row || col != B.col) {
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
	 					temp[i][j] = myMatrix[i][j] - B.myMatrix[i][j];
	 				}
	 			}
	 		}
	 		viewMatrix(temp);
	 		return temp;
	 	}
	 	
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
	 		viewMatrix(temp);
	 		return temp;
	 	}

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

	 	private  int[][] matrixMultiply(Calculator B) {
	 		int temp[][];
	 		temp = new int[row][col];
	 	   	int sum=0;
	 	   	 if(col == B.row) {
	 	   		 for(int i=0; i < row; i++) {
	 	   			 for(int j=0; j < B.col; j++) {
	 	   				 for(int k=0; k < col; k++) {
	 		   					 sum+=myMatrix[i][k] * B.myMatrix[k][j];
	 	   				 }
	 	   				 temp[i][j] = sum;
	 	   				 sum=0;
	 	   			 }
	 	   		 }
	 	    	 for(int i=0;i<row;i++) {
	 	    		 for(int j=0; j<B.col;j++) {
	 	    			 System.out.print("\t"+temp[i][j]);
	 	    		 } 
	 	    		 System.out.println("\n");
	 	    	 }
	 	   	 }
	 	   	 else
	 	   		 System.out.println("ERROR: Invalid order of matrices.");
	 		
	 	   	 return temp;
	     }
	 	
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


	 	public static double[][] invert(double a[][]) {
	 		int n = a.length;
	 		double x[][] = new double[n][n];
	 		double b[][] = new double[n][n];
	 		int index[] = new int[n];
	 		for (int i=0; i<n; ++i) 
	 		b[i][i] = 1; // Transform the matrix into an upper triangle
	 		gaussian(a, index); // Update the matrix b[i][j] with the ratios stored
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

	 	/**
	 	 * print any 2D array in matrix form
	 	 * @param b is the 2D array that is to be displayed
	 	 */
	 	public void viewMatrix(double b[][]) {
	 		System.out.println("Showing Matrix: ");
	 		for(int i = 0; i < row; i++) {
	 			for(int j = 0; j < col; j++) {
	 				System.out.print("\t" + b[i][j]);
	 			}
	 			System.out.println();
	 		}
	 	}
	 	


	     
	public static void main(String[] args) {
		System.out.println("Please type for your first matrix");
		System.out.println("First matrix name=");
		Scanner x1=new Scanner(System.in);
		
		String firstMatrix=x1.nextLine();
		
		 Calculator m1 = new Calculator ();
		 m1.newMatrix();
		 
			System.out.println("Please type for your second matrix");
			System.out.println("Second matrix name=");
			Scanner x2=new Scanner(System.in);
			
			String secondMatrix=x2.nextLine();
			 Calculator m2 = new Calculator ();
			 m2.newMatrix();
			 
			 System.out.println("\n");
			 System.out.println("You can perform following functions: ");
			 System.out.println("\n");
			 System.out.println("Sum  , Subtraction  , Multiplication  , ");
			 
			 
			 Scanner eq=new Scanner(System.in);
			 System.out.println("please enter your equation with spaces e.g A + B");
			 
			 String equation =eq.nextLine();
			 String result[]=equation.split(" ");

	 
			 if(result[0].equals(firstMatrix)) {
				 	if(result[2].equals(secondMatrix)) {
				 			if(result[1].equals("+")) {
				 				m1.matrixSum(m2);
				 			}
				 			else if(result[1].equals("-")) {
				 				m1.matrixDiff(m2);
				 			}
				 			else if(result[1].equals("*")) {
				 				m1.multiplication(m2);
				 			}
				 			
				 	}
				 	else if(result[2].equals(firstMatrix)) {
				 		if(result[1].equals("+")) {
			 				m1.matrixSum(m1);
			 			}
			 			else if(result[1].equals("-")) {
			 				m1.matrixDiff(m1);
			 			}
			 			else if(result[1].equals("*")) {
			 				m1.multiplication(m1);
			 			}
				 		
				 	}else {
				 		System.out.println("Variable "+result[2]+" not exist.");
			 }

			 }else if(result[0].equals(secondMatrix)) {
				 	if(result[2].equals(firstMatrix)) {
				 		if(result[1].equals("+")) {
			 				m2.matrixSum(m1);
			 			}
			 			else if(result[1].equals("-")) {
			 				m2.matrixDiff(m1);
			 			}
			 			else if(result[1].equals("*")) {
			 				m2.multiplication(m1);
			 			}
			 			
				 		
				 	}
				 	else if(result[2].equals(secondMatrix)) {
				 		if(result[1].equals("+")) {
			 				m2.matrixSum(m2);
			 			}
			 			else if(result[1].equals("-")) {
			 				m2.matrixDiff(m2);
			 			}
			 			else if(result[1].equals("*")) {
			 				m2.multiplication(m2);
			 			}
				 		
				 	}else {
				 		System.out.println("Variable "+result[2]+" not exist.");
				 	}
			 }else {
				 System.out.println("Variable "+result[0]+" not exist.");
			 }
	}
}
