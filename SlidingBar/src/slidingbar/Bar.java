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
    private int count = 0;
    public ImageView img;

    public Bar(double width,double height,String path,double x,double y,int count,double movement){
        img = new ImageView(new Image(path));
        img.setFitHeight(height);
        img.setFitWidth(width);
        img.setY(y);
        img.setX(x);
        this.count = count;
        this.movement = movement;
    }
    public void slide(){
        /*
        TranslateTransition goLeft = new TranslateTransition();
        goLeft.setDuration(Duration.millis(( (movement+(widthBar*count))/70 )*1000));
        goLeft.setNode(img);
        goLeft.setCycleCount(0);
        //goLeft.
        goLeft.setFromX(img.getTranslateX());
        goLeft.setToX(img.getTranslateX() - ( movement+(widthBar*count) ));
        goLeft.play();
        */
        img.setX(img.getX()-movement );
        
    }
}
