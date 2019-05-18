package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    final String[] names = {"Adai O'Bryan (Puna)",
            "Adrian Muts (Full Spectrum, We Are E)",
            "Amir Charles (Sony Music)",
            "Andries van Wieren (3S Music Management)",
            "Bart van Liemt (The Missing Sync, Penniew From Heaven)",
            "Bert Bieseman (Universal Music België)",
            "Bodine Hordijk (NPO 3FM)",
            "Chris Moorman (Popronde)",
            "Eric van Holland (Spotify Benelux)",
            "Erwin Vogel (Pinguin Tune Support, Top Notch)",
            "Eva van de Vlasakker (Paradiso)",
            "Everaldo Pechler (Q-Factory)",
            "Flip van der Enden (Pinguin Radio, Conservatorium van Amsterdam, HKU)",
            "Fred van Kruining (Caroline Benelux)",
            "Gaétan van de Sande (TRIFECTA)",
            "Henkjan Onnink (Agents After All)",
            "Hugo Schaap (NPO 3FM)",
            "Jacco Toma (Kaiser Management)",
            "Jantine Heij",
            "Jasper van Vugt (OOR, Herman Brood Academie)",
            "Joris Regterschot (V2 Records)",
            "Klaas Knooihuizen (OOR, Noisey, Trouw)",
            "Marc Hofstede (The Ambassadors of Entertainment)",
            "Marcel Duzink (Phonic Management)",
            "Marije van Veen (Hot Topic Agency)",
            "Martijn Crama (Music United)",
            "Paul Ankersmit (Uncle P. Management & Bookings, LAB Music)",
            "Perquisite (componist, producer, manager)",
            "Peter Schaap (PIMP)",
            "Pien Feith (Friendly Fire)",
            "Robert Koole (FLUOR, Goomah Music)",
            "Ronald Keizer (BLiP Agency)",
            "Ruby van den Brink (Twist Agency)",
            "Sander Spriel (Snowstar Records)",
            "Tim Tóth (CTM)",
            "Timo Pisart (3voor12)"};

    Muziekant[] muziekantenLijst = new Muziekant[names.length];



    @Override
    public void start(Stage primaryStage){
        new FirstClass(muziekantenLijst);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
