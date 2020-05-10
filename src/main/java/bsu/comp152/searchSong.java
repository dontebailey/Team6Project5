package bsu.comp152;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class searchSong implements Initializable {
    @FXML
    private TextField textfield;
    @FXML
    private ListView<DataHandler.songDataType> listview1;
    @FXML
    private ListView<DataHandler.simDataType> listview2;
    private DataHandler Model;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listview1.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<DataHandler.songDataType>() {
                    @Override
                    public void changed(ObservableValue<? extends DataHandler.songDataType> observable, DataHandler.songDataType oldValue, DataHandler.songDataType newValue) {
                        var song = listview1.getSelectionModel().getSelectedItem();
                        find_sim(song.id);
                    }
                }

        );
    }

    public void search() {
        var site = "https://searchly.asuarez.dev/api/v1/song/search";
        var params = "?query=" + textfield.getText();
        var query = site + params;
        Model = new DataHandler(query);
        var songList = Model.getData();
        ObservableList<DataHandler.songDataType> dataToShow = FXCollections.observableArrayList(songList);
        listview1.setItems(dataToShow);
    }

    public void find_sim(int id) {
        var site = "https://searchly.asuarez.dev/api/v1/similarity/by_song";
        var params = "?song_id=" + id;
        var query = site + params;
        Model = new DataHandler(query);
        var songList = Model.getSim();
        ObservableList<DataHandler.simDataType> dataToShow = FXCollections.observableArrayList(songList);
        listview2.setItems(dataToShow);
    }
}

