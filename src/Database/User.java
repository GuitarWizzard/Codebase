package Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private boolean isOnline;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "artist")
    private List<Music> musicList;
    
    public User(String name,String username,String password){
        this.name = name;
        this.username = username;
        this.password = password;
        this.isOnline = false;
        musicList = new ArrayList<Music>();
    }
    
    public void setMusic(Music music){
        musicList.add(music);
    }
    
    public String getName(){
        return name;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public List<Music> getMusic(){
        return musicList;
    }
    
    public boolean isOnline(){
        return isOnline;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.User[ id=" + id + " ]";
    }
    
}
