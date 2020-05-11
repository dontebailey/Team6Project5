package bsu.comp152;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ChuckNorrisWindow {
    private DataHandler Model;
        @FXML
        private TextArea Joke;

        @FXML
        private Button Animal;
        @FXML
        private Button Career;
        @FXML
        private Button Celebrity;
        @FXML
        private Button Fashion;
        @FXML
        private Button Food;
        @FXML
        private Button History;
        @FXML
        private Button Money;
        @FXML
        private Button Movie;
        @FXML
        private Button Sport;
        @FXML
        private Button Travel;


        public void joke_animal(){
            var site = "https://api.chucknorris.io/jokes/random";
            var params = "?category=" + "animal";
            var query = site + params;
            Model = new DataHandler(query);
            var joke = Model.getChuckData();
            Joke.setText(joke);


        }

        public void joke_career() {
            var site = "https://api.chucknorris.io/jokes/random";
            var params = "?category=" + "career";
            var query = site + params;
            Model = new DataHandler(query);
            var joke = Model.getChuckData();
            Joke.setText(joke);

        }

        public void joke_celebrity() {
            var site = "https://api.chucknorris.io/jokes/random";
            var params = "?category=" + "celebrity";
            var query = site + params;
            Model = new DataHandler(query);
            var joke = Model.getChuckData();
            Joke.setText(joke);

        }

        public void joke_fashion() {
            var site = "https://api.chucknorris.io/jokes/random";
            var params = "?category=" + "fashion";
            var query = site + params;
            Model = new DataHandler(query);
            var joke = Model.getChuckData();
            Joke.setText(joke);

        }

        public void joke_food() {
            var site = "https://api.chucknorris.io/jokes/random";
            var params = "?category=" + "food";
            var query = site + params;
            Model = new DataHandler(query);
            var joke = Model.getChuckData();
            Joke.setText(joke);

        }

        public void joke_history() {
            var site = "https://api.chucknorris.io/jokes/random";
            var params = "?category=" + "history";
            var query = site + params;
            Model = new DataHandler(query);
            var joke = Model.getChuckData();
            Joke.setText(joke);

        }

        public void joke_money() {
            var site = "https://api.chucknorris.io/jokes/random";
            var params = "?category=" + "money";
            var query = site + params;
            Model = new DataHandler(query);
            var joke = Model.getChuckData();
            Joke.setText(joke);

        }

        public void joke_movie() {
            var site = "https://api.chucknorris.io/jokes/random";
            var params = "?category=" + "movie";
            var query = site + params;
            Model = new DataHandler(query);
            var joke = Model.getChuckData();
            Joke.setText(joke);

        }

        public void joke_sport() {
            var site = "https://api.chucknorris.io/jokes/random";
            var params = "?category=" + "sport";
            var query = site + params;
            Model = new DataHandler(query);
            var joke = Model.getChuckData();
            Joke.setText(joke);

        }

        public void joke_travel() {
            var site = "https://api.chucknorris.io/jokes/random";
            var params = "?category=" + "travel";
            var query = site + params;
            Model = new DataHandler(query);
            var joke = Model.getChuckData();
            Joke.setText(joke);

        }



    }


