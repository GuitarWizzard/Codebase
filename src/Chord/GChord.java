package Chord;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GChord extends AllChord{
    public static List<Image> imgList;
    public static List<String> chordList;
    
    private int count = 0;
    public ImageView img;

    public GChord(int imgIndex){
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
        addImg("file:chordImage/G/guitarwizard.png");
        addImg("file:chordImage/G/G.png");
        addImg("file:chordImage/G/G_.png");
        addImg("file:chordImage/G/G_+.png");
        addImg("file:chordImage/G/G_7.png");
        addImg("file:chordImage/G/G_dim7.png");
        addImg("file:chordImage/G/G_m.png");
        addImg("file:chordImage/G/G_m7.png");
        addImg("file:chordImage/G/G_maj7.png");
        addImg("file:chordImage/G/G+.png");
        addImg("file:chordImage/G/G7.png");
        addImg("file:chordImage/G/Gb.png");
        addImg("file:chordImage/G/Gb+.png");
        addImg("file:chordImage/G/Gb+7.png");
        addImg("file:chordImage/G/Gb7(9).png");
        addImg("file:chordImage/G/Gb7.png");
        addImg("file:chordImage/G/Gbdim7.png");
        addImg("file:chordImage/G/Gbm.png");
        addImg("file:chordImage/G/Gbm6.png");
        addImg("file:chordImage/G/Gbm7.png");
        addImg("file:chordImage/G/Gbmaj6.png");
        addImg("file:chordImage/G/Gbmaj7.png");
        addImg("file:chordImage/G/Gbsus4.png");
        addImg("file:chordImage/G/Gdim7.png");
        addImg("file:chordImage/G/Gm.png");
        addImg("file:chordImage/G/Gm7.png");
        addImg("file:chordImage/G/Gmaj7.png");
        
        
    }
    
}
