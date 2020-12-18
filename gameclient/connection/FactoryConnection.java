package connection;

public class FactoryConnection {    

    public static Connection getInstace(String type, int port) throws Exception {
        if (type.equals("socket")) {
            return new SocketConnection(port);
        } else {
            return new RMIConnection();
        }
    }

}
