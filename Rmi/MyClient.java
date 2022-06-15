import java.rmi.*; 
//Client file that requests server 
import java.util.Scanner; 
public class MyClient{ 
	public static void main(String args[]){ 
		try{ 
			Scanner inp = new Scanner(System.in); 
			Factorial stub=(Factorial)Naming.lookup("rmi://172.17.17.128:5000/sonoo"); 
			System.out.println("Enter the number: "); 
			int x = inp.nextInt(); 
			System.out.println("Factorial of the number you entered is: "); 
			int arr[] = stub.Factorial(x); //Function for finding fact! 
			for(int i=0;arr[i]!=0;i++) { 
				System.out.println(arr[i]); //Displaying the value 
			} 
		}catch(Exception e){}
	} 
}