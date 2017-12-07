package Chord;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EChord extends AllChord{
    public static List<Image> imgList;
    public static List<String> chordList;
    
    private int count = 0;
    public ImageView img;

    public EChord(int imgIndex){
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
        addImg("file:chordImage/E/E.png");
        addImg("file:chordImage/E/E+.png");
        addImg("file:chordImage/E/E7.png");
        addImg("file:chordImage/E/Eb.png");
        addImg("file:chordImage/E/Eb+.png");
        addImg("file:chordImage/E/Eb+7.png");
        addImg("file:chordImage/E/Eb7(9).png");
        addImg("file:chordImage/E/Eb7.png");
        addImg("file:chordImage/E/Ebdim7.png");
        addImg("file:chordImage/E/Ebm.png");
        addImg("file:chordImage/E/Ebm6.png");
        addImg("file:chordImage/E/Ebm7.png");
        addImg("file:chordImage/E/Ebmaj7.png");
        addImg("file:chordImage/E/Ebsus4.png");
        addImg("file:chordImage/E/Edim7.png");
        addImg("file:chordImage/E/Em.png");
        addImg("file:chordImage/E/Em6.png");
        addImg("file:chordImage/E/Em7.png");
        addImg("file:chordImage/E/Emaj6.png");
        addImg("file:chordImage/E/Emaj7.png");
        addImg("file:chordImage/E/Esus4.png");
    }
    
}
