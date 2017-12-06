package slidingbar;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bar {
    
    private static List<Image> imgList;
    
    private String Chord;
    public double movement = 0;
    public double defaultMovement = 0;
    private int count = 0;
    public ImageView img;

    public Bar(double width,double height,int imgIndex,double x,double y,double movement){
        img = new ImageView(imgList.get(imgIndex));
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
    
    private static void addImg(String path) {
        imgList.add(new Image(path));
    }
    
    public static void initialize() {
        imgList = new ArrayList<>();
        addImg("/slidingbar/red_front.png");
        addImg("/slidingbar/red_mid.png");
        addImg("/slidingbar/red_end.png");
        
        addImg("/slidingbar/green_front.png");
        addImg("/slidingbar/green_mid.png");
        addImg("/slidingbar/green_end.png");
    }
}
