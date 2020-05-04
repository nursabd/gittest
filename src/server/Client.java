package server;

import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends NetworkConnection {

    private String ip;
    private int port;

    public Client(String ip, int port, Consumer<Serializable> onReceiveCallback) {
        super(onReceiveCallback);
        this.ip = ip;
        this.port = port;
    }


    protected boolean isServer() {
        return false;
    }


    protected String getIP() {
        return ip;
    }


    protected int getPort() {
        return port;
    }
}

