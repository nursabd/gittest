package serviceapp;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.Main;

public class HomeController {
    private Main main;


    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private Button CleanButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button HistoryButton;

    @FXML
    private Button ContactButton;

    @FXML
    private Button OptionButton;


    @FXML
    void initialize() {
        OptionButton.setOnAction(event -> {
            OpenContact("/sample/sample.fxml");


        });
        ContactButton.setOnAction(event -> {
            OpenContact("/sample/cleanservice.fxml");
        });
        AddButton.setOnAction(event -> {
            OpenContact("/client/AddService.fxml");
        });



    }

    private void OpenContact(String p) {
        OptionButton.getScene().getWindow().hide();
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

