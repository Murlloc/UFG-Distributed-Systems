package connection;

public interface Connection {
            
    public void sendMessage(String msg) throws Exception;
    
    public String reciveMessage() throws Exception;
    
    public void closeConection() throws Exception;
    
}
