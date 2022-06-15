import java.rmi.*;  
import java.rmi.server.*;  
public class AdderRemote extends UnicastRemoteObject implements Adder{  
    AdderRemote()throws RemoteException{  
        super();  
    }  
    public int add(int[] x){
        int sum=0;
        for(int i=0;i<x.length;i++){
            sum+=x[i];
        }
        return sum;
    }  
}  