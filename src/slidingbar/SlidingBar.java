package slidingbar;

import org.apache.commons.io.FileUtils;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SlidingBar {
    static double heightBar = 200;
    static double widthBar = 280;
    static double heightEdge = 700;
    static double widthEdge = 700;
    static double widthAlphabet = 175;
    static double heightAlphabet = 125;
    static double gap = 70;
    int count = 0;
    int time = 0;
    int target = 0;
    int barTarget =0;
    boolean checkSprite = false;
    boolean checkPause = false;
    boolean checkMute = false;
    
    MusicDisplay song ;
    
    Guide guide = new Guide("A");
    
    PauseButton pauseButton = new PauseButton();
    
    public void play(Stage primaryStage,String songName) {
        
        Pane root = new Pane();
        
        song = new MusicDisplay(songName);
        
        Label showTime = new Label();
        setLabel(showTime, 15, 15);
        showTime.setText(""+time);
        
        Button up = new Button();
        Button down = new Button();
        setButton(up, 50, 15);
        setButton(down,50,45);
        up.setText("+");
        down.setText("-");
        
        //guide.setImage(song.alphabet.get(0));
        
        root.getChildren().addAll(new Fingerboard().img,showTime,up,down,pauseButton.img,guide.img);
        
        changeGuide(song.chord.get(time));
        
        song.createBlock();
        /*
        for(int i=0;i<song.chord.size();i++){
            System.out.println(song.chord.get(i));
        }
        */
        for(int i=0;i<song.bar.size();i++){
            root.getChildren().add(song.bar.get(i).img);
        }
        
        for(int i=0;i<song.alphabet.size();i++){
            root.getChildren().add(song.alphabet.get(i).img);
        }
        
        Scene scene = new Scene(root, 700, 700);
        
        primaryStage.setTitle("Guitar Wizard");
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.show();
        
        song.playMusic();
        
        AnimationTimer background = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // update label
                showTime.setText("x"+song.normalSpeed);
                // time
                
                if(!checkPause){
                    for(int i=0;i<song.bar.size();i++){
                        song.bar.get(i).slide();
                    }
                    
                    for(int i=0;i<song.alphabet.size();i++){
                        song.alphabet.get(i).slide();
                    }
                }
                
                count++;
                if(count==60){
                   time++;
                   count=0;
                }
                //System.out.println(canonD.bar.get(target*4).img.getX()+","+canonD.bar.get((target+1)*4).img.getX()+"          "+target);
                
                if(song.bar.get(target).img.getX()<=0&&target<song.chord.size()){
                    if(!song.chord.get(target).equals("-")){
                        changeGuide(song.chord.get(target));
                    }
                    target++;
                }
                
                // increase and decrease button
                up.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        if(song.mediaPlayer.getVolume()<=1)
                            song.mediaPlayer.setVolume(song.mediaPlayer.getVolume()+0.1);
                        
                    }
                });
                
                down.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        if(song.mediaPlayer.getVolume()>=0)
                            song.mediaPlayer.setVolume(song.mediaPlayer.getVolume()-0.1);
                    }
                });
               
            }
        };
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
        
        @Override
        public void handle(KeyEvent keyEvent) {
            
            switch(keyEvent.getCode().toString()){
                case "P":
                    if(pauseButton.count)
                        song.mediaPlayer.play();
                    else
                        song.mediaPlayer.pause();
                    if(checkMute&&checkPause){
                        checkMute=!checkMute;
                        song.mediaPlayer.setMute(checkMute);
                    }
                    root.getChildren().remove(pauseButton.img);
                    pauseButton.spriteButton();
                    root.getChildren().add(pauseButton.img);
                    checkPause=!checkPause;
                    break;
                case "X":
                    song.increaseSpeed();
                    break;
                case "Z":
                    song.decreaseSpeed();
                    break;
                case "M":
                    checkMute=!checkMute;
                    song.mediaPlayer.setMute(checkMute);
                    root.getChildren().remove(pauseButton.img);
                    pauseButton.muteButton();
                    root.getChildren().add(pauseButton.img);
                    break;
            }
        }
        });
        
        background.start();
        
    }
    
    public void setLabel(Label label,double x,double y){
        label.setLayoutX(x);
        label.setLayoutY(y);
    }
    
    public void setButton(Button button,double x,double y){
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setMinHeight(30);
        button.setMinWidth(30);
    }
    
    public void changeGuide(String name){
        if(name.length()>1&&name.charAt(1)=='#'){
            guide.setImage(name.substring(0, 1)+"_"+name.substring(2,name.length()));
        }else if(name.equals("-")){
            
        }
        else{
            guide.setImage(name);
        }
            
    }
    /**
     * @param args the command line arguments
     */

}
