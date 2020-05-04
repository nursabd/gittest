package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.User;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField pass_field;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField SignUpLoginSurname;

    @FXML
    private TextField SignUpLoginName;

    @FXML
    private TextField login_field21;

    @FXML
    private TextField SignUpCountry;

    @FXML
    private CheckBox SignUpBoxMale;

    @FXML
    private CheckBox SignUpBoxFemale;

    @FXML
    void initialize() {

        SignUpButton.setOnAction(event -> {
            UpnewUser();
            OpenNew("/sample/sample.fxml");




        });


    }

    private void UpnewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String firstName = SignUpLoginName.getText();
        String lastName = SignUpLoginSurname.getText();
        String userName = login_field21.getText();
        String password = pass_field.getText();
        String location = SignUpCountry.getText();
        String gender = "";
        if (SignUpBoxMale.isSelected())
            gender = "Male";
        else
            gender = "Female";
        User u = new User(firstName, lastName, userName, password, location, gender);
        dbHandler.signUpUser(u);





    }

    private void OpenNew(String s) {
        SignUpButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(s));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    private void Open(String s) {
        SignUpButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(s));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

}

