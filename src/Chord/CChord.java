package Chord;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CChord extends AllChord{
    public static List<Image> imgList;
    public static List<String> chordList;
    
    private int count = 0;
    public ImageView img;

    public CChord(int imgIndex){
        img = new ImageView(imgList.get(imgIndex));
        
    }
    
    public static void addImg(String path) {
        imgList.add(new Image(path));
        addString(path);
    }
    
    public static void addString(String chord){
        chordList.add(chord.substring(18,chord.length()-4));
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
        addImg("file:chordImage/C/C.png");
        addImg("file:chordImage/C/C_.png");
        addImg("file:chordImage/C/C_+.png");
        
        addImg("file:chordImage/C/C_7.png");
        addImg("file:chordImage/C/C_dim7.png");
        addImg("file:chordImage/C/C_m.png");
        addImg("file:chordImage/C/C_m6.png");
        addImg("file:chordImage/C/C_m7.png");
        addImg("file:chordImage/C/C_maj6.png");
        addImg("file:chordImage/C/C_maj7.png");
        addImg("file:chordImage/C/C_sus4.png");
        addImg("file:chordImage/C/C+.png");
        addImg("file:chordImage/C/C7.png");
        addImg("file:chordImage/C/Cdim7.png");
        addImg("file:chordImage/C/Cm.png");
        
        addImg("file:chordImage/C/Cm6.png");
        addImg("file:chordImage/C/Cm7.png");
        addImg("file:chordImage/C/Cmaj6.png");
        addImg("file:chordImage/C/Cmaj7.png");
        addImg("file:chordImage/C/Csus4.png");
        
    }
    
}
