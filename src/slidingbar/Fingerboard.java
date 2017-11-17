package slidingbar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fingerboard {
    ImageView img;
    public Fingerboard(){
        img = new ImageView(new Image("/slidingbar/fingerboard.jpg"));
        img.setFitHeight(200);
        img.setFitWidth(700);
        img.setY(700-img.getFitHeight()-10);
        img.setX(0);
    }
}
