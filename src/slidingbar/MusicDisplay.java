package slidingbar;

import Database.Connection;
import Database.User;
import Database.Music;
import org.apache.commons.io.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import static slidingbar.SlidingBar.heightBar;
import static slidingbar.SlidingBar.widthBar;
import static slidingbar.SlidingBar.heightEdge;
import static slidingbar.SlidingBar.widthEdge;
import static slidingbar.SlidingBar.gap;
import static slidingbar.SlidingBar.gapSolo;
import static slidingbar.SlidingBar.heightAlphabet;
import static slidingbar.SlidingBar.widthAlphabet;
import static slidingbar.SlidingBar.widthSoloBar;
import static slidingbar.SlidingBar.gapBar;

public class MusicDisplay {
    
    private String name;
    public int index;
    public List<Bar> bar = new ArrayList<Bar>();
    public List<Alphabet> alphabet = new ArrayList<Alphabet>();
    public List<Number> number = new ArrayList<Number>();
    public List<Music> musicList = new ArrayList<Music>();
    List<String> chord = new ArrayList<String>();
    MediaPlayer mediaPlayer;
    public double normalSpeed;
    public double defaultSpeed=1.0;
    public int bpm;
    public int bpmDefualt;
    public double movement;
    boolean pause;
    
    public MusicDisplay(String name){
        try {
            init(name);
            this.name = name;
            subString(musicList.get(index).getChord());
            bpm = musicList.get(index).getBpm();
            bpmDefualt = bpm;
            movement = (((bpm/2)*widthBar)/60)/60;
            downloadMusic(name);
            normalSpeed = 1.0;
            createBlock();
            mediaPlayer = new MediaPlayer(new Media(new File("music/"+name+".mp3").toURI().toString()));
            mediaPlayer.setVolume(0.5);
            pause = false;
        } catch (IOException ex) {
            Logger.getLogger(MusicDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     
    public void decreaseSpeed(){
        bpm-=bpmDefualt*0.25;
        for(int i=0;i<bar.size();i++){
            bar.get(i).decreaseSpeed(bpm);
        }
        for(int i=0;i<alphabet.size();i++){
            alphabet.get(i).decreaseSpeed(bpm);
        }
        for(int i=0;i<number.size();i++){
            number.get(i).decreaseSpeed(bpm);
        }
        decreasePlaybackSpeed();
    }
    
    public void increaseSpeed(){
        bpm+=bpmDefualt*0.25;
        for(int i=0;i<bar.size();i++){
            bar.get(i).increaseSpeed(bpm);
        }
        for(int i=0;i<alphabet.size();i++){
            alphabet.get(i).increaseSpeed(bpm);
        }
        for(int i=0;i<number.size();i++){
            number.get(i).decreaseSpeed(bpm);
        }
        increasePlaybackSpeed();
    }
    
    public void decreasePlaybackSpeed(){
        normalSpeed-=(defaultSpeed*0.25);
        mediaPlayer.setRate(normalSpeed);
    }
    
    public int randomChord(){
        return (int)(Math.random()*6)+1;
    }
    
    public void init(String name){
        chord = new ArrayList<>();
        EntityManager em = Connection.emf.createEntityManager();
        try {
            TypedQuery<Music> q = em.createQuery("SELECT FROM Music", Music.class);
            int i=0;
            for (Music music : q.getResultList()) {
                musicList.add(music);
                if(name.equals(musicList.get(i).getName()))
                    index=i;
                i++;
            }
        } finally {
            em.close();
        }
    }
    
    public void createBlock(){
        int soloIndex = 0;
        double soloDistance = 0,countSolo =0;
        boolean checkSolo = false;
        for(int i=0;i<chord.size();i++){

            if(chord.get(i).equals("-")||chord.get(i).equals("&-")){
                    if(i%4==0)
                        bar.add(new Bar(widthBar,heightBar,0,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                    else if(i%4==3)
                        bar.add(new Bar(widthBar,heightBar,2,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                    else
                        bar.add(new Bar(widthBar,heightBar,1,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
            }
            else if(chord.get(i).charAt(0)=='$'){
                soloIndex = i;
                do{
                    checkSolo = true;
                    if(soloIndex-i%4==0)
                        bar.add(new Bar(widthSoloBar,heightBar,6,(widthEdge/2)+widthEdge+(gap*i)+((soloIndex-i)*gapSolo),heightEdge-heightBar,movement));
                    else if(soloIndex-i%8==7)
                        bar.add(new Bar(widthSoloBar,heightBar,8,(widthEdge/2)+widthEdge+(gap*i)+((soloIndex-i)*gapSolo),heightEdge-heightBar,movement));
                    else
                        bar.add(new Bar(widthSoloBar,heightBar,7,(widthEdge/2)+widthEdge+(gap*i)+((soloIndex-i)*gapSolo),heightEdge-heightBar,movement));
                    if(chord.get(soloIndex).charAt(0)=='['){
                        number.add(new Number(70,70,Integer.parseInt(chord.get(soloIndex).substring(3,5))-1
                                ,(widthEdge/2)+widthEdge+(gap*i)+((soloIndex-i)*gapSolo),heightEdge-50-((heightBar/6)*(Integer.parseInt(chord.get(soloIndex).substring(1,2))-1)),movement));
                    }else if(chord.get(soloIndex).length()>1&&chord.get(soloIndex).charAt(1)=='['){
                        number.add(new Number(70,70,Integer.parseInt(chord.get(soloIndex).substring(4,6))-1
                                ,(widthEdge/2)+widthEdge+(gap*i)+((soloIndex-i)*gapSolo),heightEdge-50-((heightBar/6)*(Integer.parseInt(chord.get(soloIndex).substring(2,3))-1)),movement));
                    }
                    soloIndex++;
                    if(chord.get(soloIndex).length()>1){
                        checkSolo = false;
                    }
                }while(checkSolo||chord.get(soloIndex).charAt(0)!='&');
                countSolo += (soloIndex - i)/8;
                i = soloIndex-1;
            }
            else{
                int step = 0;
                if(chord.get(i).charAt(0)=='&')
                   step = 1;
                if(chord.get(i).length()>1&&chord.get(i).charAt(1+step)=='#'){
                    alphabet.add(new Alphabet(chord.get(i).substring(0+step, 1+step)+"_"+chord.get(i).substring(2+step,chord.get(i).length()),
                            widthAlphabet, heightAlphabet, (widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo), heightEdge-heightBar+20, movement));
                    if(i%4==0)
                        bar.add(new Bar(widthBar,heightBar,3,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                    else if(i%4==3)
                        bar.add(new Bar(widthBar,heightBar,5,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                    else
                        bar.add(new Bar(widthBar,heightBar,4,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                }else if(chord.get(i).length()>0){
                    alphabet.add(new Alphabet(chord.get(i).substring(step,chord.get(i).length()),
                            widthAlphabet, heightAlphabet, (widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo), heightEdge-heightBar+20, movement));
                    if(i%4==0)
                        bar.add(new Bar(widthBar,heightBar,3,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                    else if(i%4==3)
                        bar.add(new Bar(widthBar,heightBar,5,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                    else
                        bar.add(new Bar(widthBar,heightBar,4,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                }else{
                    if(i%4==0)
                            bar.add(new Bar(widthBar,heightBar,0,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                    else if(i%4==2)
                        bar.add(new Bar(widthBar,heightBar,1,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                    else if(i%4==3)
                        bar.add(new Bar(widthBar,heightBar,2,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                    else
                        bar.add(new Bar(widthBar,heightBar,2,(widthEdge/2)+widthEdge+(gap*i)-(gapBar*countSolo),heightEdge-heightBar,movement));
                }
                
            }
            
        }

        
    }

    public void subString (String line){
        int index = 0,before = 0,indexSolo = 0,endSolo = 0;
        boolean solo = false;
        while(index<line.length()){
            if(line.charAt(index)=='*'){
                if(line.charAt(before)=='|')
                    chord.add(line.substring(before+1,index));
                else
                    chord.add(line.substring(before,index));
                before=index+1;
            }
            index++;
        }
        System.out.println(chord);
    }
    
    public void downloadMusic(String name) throws IOException{
        Download.DownloadMusic(name);
    }
    
}
