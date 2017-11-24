
package LogIn.logInView;

import Main.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class LogInViewController  {
    
    @FXML
    private Label status;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    
    public void logIn() throws IOException {
        if(user.getText().equals("Louis")&&pass.getText().equals("1234"))
        {
            status.setText("Log in successed");
            Main main = new Main();
            Stage mainStage = LogIn.LogIn.getLogInStage();            
            main.start(mainStage);
        }
        else
        {
            status.setText("Log in failed");
        }
    }    
    
}
