package slidingbar;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import static slidingbar.SlidingBar.gap;
import static slidingbar.SlidingBar.widthBar;

public class Bar {
    private String Chord;
    public double movement = 0;
    public double defaultMovement = 0;
    private int count = 0;
    public ImageView img;

    public Bar(double width,double height,String path,double x,double y,double movement){
        img = new ImageView(new Image(path));
        img.setFitHeight(height);
        img.setFitWidth(width);
        img.setY(y);
        img.setX(x);
        this.movement = movement;
        defaultMovement = movement; 
    }
    
    public void increaseSpeed(){
        movement += defaultMovement * 0.25;
    }
    
    public void decreaseSpeed(){
        movement -= defaultMovement * 0.25;
    }
    
    public void slide(){
        img.setX(img.getX()-movement );
    }
}
