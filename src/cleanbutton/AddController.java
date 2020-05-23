package cleanbutton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.User;


public class AddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ListButton;

    @FXML
    private Button HistoryButton;

    @FXML
    private Button ContactButton;

    @FXML
    private Button Back;

    @FXML
    private TextField name1;

    @FXML
    private TextField work1;

    @FXML
    private TextField salary1;

    @FXML
    private ComboBox<String> city;

    @FXML
    private Button AddButton;

    @FXML
    void initialize() {
        Back.setOnAction(event -> {
            OpenContact("/sample/homepage.fxml");
        });
        ContactButton.setOnAction(event -> {
            OpenContact("/sample/cleanservice.fxml");
        });
        ListButton.setOnAction(event -> {
            OpenContact("/client/AddService.fxml");
        });
        HistoryButton.setOnAction(event -> {
            OpenContact("/notes/notes.fxml");
        });
        AddButton.setOnAction(event -> {
            UpnewStaff();

        });



    }

    private void UpnewStaff() {
        ListController dbHandler = new ListController();
        String name = name1.getText();
        String work = work1.getText();
        String salary = salary1.getText();
        Staff staff = new Staff(name, work, salary);
        dbHandler.Liststaff(staff);
    }

    private void OpenContact(String p) {
        Back.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(p));
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
