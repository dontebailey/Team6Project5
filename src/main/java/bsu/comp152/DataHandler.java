package bsu.comp152;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DataHandler {

    private HttpClient dataGrabber;
    private String webLocation;

    public DataHandler(String webLocation) {
        dataGrabber = HttpClient.newHttpClient();
        this.webLocation = webLocation;
    }

    public ArrayList<songDataType> getData(){
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try {
            response=dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch(IOException e){
            System.out.println("Error connecting to network or site"); }
        catch (InterruptedException e){
            System.out.println("Connection to site broken"); }
        if (response == null ){
            System.out.println("Something went terribly wrong, ending program");
            System.exit(-1);
        }
        var usefulData = response.body();
        var jsonInterpreter = new Gson();
        var songData = jsonInterpreter.fromJson(usefulData, responseDataType.class);
        return songData.response.results;
    }

    public ArrayList<simDataType> getSim(){
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try {
            response=dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch(IOException e){
            System.out.println("Error connecting to network or site"); }
        catch (InterruptedException e){
            System.out.println("Connection to site broken"); }
        if (response == null ){
            System.out.println("Something went terribly wrong, ending program");
            System.exit(-1);
        }
        var usefulData = response.body();
        var jsonInterpreter = new Gson();
        var songData = jsonInterpreter.fromJson(usefulData, simResponseDataType.class);
        return songData.response.similarity_list;
    }

    class responseDataType {
        Boolean error;
        String message;
        objectDataType response;
    }
    class objectDataType {
        ArrayList<songDataType> results;
    }
    class songDataType {
        int id;
        String name;
        @Override
        public String toString() {
            return "Song Title: " + name ;  //only title for display later
        }
    }
    class simResponseDataType {
        Boolean error;
        String message;
        simObjectDataType response;
    }
    class simObjectDataType {
        ArrayList<simDataType> similarity_list;
    }
    class simDataType {
        int id;
        String artist_name;
        String song_name;
        String lyrics;
        String artist_url;
        String song_url;
        int index_id;
        double percentage;
        @Override
        public String toString() {
            return "Song Title: " + song_name ;  //only title for display later
        }
    }
    public ArrayList<ChuckNorrisModel.jokeCategories> getChuckData(){
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch(IOException e){
            System.out.println("Error connecting to network or site");
        }
        catch (InterruptedException e){
            System.out.println("Connection to site broken");
        }
        if (response == null ){
            System.out.println("Something went terribly wrong, ending program");
            System.exit(-1);
        }
        var usefulData = response.body();
        var jsonInterpreter = new Gson();
        var jokeData = jsonInterpreter.fromJson(usefulData, ChuckNorrisModel.jokeDataType.class);
        //System.out.println(recipeData.results);
        return jokeData.categories;

    }

    class jokeDataType{
        ArrayList<ChuckNorrisModel.jokeCategories> categories;
        String value;

        @Override
        public String toString(){
            return value;
        }
    }

    class jokeCategories{
        String animal;
        String career;
        String celebrity;
        String fashion;
        String food;
        String history;
        String money;
        String movie;
        String sport;
        String travel;


    }







}
