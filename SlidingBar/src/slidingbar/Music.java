package slidingbar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static slidingbar.SlidingBar.heightBar;
import static slidingbar.SlidingBar.widthBar;
import static slidingbar.SlidingBar.heightEdge;
import static slidingbar.SlidingBar.widthEdge;
import static slidingbar.SlidingBar.gap;

public class Music {
    
    private String name;
    public int SIZE;
    public List<Bar> bar = new ArrayList<Bar>();
    List<String> chord = new ArrayList<String>();
    MediaPlayer mediaPlayer;
    public double normalSpeed;
    public double defaultSpeed=1.0;
    public int bpm;
    public double movement;
    boolean pause;
    
    public Music(String name){
        this.name = name;
        scannerChord(name);
        bpm = scannerBpm(name);
        movement = (((bpm/2)*widthBar)/60)/60;
        System.out.println(movement);
        SIZE = 100;
        normalSpeed = 1.0;
        createBlock();
        mediaPlayer = new MediaPlayer(new Media(new File("/music/"+name+".mp3").toURI().toString()));
        mediaPlayer.setVolume(0.5);
        pause = false;
    }
    
    public void playMusic(){
        mediaPlayer.play();
        pause = false;
    }
    
    public void pauseMusic(){
        mediaPlayer.pause();
        pause = true;
    }
    
    public void increasePlaybackSpeed(){
        normalSpeed+=(defaultSpeed*0.25);
        mediaPlayer.setRate(normalSpeed);
    }
    
    public void decreasePlaybackSpeed(){
        normalSpeed-=(defaultSpeed*0.25);
        mediaPlayer.setRate(normalSpeed);
    }
    
    public int randomChord(){
        return (int)(Math.random()*6)+1;
    }
    
    public void createBlock(){
        
        for(int i=0;i<SIZE;i++){
            int random = randomChord();
            if(random==1)
                bar.add(new Bar(widthBar,heightBar,"/slidingbar/1.jpg",widthEdge+(gap*i),heightEdge-heightBar-10,i,movement));
            else if(random==2)
                bar.add(new Bar(widthBar,heightBar,"/slidingbar/2.jpg",widthEdge+(gap*i),heightEdge-heightBar-10,i,movement));
            else if(random==3)
                bar.add(new Bar(widthBar,heightBar,"/slidingbar/3.jpg",widthEdge+(gap*i),heightEdge-heightBar-10,i,movement));
            else if(random==4)
                bar.add(new Bar(widthBar,heightBar,"/slidingbar/4.jpg",widthEdge+(gap*i),heightEdge-heightBar-10,i,movement));
            else if(random==5)
                bar.add(new Bar(widthBar,heightBar,"/slidingbar/5.jpg",widthEdge+(gap*i),heightEdge-heightBar-10,i,movement));
            else if(random==6)
                bar.add(new Bar(widthBar,heightBar,"/slidingbar/6.jpg",widthEdge+(gap*i),heightEdge-heightBar-10,i,movement));
        }
        
    }
    
    public void generateBlock(){
        if(SIZE%2==0)
            bar.add(new Bar(widthBar,heightBar,"/slidingbar/_green.png",widthEdge,heightEdge-heightBar-10,SIZE,movement));
        else
            bar.add(new Bar(widthBar,heightBar,"/slidingbar/_red.png",widthEdge,heightEdge-heightBar-10,SIZE,movement));
        SIZE++;
    
    }
    
    public int scannerBpm(String name){
        BufferedReader br;
        int bpm=0;
        try {
            br = new BufferedReader(new FileReader("/Bpm/"+name+".txt"));
            try {
                String x;
                while ( (x = br.readLine()) != null ) {
            // Printing out each line in the file
                    bpm = Integer.parseInt(x);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return bpm;
    }
    
    public void scannerChord(String name){
        BufferedReader br;
        String line="";
        try {
            br = new BufferedReader(new FileReader("/Chord/"+name+".txt"));
            try {
                String x;
                while ( (x = br.readLine()) != null ) {
            // Printing out each line in the file
                    line += x;
                }
                subString(line);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(chord);
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void subString (String line){
        int index = 0,before = 0;
        while(index<line.length()){
            if(line.charAt(index)=='*'){
                chord.add(line.substring(before,index));
                before=index+1;
            }
            index++;
        }
    }
    
}
