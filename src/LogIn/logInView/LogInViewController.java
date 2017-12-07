
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
import Database.User;
import Database.Connection;
import Database.Music;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class LogInViewController  {
    
    @FXML
    private Label status;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    private Button login;
    
    List<User> userList = new ArrayList<User>();
    
    
    public void logIn() throws IOException {
        
        init();
        for(int i=0;i<userList.size();i++){
            
            if(user.getText().equals(userList.get(i).getUsername())&&pass.getText().equals(userList.get(i).getPassword()))
            {
                Main main = new Main();
                Stage mainStage = LogIn.LogIn.getLogInStage();            
                main.start(mainStage);
            }
        }                  
    }
    
    public void keyPress(KeyEvent keypress) throws IOException
    {
        if(keypress.getCode().equals(KeyCode.ENTER))
        {
            logIn();
        }
    }
    
    public void init(){
        EntityManager em = Connection.emf.createEntityManager();
        try {
            TypedQuery<User> q = em.createQuery("SELECT FROM User", User.class);
            int i=0;
            for (User user : q.getResultList()) {
                userList.add(user);
            }
        } finally {
            em.close();
        }
    }
    
}
