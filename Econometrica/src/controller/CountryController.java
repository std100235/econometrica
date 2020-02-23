/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Country;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author rovas
 */
public class CountryController extends MainController {
    
    public CountryController(){
        super();
    } 
    
    public void storeCountriesToDataBase(Country country){
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
    }
    
    public List getCountryISOCode(String isoCode){
        Query query = em.createNamedQuery("Country.findByIsoCode");
        query.setParameter("isoCode", isoCode);
        return query.getResultList();
    }
    
    public List getCountry(String name){
        Query query = em.createNamedQuery("Country.findByName");
        query.setParameter("name", name);
        return query.getResultList();
    }
}
