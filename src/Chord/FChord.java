package Chord;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FChord extends AllChord{
    public static List<Image> imgList;
    public static List<String> chordList;
    
    private int count = 0;
    public ImageView img;

    public FChord(int imgIndex){
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
        addImg("file:chordImage/F/F.png");
        addImg("file:chordImage/F/F_.png");
        addImg("file:chordImage/F/F_+.png");
        addImg("file:chordImage/F/F_7.png");
        addImg("file:chordImage/F/F_dim7.png");
        addImg("file:chordImage/F/F_m.png");
        addImg("file:chordImage/F/F_m6.png");
        addImg("file:chordImage/F/F_m7(b5).png");
        addImg("file:chordImage/F/F_m7.png");
        addImg("file:chordImage/F/F_maj6.png");
        addImg("file:chordImage/F/F_maj7.png");
        addImg("file:chordImage/F/F_sus4.png");
        addImg("file:chordImage/F/F+.png");
        addImg("file:chordImage/F/F7.png");
        addImg("file:chordImage/F/Fdim7.png");
        addImg("file:chordImage/F/Fm.png");
        addImg("file:chordImage/F/Fm6.png");
        addImg("file:chordImage/F/Fm7(b5).png");
        addImg("file:chordImage/F/Fm7.png");
        addImg("file:chordImage/F/Fmaj6.png");
        addImg("file:chordImage/F/Fmaj7.png");
        addImg("file:chordImage/F/Fsus4.png");
        
        
    }
    
}
