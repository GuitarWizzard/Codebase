package Main;
import Database.Connection;
import Database.Music;
import Database.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.persistence.EntityManager;

public class AddSample {
    Connection connect = new Connection();
    User neen = new User("patthawee chumpuvorn","admin","admin");
    User louis = new User("louisza","louis","louis"); 
    Music ThatWhatILike = new Music("ThatWhatILike",neen);
    String chordThatWhatILike = "";
    int bpmThatWhatILike;
    
    public void start(){
        connect.connect();
        neen.setMusic(ThatWhatILike);
        chordThatWhatILike = scannerChord("ThatWhatILike");
        ThatWhatILike.setChord(chordThatWhatILike);
        bpmThatWhatILike = scannerBpm("ThatWhatILike");
        ThatWhatILike.setBpm(bpmThatWhatILike);
        
        addUser(neen);
        addUser(louis);
    }
    
    public void addUser(User user){
        EntityManager em = connect.getConnection().createEntityManager();
        em.getTransaction().begin();
        
        em.persist(user);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public void addMusic(Music music){
        EntityManager em = connect.getConnection().createEntityManager();
        em.getTransaction().begin();
        
        em.persist(music);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public String scannerChord(String name){
        BufferedReader br;
        String filePath = new File("").getAbsolutePath();
        String line="";
        try {
            br = new BufferedReader(new FileReader(filePath+"/Chord/"+name+".txt"));
            try {
                String x;
                while ( (x = br.readLine()) != null ) {
            // Printing out each line in the file
                    line += x;
                }
                return line;
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public int scannerBpm(String name){
        BufferedReader br;
        String filePath = new File("").getAbsolutePath();
        int bpm=0;
        try {
            br = new BufferedReader(new FileReader("Bpm/"+name+".txt"));
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
    
}
