package whatsservice;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ChatApp extends Application {

    private boolean isServer = false;

    private TextArea messages = new TextArea();
    private TCPConnection connection = isServer ? createServer() : createClient();

    private Parent createContent() {
        messages.setFont(Font.font(72));
        messages.setPrefHeight(550);
        TextField input = new TextField();
        input.setOnAction(event -> {
            String message = isServer ? "Server: " : "Staff: ";
            message += input.getText();
            input.clear();

            messages.appendText(message + "\n");

            try {
                connection.send(message);
            }
            catch (Exception e) {
                messages.appendText("Failed to send\n");
            }
        });

        VBox root = new VBox(20, messages, input);
        root.setPrefSize(500, 500);
        return root;
    }

    @Override
    public void init() throws Exception {
        connection.startConnection();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        connection.closeConnection();
    }

    private Server createServer() {
        return new Server(8080, data -> {
            Platform.runLater(() -> {
                messages.appendText(data.toString() + "\n");
            });
        });
    }

    private Stafff createClient() {
        return new Stafff("127.0.0.1", 8080, data -> {
            Platform.runLater(() -> {
                messages.appendText(data.toString() + "\n");
            });
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}