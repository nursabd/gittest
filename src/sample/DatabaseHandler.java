package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + '/' + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User u) {

        String insert = "INSERT INTO " + Const.USER_TABLE + " ( " + Const.USERS_FIRSTNAME + "," +
                Const.USERS_LASTNAME + "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + ","
                + Const.USERS_LOCATION + "," + Const.USERS_GENDER + " ) " + "VALUES(?,?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, u.getFirstName());
            prSt.setString(2, u.getLastName());
            prSt.setString(3, u.getUserName());
            prSt.setString(4, u.getPassword());
            prSt.setString(5, u.getLocation());
            prSt.setString(6, u.getGender());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User u) {
        ResultSet res = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + "=? AND "  + Const.USERS_PASSWORD + "=?";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, u.getUserName());
            prSt.setString(2, u.getPassword());


            res = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();


        }
        return res;
    }
}
