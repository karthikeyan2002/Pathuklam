import java.rmi.*; 
//Main server file that responds to client 
import java.rmi.registry.*; 
public class MyServer{ 
	public static void main(String args[]){ 
		try{ 
			Factorial stub=new Factorialremote(); 
			Naming.rebind("rmi://172.17.17.127:5000/sonoo",stub); 
		}catch(Exception e){System.out.println(e);} 
	System.out.println("Establishing connection..."); 
	} 
}