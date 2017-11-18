package slidingbar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Guide {
    String name;
    ImageView img;
    public Guide(String name){
        img = new ImageView(new Image("file:chordImage/"+name.charAt(0)+"/"+name+".png"));
        
    }
    
    public void setImage(String name){
        System.out.println("file:chordImage/"+name.charAt(0)+"/"+name+".png");
        img.setImage(new Image("file:chordImage/"+name.charAt(0)+"/"+name+".png"));
        
    }
}
