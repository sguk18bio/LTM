package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;


public class Server {
    public static Map<String, ThreadServer> listWait = new LinkedHashMap<>();
    public static Map<String, ThreadServer> listMatched = new LinkedHashMap<>();
    public static String duaVaoSau;
    
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(666);){
            Socket clienSocket ;
            while (true){
                System.out.println("Server đang chạy");
                clienSocket = serverSocket.accept();
                System.out.println("New client request received : " + clienSocket);
                ObjectOutputStream ous = new ObjectOutputStream(clienSocket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(clienSocket.getInputStream());
                ThreadServer newClient = new ThreadServer(clienSocket,ois,ous);
                Thread thread = new Thread(newClient);
                thread.start();
            }
        }
        catch (IOException e) {
        	e.printStackTrace();
        }

    }
}
