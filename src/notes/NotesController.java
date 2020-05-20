package notes;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class NotesController {

    @FXML
    private DatePicker picker;

    @FXML
    private TextArea notes;

    @FXML
    private Button OptionButton;

    private Map<LocalDate, String> data = new HashMap<>();

    public void initialize() {
        load();

        picker.valueProperty().addListener((o, oldDate, date) -> {
            notes.setText(data.getOrDefault(date, ""));
        });

        picker.setValue(LocalDate.now());
        OptionButton.setOnAction(event -> {
            OpenContact("/sample/homepage.fxml");
        });
    }

    public void updateNotes() {
        data.put(picker.getValue(), notes.getText());
    }

    public void exit() {
        save();
        Platform.exit();
    }

    private void save() {
        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("notes.data")))) {
            stream.writeObject(data);
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println("Failed to save: " + e);
        }
    }

    private void load() {
        Path file = Paths.get("notes.data");

        if (Files.exists(file)) {
            try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(file))) {
                data = (Map<LocalDate, String>) stream.readObject();
                System.out.println("Loaded!");
            } catch (Exception e) {
                System.out.println("Failed to load: " + e);
            }
        }
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
