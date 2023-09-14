package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class BinanceAPI {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClients.createDefault();

        // Define the Binance API URL for the order book
        String apiUrl = "https://api.binance.com/api/v3/depth?symbol=BTCUSDT";

        HttpGet httpGet = new HttpGet(apiUrl);

        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonString = EntityUtils.toString(entity);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();

                // Access the order book data as needed
                System.out.println(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
