package gameclient;

import connection.Connection;
import connection.FactoryConnection;
import game.Forca;
import java.util.Scanner;

public class GameClient {

    /**
     * @param args the command line arguments
     */
    static String recivedMessage;
    static Connection con;
    static String typeCon;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try {
            
            do{
                System.out.print("Digite o tipo de Conexão(\'RMI\'|\'socket\'): ");
                typeCon = input.nextLine();
            }while(!(typeCon.equals("socket") || typeCon.equals("RMI")));
            
            
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.out.println("Erro ao tentar conexão com servidor!");
        }
        
        try {
        	
        	 String typePlayer;
        	 String idServer;
        	 int idServerInt;
             do{
            	 System.out.print("Digite o tipo de Jogador :\n");
                 System.out.print("(Mestre da sala Digite 1)\n");
                 System.out.print("(Jogador comum Digite 2)\n");
                 typePlayer = input.nextLine();
             }while(!(typePlayer.equals("1") || typePlayer.equals("2")));
        	
             if(typePlayer.equals("1")) {
            	 //complicado
             } else {
            	 System.out.print("Digite o id do Server: ");
            	 idServer = input.nextLine();
            	 idServerInt = Integer.parseInt(idServer);
            	 con = FactoryConnection.getInstace(typeCon, idServerInt);
             }
             
            Forca game = new Forca(con);
            game.start();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
}
