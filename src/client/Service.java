package client;

public class Service {
    private int idservice;
    private String name;
    private String lastname;
    private String address;

    public Service(int idservice, String name, String lastname, String address) {
        this.idservice = idservice;
        this.name = name;
        this.lastname = lastname;
        this.address = address;

    }

    public int getIdservice() {
        return idservice;
    }

    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
