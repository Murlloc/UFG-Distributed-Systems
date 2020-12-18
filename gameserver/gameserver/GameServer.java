package gameserver;

import connection.Connection;
import connection.RMIConnection;
import connection.SocketConnection;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class GameServer {

    /**
     * @param args the command line arguments
     */
    private static Connection con;
    static Scanner input = null;
    static String typeCon, typePlayer;
    private static int port = 7696;
    
    public static void main(String[] args) {
        try {
            input = new Scanner(System.in);
            do {
                System.out.print("Digite o tipo de Conexão(\'RMI\'|\'socket\'): ");
                typeCon = input.nextLine();
            } while (!(typeCon.equals("socket") || typeCon.equals("RMI")));

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.out.println("Erro ao tentar conexão com servidor!");
        }

        try {
            if (typeCon.equals("socket")) {
                ServerSocket sSocket = null;
                sSocket = new ServerSocket(port);
                System.out.println("Aguardando Conexão...");
                while (true) {
                    Socket socket = sSocket.accept();
                    SocketConnection con = new SocketConnection();
                    con.setSocket(socket);
                }
                
                
            }else if(typeCon.equals("RMI")){
                new RMIConnection();
                System.out.println("Objeto Criado!\n");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
