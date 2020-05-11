package bsu.comp152;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = null;
        var loc = getClass().getResource("Main.fxml");
        try{
            root = FXMLLoader.load(loc);
        } catch(IOException e){
            System.out.println("Couldn't find FXML file");
        }
        Scene windowContents = new Scene(root);
        primaryStage.setScene(windowContents);
        primaryStage.show();

    }


    @FXML
    public void openChuckNorris(ActionEvent event){
        Parent root = null;
        var loc = getClass().getResource("ChuckNorris.fxml");
        try{
            root = FXMLLoader.load(loc);
        } catch(IOException e){
            System.out.println("Couldn't find FXML file");
        }
        Scene windowContents = new Scene(root, 600, 400);
        Stage chuckWindow = new Stage();
        chuckWindow.setScene(windowContents);
        chuckWindow.show();
    }
    @FXML
    public void openSongWindow(ActionEvent event){
        Parent root = null;
        var loc = getClass().getResource("searchSong.fxml");
        try {
            root = FXMLLoader.load(loc);
        } catch (IOException e) {
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        Scene windowContents = new Scene(root, 600, 400);
        Stage songWindow = new Stage();
        songWindow.setScene(windowContents);
        songWindow.setTitle("Song Search API");
        songWindow.show();
    }



}
