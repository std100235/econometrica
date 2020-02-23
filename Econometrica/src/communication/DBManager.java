/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author rovas
 */
public class DBManager {
    
    private static final String PERSISTENCE_UNIT = "EconometricaPU";
    // Η κλάση EntityManagerFactory είναι Thread-Safe
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    private EntityManager em;
    private final String ERROR_MSG = "Αποτυχία σύνδεσης με τη Βάση Δεδομένων!";
    
    private static DBManager dbManager;
    
    private DBManager(){
        try 
        {
            if(em == null){
                // δημιουργία Entity Manager
                em = EMF.createEntityManager();
            } 
        }
        catch(Exception e) 
        {
            JOptionPane.showMessageDialog(null, ERROR_MSG, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   public static DBManager getInstance(){
       if(dbManager == null){
           dbManager = new DBManager();
       }
       return dbManager;
   }
   
   public EntityManager getEm(){
       return em;
   }
    
}
