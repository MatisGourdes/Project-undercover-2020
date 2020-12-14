package presentation;



import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import junit.framework.TestCase;

import org.junit.Assert;


import org.junit.jupiter.api.Test;




import java.util.Collections;


import static org.mockito.internal.invocation.finder.VerifiableInvocationsFinder.find;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

class MrWhiteControllerTest extends TestCase {




    TextField Input;
    boolean Win= false;



    @Test
    public void validTest() throws Exception {
        Input.setText("ok");


        Win= !Input.getText().equalsIgnoreCase(addSpielerController.getWortCitizen());
        assertTrue(Win);
        Assert.assertEquals("ok", Input.getText());
    }
    @Test
    public void Testbutton()throws Exception{

        final Button btnMain = (Button) find(Collections.singletonList("#exitg"));
        Assert.assertNotNull(btnMain);
        verifyThat(btnMain, hasText("Exit Game"));


    }

}


