package bsu.comp152;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class ChuckNorrisModel {

    private HttpClient dataGrabber;
    private String webLocation;


    public ChuckNorrisModel(String webLocation){
        dataGrabber = HttpClient.newHttpClient();
        this.webLocation = webLocation;
    }

    public ArrayList<jokeCategories> getData(){
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
        var jokeData = jsonInterpreter.fromJson(usefulData, jokeDataType.class);
        //System.out.println(recipeData.results);
        return jokeData.categories;

    }

    class jokeDataType{
        ArrayList<jokeCategories> categories;
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
