package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server implements TCPConnectionListener {

    public static void main(String[] args) {
        new Server();
    }
    private final ArrayList<TCPConnection> connections=new ArrayList<>();

    public Server(){
        System.out.println("Server running...");
        try(ServerSocket serverSocket=new ServerSocket(7777)){
            while (true){
                try{
                    new TCPConnection(this, serverSocket.accept());
                }catch (IOException e){
                    System.out.println("TCPConnection exeception: "+e);
                }
            }
        }catch (IOException e){
            throw  new RuntimeException(e);
        }


    }

    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
        connections.add(tcpConnection);
        sendToAllConnections("Client connected: "+tcpConnection);
    }

    @Override
    public synchronized void onReceiveString(TCPConnection tcpConnection, String value) {
        sendToAllConnections(value);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllConnections("Client disconnected: "+tcpConnection);
    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection exception: "+e);
    }
    private void sendToAllConnections(String value){
        System.out.println(value);
        for (TCPConnection connection : connections) {
            connection.sendString(value);
        }
    }
}