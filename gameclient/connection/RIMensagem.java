package connection;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RIMensagem extends Remote{
    public String mensagem(String m) throws RemoteException;
}
