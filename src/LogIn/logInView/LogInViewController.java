
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
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class LogInViewController  {
    
    @FXML
    private Label status;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    
    List<User> userList = new ArrayList<User>();
    
    public void logIn() throws IOException {
        
        init();
        for(int i=0;i<userList.size();i++){
            if(user.getText().equals(userList.get(i).getUsername())&&pass.getText().equals(userList.get(i).getPassword()))
            {
                status.setText("Log in successed");
                Main main = new Main();
                Stage mainStage = LogIn.LogIn.getLogInStage();            
                main.start(mainStage);
            }
        }
        
            status.setText("Log in failed");
        
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
