package slidingbar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Alphabet {
    ImageView img;
    public double movement = 0;
    public double defaultMovement = 0;
    public Alphabet(String name,double width,double height,double x,double y,double movement){
        img = new ImageView(new Image("file:Alphabet/"+name.charAt(0)+"/"+name+".png"));
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
