package Database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Music implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String chord;
    private int bpm;
    @ManyToOne
    private User artist;
    

    public Music(String name,User artist){
        this.name = name;
        this.artist = artist;
    }
    
    public User getArtist(){
        return artist;
    }
    
    public String getName(){
        return name;
    }
    
    public void setChord(String chord){
        this.chord = chord;
    }
    
    public String getChord(){
        return chord;
    }
    
    public void setBpm(int bpm){
        this.bpm = bpm;
    }
    
    public int getBpm(){
        return bpm;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Music)) {
            return false;
        }
        Music other = (Music) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Music[ id=" + id + " ]";
    }
    
}
