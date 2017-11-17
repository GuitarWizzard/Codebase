package slidingbar;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
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

public class SlidingBar extends Application {
    static double heightBar = 200;
    static double widthBar = 280;
    static double heightEdge = 700;
    static double widthEdge = 700;
    static double gap = 280;
    static double gapChord = 70;
    int count = 0;
    int time = 0;
    boolean checkSprite = false;
    boolean checkPause = false;
    boolean checkMute = false;
    
    Music canonD = new Music("ThatWhatILike");
    
    PauseButton pauseButton = new PauseButton();
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        
        Label showTime = new Label();
        setLabel(showTime, 15, 15);
        showTime.setText(""+time);
        
        Button up = new Button();
        Button down = new Button();
        setButton(up, 50, 15);
        setButton(down,50,45);
        up.setText("+");
        down.setText("-");
        
        root.getChildren().addAll(new Fingerboard().img,showTime,up,down,pauseButton.img);
        
        
        
        canonD.createBlock();
        
        for(int i=0;i<canonD.bar.size();i++){
            root.getChildren().add(canonD.bar.get(i).img);
        }
        
        Scene scene = new Scene(root, 700, 700);
        
        primaryStage.setTitle("Guitar Wizard");
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.show();
        
        canonD.playMusic();
        
        for(int i=0;i<canonD.bar.size();i++){
            //root.getChildren().remove(canonD.bar.get(i).img);
            //canonD.bar.get(i).slide();
            //root.getChildren().add(canonD.bar.get(i).img);         
        }
        
        AnimationTimer background = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // update label
                showTime.setText("x"+canonD.normalSpeed);
                // time
                
                if(!checkPause){
                    for(int i=0;i<canonD.bar.size();i++){
                        canonD.bar.get(i).slide();
                    }
                }
                
                count++;
                if(count==120){
                   time++;
                   count=0;
                   //Toolkit.getDefaultToolkit().beep();
                   //canonD.generateBlock();
                   //root.getChildren().add(canonD.bar.get(canonD.bar.size()-1).img);
                  
                }
                
               
                
                // increase and decrease button
                up.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        if(canonD.mediaPlayer.getVolume()<=1)
                            canonD.mediaPlayer.setVolume(canonD.mediaPlayer.getVolume()+0.1);
                        
                    }
                });
                
                down.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        if(canonD.mediaPlayer.getVolume()>=0)
                            canonD.mediaPlayer.setVolume(canonD.mediaPlayer.getVolume()-0.1);
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
                        canonD.mediaPlayer.play();
                    else
                        canonD.mediaPlayer.pause();
                    if(checkMute&&checkPause){
                        checkMute=!checkMute;
                        canonD.mediaPlayer.setMute(checkMute);
                    }
                    root.getChildren().remove(pauseButton.img);
                    pauseButton.spriteButton();
                    root.getChildren().add(pauseButton.img);
                    checkPause=!checkPause;
                    break;
                case "X":
                    canonD.increasePlaybackSpeed();
                    for(int i=0;i<canonD.bar.size();i++){
                        canonD.bar.get(i).increaseSpeed();
                    }
                    break;
                case "Z":
                    canonD.decreasePlaybackSpeed();
                    for(int i=0;i<canonD.bar.size();i++){
                        canonD.bar.get(i).decreaseSpeed();
                    }
                    break;
                case "M":
                    checkMute=!checkMute;
                    canonD.mediaPlayer.setMute(checkMute);
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
    /**
     * @param args the command line arguments
     */
    public static void test() {
        launch();
    }
    
    public static void main(){
        test();
    }
}
