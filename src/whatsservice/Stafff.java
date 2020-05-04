package whatsservice;

import java.io.Serializable;
import java.util.function.Consumer;

public class Stafff extends TCPConnection {

    private String ip;
    private int port;

    public Stafff(String ip, int port, Consumer<Serializable> onReceiveCallback) {
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

