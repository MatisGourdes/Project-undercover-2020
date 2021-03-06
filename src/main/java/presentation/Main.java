package presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final Parent root = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("Undercover");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
