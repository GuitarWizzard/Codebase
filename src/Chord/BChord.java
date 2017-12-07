package Chord;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BChord extends AllChord{
    public static List<Image> imgList;
    public static List<String> chordList;
    
    private int count = 0;
    public ImageView img;

    public BChord(int imgIndex){
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
        addImg("file:chordImage/B/B.png");
        addImg("file:chordImage/B/B+.png");
        addImg("file:chordImage/B/B+7.png");
        addImg("file:chordImage/B/B7(9).png");
        addImg("file:chordImage/B/B7(sus4).png");
        addImg("file:chordImage/B/B7.png");
        addImg("file:chordImage/B/Bb.png");
        addImg("file:chordImage/B/Bb+.png");
        addImg("file:chordImage/B/Bb+7.png");
        addImg("file:chordImage/B/Bb7(9).png");
        addImg("file:chordImage/B/Bb7.png");
        addImg("file:chordImage/B/Bbdim7.png");
        addImg("file:chordImage/B/Bbm.png");
        addImg("file:chordImage/B/Bbm6.png");
        addImg("file:chordImage/B/Bbm7.png");
        addImg("file:chordImage/B/Bbmaj6.png");
        addImg("file:chordImage/B/Bbmaj7.png");
        addImg("file:chordImage/B/Bbsus4.png");
        addImg("file:chordImage/B/Bdim7.png");
        addImg("file:chordImage/B/Bm.png");
        addImg("file:chordImage/B/Bm6.png");
        addImg("file:chordImage/B/Bm7(b5).png");
        addImg("file:chordImage/B/Bm7.png");
        addImg("file:chordImage/B/Bmaj6.png");
        addImg("file:chordImage/B/Bmaj7.png");
        addImg("file:chordImage/B/Bsus4.png");
        
        
    }
    
}
