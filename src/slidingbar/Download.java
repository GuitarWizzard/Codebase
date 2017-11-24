package slidingbar;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

public class Download {
    public static void DownloadMusic(String name) throws MalformedURLException, IOException{
        URL url = new URL("http://161.246.6.25/songs/"+name+".mp3");
        File download = new File("music/"+name+".mp3"); 
        download.deleteOnExit(); 
        FileUtils.copyURLToFile(url, download);
        
    }
    
}
