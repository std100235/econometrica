/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.CountryDataset;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author rovas
 */
public class APIJsonParser {
    
    private String url;
    private OkHttpClient client;
    
    public APIJsonParser(String url){
        this.url=url;
        client = new OkHttpClient();
    }
    
    public void ParseDataAndSaveToDb() {
        
        JsonParser parser = new JsonParser();

        String json = GetAPIData(url);
        if(json==null) {
            JOptionPane.showMessageDialog(null, "Η σύνδεση για ανάκτηση δεδομένων απέτυχε.", "Σφάλμα σύνδεσης", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JsonElement jsonTree = parser.parse(json);

        if(jsonTree.isJsonObject()){
            JsonObject jsonObject = jsonTree.getAsJsonObject();

            JsonElement f1 = jsonObject.get("dataset");

            if(f1.isJsonObject()){
                JsonObject f2Obj = f1.getAsJsonObject();
                JsonElement f2 = f2Obj.get("id");
                String y="";
            }
        }    
    }
    
    public String GetAPIData(String url){
        Request request = new Request.Builder().url(url).build();
    
        try (Response response = client.newCall(request).execute()) {
            if(response.isSuccessful() && response.body() != null) {
                String responseString =  response.body().string();
                return responseString;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Η σύνδεση για ανάκτηση δεδομένων απέτυχε.\n" + ex.getMessage(), "Σφάλμα σύνδεσης", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    private URL constructURL(String text){
        try
        {
            URL url = new URL(text);
            return url;
        }
        catch (MalformedURLException ex)
        {
            JOptionPane.showMessageDialog(null, "Η σύνδεση για ανάκτηση δεδομένων απέτυχε.", "Σφάλμα σύνδεσης", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
