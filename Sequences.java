import java.math.BigInteger;
import java.util.Scanner;
/*
 * @author Shreyan Das, Vishal Patel
 * @date 11/9/19
 */
public class Sequences {
	//counts the amount of digits in a BigInteger
	public static int getDigitCount(BigInteger number) {
		  double factor = Math.log(2) / Math.log(10);
		  int digitCount = (int) (factor * number.bitLength() + 1);
		  if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0) {
		    return digitCount - 1;
		  }
		  return digitCount;
		} 
	//creates a fibonacci sequence of BigIntegers using recursion
	static BigInteger fib(int n) 
	    { 
	        BigInteger a = BigInteger.valueOf(0); 
	        BigInteger b = BigInteger.valueOf(1); 
	        BigInteger c = BigInteger.valueOf(1); 
	        for (int j=1 ; j<=n ; j++) 
	        { 
	            c =  a.add(b); 
	            a = b; 
	            b = c; 
	        } 
	  
	        return (a); 
	    }
	//creates a squares sequence of BigIntegers using a simple statement
	public static BigInteger squares(int startCase) {
		return BigInteger.valueOf(startCase).pow(2);
	}
	//creates a triangular sequence of BigIntegers using recursion
	public static BigInteger triangular(int startCase) {
		if(startCase==0) {
			return BigInteger.valueOf(1);
		}else {
			return (BigInteger.valueOf(startCase).add(BigInteger.valueOf(1))).add(triangular(startCase-1));
		}
	}
	//main method
	public static void main(String[] args) {
		Scanner generator = new Scanner(System.in);
		System.out.println("Enter the term number that each sequence should stop at, with limits up to 235: ");
		int iUse = 0;
		if(generator.hasNextInt()) {
			iUse = generator.nextInt();
			
		}else {
			System.out.println("Invalid Exception return: Rerun program.");
			System.exit(0);
		}
		
		generator.nextLine();
		System.out.println("Scroll to the right to observe ratios of each number sequence:");
		System.out.println("Fibonacci\t\t\t\t\t\tSquares\t\t\t\t\t\tTriangular\t\t\t\t\t\tFibonacci to Square\t\t\t\t\t\tFibonacci to Triangular\t\t\t\t\t\t\tSquare to Triangular");
		for(int i = 0; i < iUse; i++) {
			double fibDouble = fib(i).doubleValue();
			double squareDouble = squares(i).doubleValue();
			double triangularDouble = triangular(i).doubleValue();
			
			if(i==0) {
				System.out.printf("%-50d%-50d%-50d\n",fib(i), squares(i), triangular(i));
			}else if(fibDouble==0 && squareDouble==0) {
				System.out.printf("%-50d%-50d%-50d%-50d%-50d%-50d", fib(i), squares(i), triangular(i), "null", "null", squareDouble/triangularDouble);
			}
			else {
			System.out.printf("%-50d%-50d%-50d%-75f%-75f%-75f\n",fib(i), squares(i), triangular(i), fibDouble/squareDouble, fibDouble/triangularDouble, squareDouble/triangularDouble );
		}
		}
		
			}
}
