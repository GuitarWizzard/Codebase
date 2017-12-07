
package Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import slidingbar.Bar;
import slidingbar.Number;

/**
 *
 * @author Louis Neen Oak kaw
 */
public class Main extends Application {
    private static Stage primaryStage;
    private Pane mainLayout;
    
    
    public static Stage getPrimaryStage()
    {
        return primaryStage;
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Bar.initialize();
        Number.initialize();
        
       this.primaryStage = primaryStage;
       this.primaryStage.setTitle("Guitar Wizard");
       showMainView();
    }

    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("mainView/mainView.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
