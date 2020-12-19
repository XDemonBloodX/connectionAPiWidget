package com.example.restservice;


import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@RestController
public class RoutingController {

    private JsonValueFormatVisitor.Base Json;

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public String get() {
        String text= "Hello on my api !\nFor use the api, here is routes:\n /insta\n /minecraft \n /pokemon \n /beer";
        return text;
    }
    @RequestMapping(value = "/insta",method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getWeather(@RequestParam(required = false) String pseudo) throws IOException {
        String theUrl = "https://instagram.com/"+pseudo+"/?__a=1";
        return getJSON(theUrl);

    }
    @RequestMapping(value = "/minecraft",method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getMinecraft(@RequestParam(required = false) String minecraft) throws IOException {
        String theUrl = "http://mcapi.us/server/status?ip="+minecraft+"&port=25565";
        return getJSON(theUrl);

    }
    @RequestMapping(value = "/pokemon",method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getPokemon(@RequestParam(required = false) String pokemon) throws IOException {
        String theUrl = "https://pokeapi.co/api/v2/pokemon/"+pokemon;
        return getJSON(theUrl);
    }
    @RequestMapping(value = "/beer",method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getBeer() throws IOException {
        String theUrl = "https://api.punkapi.com/v2/beers/random";
        return getJSON(theUrl);
    }

    private String getJSON(String theUrl) {
        StringBuilder content = new StringBuilder();

        try{
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }catch(Exception e) {
            System.out.print(e);
        }
        return content.toString();
    }
}