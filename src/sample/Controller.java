package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField pass_field;

    @FXML
    private Button auth_button;

    @FXML
    private Button login;

    @FXML
    void initialize() {
        auth_button.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String loginPassword = pass_field.getText().trim();
            if(!loginText.equals("") && !loginPassword.equals("")) {
                loginUser(loginText, loginPassword);
            }
            else {
                System.out.println("Login and password is empty");
            }
        });
        login.setOnAction(event -> {
            OpenNew("/sample/signup.fxml");
        });

    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User u = new User();
        u.setUserName(loginText);
        u.setPassword(loginPassword);
        dbHandler.getUser(u);
        ResultSet result = dbHandler.getUser(u);

        int count = 0;
        while(true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            count++;

        }
        if(count >= 1) {
            OpenNew("/sample/homepage.fxml");



        }
    }
    public void OpenNew(String window) {
        login.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();


    }
}


