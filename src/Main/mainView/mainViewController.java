package Main.mainView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import slidingbar.SlidingBar;
/**
 *
 * @author Louis Neen Oak Kaw
 */
public class mainViewController implements Initializable{
    ObservableList<String> songList = FXCollections.observableArrayList("Rabbit","ThatWhatILike");
    
    @FXML
    private ComboBox songListBox;
    
 
    @FXML
    public void play()
    {
        SlidingBar songPlayer = new SlidingBar();
        Stage stage = Main.Main.getPrimaryStage();
        String song = (String) songListBox.getValue();
        if(!song.equals(null))
        {
           songPlayer.play(stage,song); 
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songListBox.setItems(songList);
    }
}
