package cleanbutton;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


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
    private TextField name;

    @FXML
    private TextField work;

    @FXML
    private TextField salary;

    @FXML
    private ComboBox<String> city;

    @FXML
    private Button AddButton;

    @FXML
    void initialize() {
        city.setOnAction(event -> {
            city = new ComboBox<>();
            city.getItems().addAll(
                    "Almaty",
                    "Nur-Sultan",
                    "Pavlodar"


            );
            

        });


    }



}
