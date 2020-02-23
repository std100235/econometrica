/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import controller.CountryController;
import entity.Country;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.sql.SQLDataException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author rovas
 */
public class CSVReader {
    
    private static String csvFile = "iso-countries.csv";
    private BufferedReader reader = null;
    private String line;
    private static final String delimiter=";";
    private Country country;
    
    public void putCSVDataToDatabase() {
        
        try {
            Integer counter=0;
            CountryController countryController = new CountryController();
            reader = new BufferedReader(new FileReader(csvFile));
            while ((line = reader.readLine()) != null) {
                if(counter!=0) {
                    Country country = new Country();
                    String[] countries = line.split(delimiter);
                    
                    if(countries[2].length()!=3) {
                        JOptionPane.showMessageDialog(null, "Γραμμή " + counter.toString() +": Η στήλη alpha3 πρέπει να είναι έως 3 χαρακτήρες.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                    
                    country.setIsoCode(countries[2]);
                    country.setName(countries[0]);
                    List countryInDb = countryController.getCountryISOCode(countries[2]);
                    
                    if(countryInDb.isEmpty())
                        countryController.storeCountriesToDataBase(country);
                }
                counter+=1;
            }
        } 
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Το αρχείο iso-countries δεν βρέθηκε.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
