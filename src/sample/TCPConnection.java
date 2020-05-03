package sample;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

public class TCPConnection {

    private final Socket socket;
    private final Thread rxThread;
    private final TCPConnectionListener eventListener;
    private final BufferedReader in;
    private final BufferedWriter out;


    public TCPConnection(TCPConnectionListener eventListener, String ipAdd, int port) throws IOException{
        this(eventListener,new Socket(ipAdd,port));

    }

    public TCPConnection(TCPConnectionListener eventListener, Socket socket) throws IOException {
        this.eventListener=eventListener;
        this.socket = socket;
        this.in=new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
        this.out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),Charset.forName("UTF-8")));
        rxThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {                    eventListener.onDisconnect(TCPConnection.this);

                    eventListener.onConnectionReady(TCPConnection.this);
                    while (!rxThread.isInterrupted()){
                        eventListener.onReceiveString(TCPConnection.this,in.readLine());
                    }
                }catch (IOException e){
                    eventListener.onException(TCPConnection.this,e);
                }finally {
                }
            }
        });
        rxThread.start();
    }
    public synchronized void sendString(String value){
        try {
            out.write(value+"\r\n");
            out.flush();
        } catch (IOException e) {
            eventListener.onException(TCPConnection.this,e);
            disconnect();
        }
    }
    public synchronized void disconnect(){
        rxThread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            eventListener.onException(TCPConnection.this,e);
        }
    }

    @Override
    public String toString(){
        return "TCP Connection: "+socket.getInetAddress()+" : "+socket.getPort();
    }
}
