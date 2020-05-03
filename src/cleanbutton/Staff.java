package cleanbutton;

public class Staff {
    private String name;
    private String work;
    private int salary;
    private String city;

    public Staff(String name, String work, int salary, String city) {
        this.name = name;
        this.work = work;
        this.salary = salary;
        this.city = city;
    }

    public Staff() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
