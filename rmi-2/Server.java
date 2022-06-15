import java.rmi.*;  
import java.rmi.registry.*;  
public class Server{  
    public static void main(String args[]){  
        try{  
            System.setProperty("java.rmi.server.hostname", "172.17.17.177");  
            Registry reg = LocateRegistry.createRegistry(5000);
            Adder stub=new AdderRemote();  
            reg.rebind("Stub", stub);  
        }catch(Exception e){System.out.println(e);}  
    }  
}