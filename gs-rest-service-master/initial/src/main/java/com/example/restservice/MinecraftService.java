/*package com.example.restservice;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

public class MinecraftService {

    private OkHttpClient client;
    private Response response;
    private String minecraftIP;
    private int minecraftPort;

    public String getminecraftIP() {
        return minecraftIP;
    }

    public int getminecraftPort() {
        return minecraftPort;
    }
    public void setMinecraftIP(String minecraftIP) {
        this.minecraftIP = minecraftIP;
    }
    public void setMinecraftPort(int minecraftPort) {
        this.minecraftPort = minecraftPort;
    }

    public JSONObject getMinecraftServer(){
        client = new OkHttpClient();  //using OKHTTP dependency . You have to add this mannually form OKHTTP website
        Request request = new Request.Builder()
                .url("http://mcapi.us/server/status?ip="+getminecraftPort()+"&port="+getminecraftPort())
                .build();

        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        }catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray returnMinecraftPlayer() throws JSONException {
        JSONArray minecraftJsonArray = getMinecraftServer().getJSONArray("players");
        return minecraftJsonArray;
    }
    public JSONArray returnMinecraftServer() throws JSONException {
        JSONArray minecraftServerJsonArray = getMinecraftServer().getJSONArray("server");
        return minecraftServerJsonArray;
    }

}
*/