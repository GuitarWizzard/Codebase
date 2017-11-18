package Main.mainView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import slidingbar.SlidingBar;
import slidingbar.Fingerboard;
/**
 *
 * @author Louis Neen Oak Kaw
 */
public class mainViewController {
    ObservableList<String> songList = FXCollections.observableArrayList("Bigass","ThatWhatILike");
    
    @FXML
    private ComboBox songListBox;
    
    private void initialize() {
        songListBox.setValue("Bigass");
        songListBox.setItems(songList);
    }
    @FXML
    public void test()
    {
        SlidingBar test = new SlidingBar();
        Stage stage = Main.Main.getPrimaryStage();
        test.play(stage);
    }
}
