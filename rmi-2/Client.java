import java.rmi.*;  
import java.rmi.registry.*;
public class Client{  
    public static void main(String args[]){  
        try{
            System.out.println("GOT");
            Registry reg = LocateRegistry.getRegistry("172.17.17.177", 5000);
            Adder stub = (Adder) reg.lookup("Stub");
            int arr[]={1,2,3};
            System.out.println(stub.add(arr));  
        }catch(Exception e){System.out.println( e);}  
    }  
}