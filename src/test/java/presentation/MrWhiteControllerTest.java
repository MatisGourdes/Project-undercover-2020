package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import javafx.event.ActionEvent;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.internal.invocation.finder.VerifiableInvocationsFinder.find;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

class MrWhiteControllerTest extends TestCase {


    private ActionEvent event;

    TextField Input;
    boolean Win= false;

    protected void setter() throws Exception{

    }

    @Test
    public void validTest() throws Exception {
        Input.setText("ok");

        if (Input.getText().equalsIgnoreCase(addSpielerController.getWortCitizen())) {
            Parent spielParent = FXMLLoader.load(getClass().getResource("MrWhiteGewinnen.fxml"));

            Scene spielScene = new Scene(spielParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(spielScene);
            window.setTitle("WIN !!!");
            window.show();
            Win=false;
        }
        else {
            TestSpielFertig.finishTest(event);
            Win=true;
        }
        assertTrue(Win);
    }
    @Test
    public void Testbutton()throws Exception{

        final Button btnMain = (Button) find(Collections.singletonList("#exitg"));
        Assert.assertNotNull(btnMain);
        verifyThat(btnMain, hasText("Exit Game"));


    }

}


