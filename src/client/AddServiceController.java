package client;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AddServiceController {
    private ObservableList<Service> servicesData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Service> tableServices;

    @FXML
    private TableColumn<Service, Integer> idservice;

    @FXML
    private TableColumn<Service, String> name;

    @FXML
    private TableColumn<Service, String> lastname;

    @FXML
    private TableColumn<Service, String> address;
    @FXML
    private Button CleanButton;

    @FXML
    private Button HistoryButton;

    @FXML
    private Button ContactButton;

    @FXML
    private Button OptionButton;

    @FXML
    void initialize() {
        initData();
        idservice.setCellValueFactory(new PropertyValueFactory<Service, Integer>("idservice"));
        name.setCellValueFactory(new PropertyValueFactory<Service, String>("name"));
        lastname.setCellValueFactory(new PropertyValueFactory<Service, String>("lastname"));
        address.setCellValueFactory(new PropertyValueFactory<Service, String>("address"));
        tableServices.setItems(servicesData);

        ContactButton.setOnAction(event -> {
            OpenContact("/sample/cleanservice.fxml");
        });
        OptionButton.setOnAction(event -> {
            OpenContact("/sample/homepage.fxml");
        });

    }

    private void initData() {
        servicesData.add(new Service(1, "#1 Клининг", "Уборка помещений", "ул. Шевченко 90, уг. ул. Наурызбай батыра\n" +
                "Номер телефона+7 727 327 62 87"));
        servicesData.add(new Service(2, "Мистер пропер", "Уборка помещений", "ул. Сатпаева, 15\n" +
                "Номер телефона+7 778 122 04 40"));
        servicesData.add(new Service(3, "Zolushka", "Профессиональные Услуги, Уборка помещений", "ул. Добролюбова, 47А\n" +
                "Номер телефона+7 727 354 11 72"));
        servicesData.add(new Service(4, "Kazcleaning", "\n" +
                "4. Kazcleaning\n" +
                "Уборка офисов, Уборка помещений, Химчистка", "п. Первомайский, пер. Зеленый, 34\n" +
                "Номер телефона+7 727 329 45 72"));
        servicesData.add(new Service(5, "TOP Kazakhstan", "Уборка офисов, Уборка помещений", "ул. Макатаева, 117 лит А, БЦ Лотос, 3 этаж, 314 офис\n" +
                "Номер телефона+7 777 837 00 00"));
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

