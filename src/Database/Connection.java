package Database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    public static EntityManagerFactory emf;
    
    public static void connect(){
        emf = Persistence.createEntityManagerFactory("objectdb://161.246.6.25:6136/database.odb;user=admin;password=admin");
        
    }
    
    public static EntityManagerFactory getConnection(){
        return emf;
    }
}
