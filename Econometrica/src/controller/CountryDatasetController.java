/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.CountryDataset;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author rovas
 */
public class CountryDatasetController extends MainController {
    public CountryDatasetController(){
        super();
    } 
    
    /* Αποθήκευση αγαπημένεης λίστας στη βάση δεδομένων */
    public void storeCountryDatasetToDataBase(CountryDataset countryDataset){
        em.getTransaction().begin();
        em.persist(countryDataset);
        em.getTransaction().commit();
    }
 
    /* Διαγραφή αγαπημένεης λίστας από τη βάση δεδομένων */
    public void deleteCountryDatasetFromDataBase(String listName){
        em.getTransaction().begin();
        Query query = em.createNamedQuery("CountryDataset.deleteList");
        query.setParameter("name", listName);
        query.executeUpdate();
        em.getTransaction().commit();
    }

    /* Αντικατάσταση ονόματος αγαπημένης λίστας */
    public void updateCountryDatasetName(CountryDataset favoriteList, String name){
        em.getTransaction().begin();
        favoriteList.setName(name);
        em.getTransaction().commit();
    }
   
    /* Εύρεση όλων των αγαπημένων λιστών */    
    public List getCountryDataset(){
        Query query = em.createNamedQuery("FavoriteList.findAll");
        return query.getResultList();
    }
  
    /* Εύρεση αγαπημένης λίστας με βάση το όνομα */      
    public CountryDataset getCountryDatasetByName(String name){
        Query q = em.createNamedQuery("FavoriteList.findByName");
        q.setParameter("name", name);
        List<CountryDataset> found = q.getResultList();
        if (found.isEmpty()) {
            return null; //or throw checked exception data not found
        } else {
            return found.get(0);
        }

    }
}
