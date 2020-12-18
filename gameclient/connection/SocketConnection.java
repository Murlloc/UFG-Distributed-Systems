package connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketConnection implements Connection {

    DataInputStream in;
    DataOutputStream out;
    Socket aSocket = null;

    public SocketConnection(int port) throws Exception {
        this.aSocket = new Socket("localhost", port);
        this.in = new DataInputStream(aSocket.getInputStream());
        this.out = new DataOutputStream(aSocket.getOutputStream());
    }

    @Override
    public void sendMessage(String msg) throws IOException {
        this.out.writeUTF(msg);
    }

    @Override
    public String reciveMessage() throws IOException {
        return this.in.readUTF();
    }

    @Override
    public void closeConection() throws IOException {
        if (aSocket != null) {
            aSocket.close();
        }
    }

}
