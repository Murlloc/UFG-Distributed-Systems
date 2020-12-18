package connection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIImObjeto extends UnicastRemoteObject implements RIMensagem{
    
    public RMIImObjeto() throws RemoteException{
        super();
    }
    public String mensagem(String m) throws RemoteException{
//        System.out.println("Mensagem Cliente: "+ m);
        return m;
    }
}
