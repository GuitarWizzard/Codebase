package Chord;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DChord extends AllChord{
    public static List<Image> imgList;
    public static List<String> chordList;
    
    private int count = 0;
    public ImageView img;

    public DChord(int imgIndex){
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
        addImg("file:chordImage/D/D.png");
        addImg("file:chordImage/D/D_.png");
        addImg("file:chordImage/D/D_+.png");
        addImg("file:chordImage/D/D_7.png");
        addImg("file:chordImage/D/D_dim7.png");
        addImg("file:chordImage/D/D_m.png");
        addImg("file:chordImage/D/D_m6.png");
        addImg("file:chordImage/D/D_m7.png");
        addImg("file:chordImage/D/D_maj6.png");
        addImg("file:chordImage/D/D_maj7.png");
        addImg("file:chordImage/D/D+.png");
        addImg("file:chordImage/D/D7.png");
        addImg("file:chordImage/D/Db.png");
        addImg("file:chordImage/D/Db+7.png");
        addImg("file:chordImage/D/Db7(9).png");
        addImg("file:chordImage/D/Dbdim7.png");
        addImg("file:chordImage/D/Dbm.png");
        addImg("file:chordImage/D/Dbm6.png");
        addImg("file:chordImage/D/Dbm7.png");
        addImg("file:chordImage/D/Dbmaj6.png");
        addImg("file:chordImage/D/Dbmaj7.png");
        addImg("file:chordImage/D/Dbsus4.png");
        addImg("file:chordImage/D/Ddim7.png");
        addImg("file:chordImage/D/Dm.png");
        addImg("file:chordImage/D/Dm6.png");
        addImg("file:chordImage/D/Dm7.png");
        addImg("file:chordImage/D/Dmaj6.png");
        addImg("file:chordImage/D/Dmaj7.png");
        addImg("file:chordImage/D/Dsus4.png");
        
        
    }
    
}
