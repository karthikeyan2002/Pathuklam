import java.rmi.*; 
//remote file for factorial service 
import java.rmi.server.*; 
public class Factorialremote extends UnicastRemoteObject implements Factorial{ 
	Factorialremote()throws RemoteException{ 
		super(); 
	} 
	public int[] Factorial(int x){ 
		int array[] = new int[1000]; 
		int i,fact=1; 
		int number=x;//to calculate factorial 
		for(i=1;i<=number;i++){ 
			fact=fact*i; 
		} 
		array[0] = fact; 
		return (array); //Returning to the function calls 
		} 
}