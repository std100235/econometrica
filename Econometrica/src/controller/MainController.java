/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import communication.DBManager;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author rovas
 */
public abstract class MainController {
    
    protected EntityManager em;
    
    // Δημιουργία EntityManager
    public MainController(){
        DBManager dbManager = DBManager.getInstance();
        em = dbManager.getEm();
    }
    
    // μέθοδος διαγραφής πίνακα μέσω ενός έτοιμου namedQuery
    public void deleteFromDataBase(String query){
        try 
        { 
            em.getTransaction().begin();
            Query q = em.createNamedQuery(query);
            q.executeUpdate();
            em.getTransaction().commit();
        } 
        catch (Exception e) 
        { 
            em.getTransaction().rollback();
        } 
    }
    
}
