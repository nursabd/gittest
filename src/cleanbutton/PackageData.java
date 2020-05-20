package cleanbutton;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private ArrayList<Staff> StaffList;
    private Staff staff;
    private String operationType;
    public PackageData(){

    }

    public ArrayList<Staff> getStaffList() {
        return StaffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        StaffList = staffList;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
