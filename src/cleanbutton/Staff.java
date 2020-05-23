package cleanbutton;

public class Staff {
    private String name;
    private String work;
    private int salary;

    public Staff(String name, String work, int salary, String city) {
        this.name = name;
        this.work = work;
        this.salary = salary;
    }

    public Staff(String name, String work, String salary) {
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

}
