package myhealth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import myhealth.util.DatabaseManager;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("MyHealth");
        Label message = new Label("JavaFX is working.");

        VBox root = new VBox(10);
        root.getChildren().addAll(title, message);

        Scene scene = new Scene(root, 400, 250);

        stage.setTitle("MyHealth");
        stage.setScene(scene);
        stage.show();

        DatabaseManager.getInstance();
    }

    public static void main(String[] args) {
        launch(args);
    }
}