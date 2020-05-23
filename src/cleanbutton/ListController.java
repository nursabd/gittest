package cleanbutton;


import java.sql.*;


public class ListController extends  Configs{
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + '/' + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void Liststaff(Staff staff) {

        String insert = "INSERT INTO " + cleanbutton.Const.ADDSERVICE_TABLE + " ( " +  cleanbutton.Const.ADDSERVICE_NAME + ","
                + cleanbutton.Const.ADDSERVICE_WORK + "," + cleanbutton.Const.ADDSERVICE_SALARY + " ) " + "VALUES(?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, staff.getName());
            prSt.setString(2, staff.getWork());
            prSt.setInt  ( 3, staff.getSalary());


            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getStaff(Staff staff) {
        ResultSet res = null;
        String select = "SELECT * FROM " + Const.ADDSERVICE_TABLE + " WHERE " + Const.ADDSERVICE_NAME + "=? AND "  + Const.ADDSERVICE_WORK + "=? AND " + Const.ADDSERVICE_SALARY + "=? ";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, staff.getName());
            prSt.setString(2, staff.getWork());
            prSt.setString(3, String.valueOf(staff.getSalary()));


            res = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();


        }
        return res;
    }
}