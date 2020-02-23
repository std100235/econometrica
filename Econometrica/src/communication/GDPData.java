/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import static com.google.gson.internal.bind.TypeAdapters.URL;
import java.io.IOException;
import java.net.URL;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author rovas
 */
public class GDPData{
    
    private String apiKey;
    private String GDPURL = "https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json?api_key=" + apiKey;
    
    public GDPData(String apiKey){
        this.apiKey = apiKey;
    }
    
    public String GetGDPData()
    {
        GDPURL += apiKey;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(GDPURL).build();
    
        try (Response response = client.newCall(request).execute()) {
            if(response.isSuccessful() && response.body() != null) {
                String responseString =  response.body().string();
                System.out.println(responseString);
                return responseString;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    return null;
    }
    
}
