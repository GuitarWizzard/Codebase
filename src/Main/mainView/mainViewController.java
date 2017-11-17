package Main.mainView;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import slidingbar.SlidingBar;
import slidingbar.Fingerboard;
/**
 *
 * @author Louis Neen Oak Kaw
 */
public class mainViewController {
    
    @FXML
    public void test()
    {
        SlidingBar test = new SlidingBar();
        Stage stage = Main.Main.getPrimaryStage();
        test.play(stage);
    }
}
