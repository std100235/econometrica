/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import communication.APIJsonParser;
import communication.CSVReader;
import communication.DBManager;
import communication.GDPData;
import design.MainMenu;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import okhttp3.Response;
/**
 *
 * @author rovas
 */
public class Econometrica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        DBManager dbManager = DBManager.getInstance();
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            //@Override
            public void run() {
                MainMenu frame = null;
                //try {
                    frame = new MainMenu();
                    frame.setSize(560, 460);
                    frame.addWindowListener(new WindowAdapter(){
                        public void windowClosing(WindowEvent we){
                            System.exit(0);
                        }
                    });
                //} 
//                catch (IOException ex) {
//                    Logger.getLogger(Econometrica.class.getName()).log(Level.SEVERE, null, ex);
//                }
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        
        CountryRenderer s = new CountryRenderer();
        
//        CSVReader csvReader = new CSVReader();
//        csvReader.putCSVDataToDatabase();
//        
//        APIJsonParser parser = new APIJsonParser("https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json?api_key=xkU1koXdFqiyixvkzpf7");
//        
//        parser.ParseDataAndSaveToDb();
        
        String x = "";
        
    }

    private static class TypeToken<T> {

        public TypeToken() {
        }
    }
}
