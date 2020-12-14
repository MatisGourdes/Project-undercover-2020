package presentation;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;

class MainTest extends TestCase {


    @Test
    public void Teststart() throws Exception {
        Stage stage = new Stage();
        final Parent root = FXMLLoader.load(getClass().getResource("hauptmenue.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("Undercover Project");
        stage.show();
        stage.getScene().getStylesheets().add(getClass().getResource("theme.css").toExternalForm());

        Assert.assertEquals( "Undercover Project", stage.getTitle());


        assertNotEquals(root.getScaleX(), 500);
                }
    @Test
    void main() {
    }
}