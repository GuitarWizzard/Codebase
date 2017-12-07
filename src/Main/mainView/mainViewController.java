package Main.mainView;

import Database.Connection;
import Database.Music;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import slidingbar.SlidingBar;
/**
 *
 * @author Louis Neen Oak Kaw
 */
public class mainViewController implements Initializable{
    ObservableList<String> songList;
    List<String> songListDB = new ArrayList<String>();
    
    @FXML
    private ComboBox songListBox;
    
 
    @FXML
    public void play()
    {
        SlidingBar songPlayer = new SlidingBar();
        Stage stage = Main.Main.getPrimaryStage();
        String song = (String) songListBox.getValue();
        if(song!=null)
        {
           songPlayer.play(stage,song); 
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EntityManager em = Connection.emf.createEntityManager();
        try {
            TypedQuery<Music> q = em.createQuery("SELECT FROM Music", Music.class);
            for (Music music : q.getResultList()) {
                songListDB.add(music.getName());
            }
        } finally {
            em.close();
        }   
        songList=FXCollections.observableArrayList(songListDB);
        
        songListBox.setItems(songList);
    }
}
