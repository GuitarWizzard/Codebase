package slidingbar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static slidingbar.SlidingBar.heightEdge;
import static slidingbar.SlidingBar.widthEdge;

public class PauseButton {
    ImageView img ;
    boolean count;
    boolean mute;
    public PauseButton() {
        img = new ImageView(new Image("/slidingbar/pause_button_1.png"));
        count = false;
        img.setFitHeight(100);
        img.setFitWidth(100);
        img.setY(heightEdge/2-20);
        img.setX((widthEdge/2)-50);
    }
    
    public void muteButton(){
        if(mute){
            img = new ImageView(new Image("/slidingbar/pause_button_1.png"));
        }else if(!mute){
            img = new ImageView(new Image("/slidingbar/pause_button_1_mute.png"));
        }
        img.setFitHeight(100);
        img.setFitWidth(100);
        img.setY(heightEdge/2);
        img.setX((widthEdge/2)-50);
        mute = !mute;
    }
}
