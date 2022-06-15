import java.rmi.*; 
//Main interface file 
public interface Factorial extends Remote{ 
	public int[] Factorial(int x)throws RemoteException; 
}