package Hauptmenue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\micas\\Documents\\Cours\\Java\\IntelliJS3\\Project-undercover-2020\\src\\main\\resources\\Hauptmenue\\hauptmenue.fxml"));
        stage.setScene(new Scene(root, 460, 180));
        stage.setTitle("Undercover Project");
        stage.show();
    }
}
