package Chord;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AChord extends AllChord{
    
    public static List<Image> imgList;
    public static List<String> chordList;
 
    private int count = 0;
    public ImageView img;
    
    public AChord(int imgIndex){
        img = new ImageView(imgList.get(imgIndex));
        
    }
    
    public static void addImg(String path) {
        imgList.add(new Image(path));
        addString(path);
    }
    
    public static void addString(String path){
        //System.out.println();
        chordList.add(path.substring(18,path.length()-4));
    }
    
    public static int getChord(String chord){
        int index=0;
        for(int i=0;i<chordList.size();i++){
            if(chordList.get(i).equals(chord)){
                index = i;
                break;
            }
        }
        return index;
    }
    
    public static void initialize(){
        imgList = new ArrayList<>();
        chordList = new ArrayList<>();
        addImg("file:chordImage/A/A.png");
        addImg("file:chordImage/A/A_.png");
        addImg("file:chordImage/A/A_+.png");
        
        addImg("file:chordImage/A/A_+7.png");
        addImg("file:chordImage/A/A_7(9).png");
        addImg("file:chordImage/A/A_7(sus4).png");
        
        addImg("file:chordImage/A/A_7.png");
        addImg("file:chordImage/A/A_dim7.png");
        addImg("file:chordImage/A/A_m.png");
        
        addImg("file:chordImage/A/A_m6.png");
        addImg("file:chordImage/A/A_m7(b5).png");
        addImg("file:chordImage/A/A_m7.png");
        
        addImg("file:chordImage/A/A_maj6.png");
        
        addImg("file:chordImage/A/A_maj7.png");
        addImg("file:chordImage/A/A_sus4.png");
        addImg("file:chordImage/A/A+.png");
        
        addImg("file:chordImage/A/A+7.png");
        addImg("file:chordImage/A/A7(9).png");
        addImg("file:chordImage/A/A7(sus4).png");
        
        //------------------
        
        addImg("file:chordImage/A/A7.png");
        addImg("file:chordImage/A/Ab.png");
        addImg("file:chordImage/A/Ab+.png");
        
        addImg("file:chordImage/A/Ab+7.png");
        addImg("file:chordImage/A/Ab7(9).png");
        addImg("file:chordImage/A/Ab7.png");
        
        addImg("file:chordImage/A/Abdim7.png");
        addImg("file:chordImage/A/Abm.png");
        addImg("file:chordImage/A/Abm6.png");
        
        // ---------------
        
        addImg("file:chordImage/A/Abmaj6.png");
        addImg("file:chordImage/A/Abmaj7.png");
        addImg("file:chordImage/A/Absus4+.png");
        
        addImg("file:chordImage/A/Adim7.png");
        addImg("file:chordImage/A/Am.png");
        addImg("file:chordImage/A/Am6.png");
        
        addImg("file:chordImage/A/Am7(b5).png");
        addImg("file:chordImage/A/Am7.png");
        addImg("file:chordImage/A/Amaj6.png");
        
        addImg("file:chordImage/A/Amaj7.png");
        addImg("file:chordImage/A/Asus4.png");
        
        
    }
    
}
