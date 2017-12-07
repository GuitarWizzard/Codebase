package slidingbar;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Arrow {
    
    private static List<Image> imgList;
    
    private int state;
    private int count = 0;
    public ImageView img;

    public Arrow(double width,double height,int imgIndex,double x,double y){
        img = new ImageView(imgList.get(imgIndex));
        state = imgIndex;
        img.setFitHeight(height);
        img.setFitWidth(width);
        img.setY(y);
        img.setX(x);
    }
    
    public void changeImage(){
        if(state==1)
            state--;
        else
            state++;
        img.setImage(imgList.get(state));
    }
    
    private static void addImg(String path) {
        imgList.add(new Image(path));
    }
    
    public static void initialize() {
        imgList = new ArrayList<>();
        addImg("/slidingbar/green_arrow.png");
        addImg("/slidingbar/red_arrow.png");

    }
}
