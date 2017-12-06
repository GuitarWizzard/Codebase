
package LogIn;

import Database.Connection;
import Main.AddSample;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class LogIn extends Application{
    private static Stage logInStage;
    private static Pane logInLayout;
    private static boolean logIn = false;
    
    Connection connect = new Connection();
       
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        connect.connect();
        
        //AddSample sample = new AddSample();
        //sample.start();
        
       this.logInStage = primaryStage;
       this.logInStage.setTitle("Guitar Wizard");
       showLogInView();
    }

    private void showLogInView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LogIn.class.getResource("logInView/logInView.fxml"));
        logInLayout = loader.load();
        Scene scene = new Scene(logInLayout);
        logInStage.setScene(scene);
        logInStage.show();
        
    }
    public static boolean getLogIn(String username){
        return logIn;
    }
    public static void setLogIn(String username){
        logIn = true;
    }
    public static Stage getLogInStage(){
        return logInStage;
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
