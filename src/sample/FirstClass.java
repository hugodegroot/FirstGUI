package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstClass extends Stage {

    final String[] firstList = {"Adai O'Bryan (Puna)",
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

//    final String[] secondList = {"Angelo Pertijs (Agents After All)",
//            "Chris Moorman (Popronde)",
//            "Daniël Nagelkerke (WOLF Bookings)",
//            "Dave Gans (Puna)",
//            "Elles van Aarle (Dox Records)",
//            "Erik Timmerman (ET Plugger)",
//            "Gaétan van de Sande (TRIFECTA)",
//            "Huub Reijnders (Hooray For Music)",
//            "Ilana Goldstoff (Sizzer Amsterdam)",
//            "Jaco van der Waal (Agents After All)",
//            "Jelle Stavasius (V2 Records Benelux)",
//            "Job Smit (Caroline Benelux)",
//            "Jurriaan Sielcken",
//            "Leo Hoeksema (Zwaardvis Music)",
//            "Martijn Mannak (Atlas Agency)",
//            "Martijn Swier (Endless Music)",
//            "Max van Bossé (Paradiso)",
//            "Menno Visser (3voor12)",
//            "Mischa van den Ouweland (Popronde)",
//            "Mitchell Quitz (Rock’n’Roll Highschool)",
//            "Ruby van den Brink (Twist Agency)",
//            "Stefan Bruinsma (AT Bookings)",
//            "Stefan Hayes (Bertus Distributie, Butler Records)",
//            "Steijn Koeijvoets (3S Music Management)",
//            "Tess Gaerthé (Cloud 9 Music, Downtown Music Benelux)",
//            "Ties Timmers (Radar Agency)",
//            "Tom Driessen (Sizzer)",
//            "",
//            "",
//            ""};

    TextField textField = new TextField();
    Button veranderKleur = new Button("verander Kleur");

    String naam;

    Button openOther = new Button("Open other Stage");
    Button makeTrue = new Button("Vol");
    HBox x = new HBox();

    Muziekant[] lijst;
    SecondClass secondClass;

    FirstClass(Muziekant[] muziekantenLijst){

        this.lijst = muziekantenLijst;

        for (int i = 0; i < firstList.length; i++) {
            this.lijst[i] = new Muziekant(firstList[i]);
        }

        HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(0, 0, 0, 0));
        hbox.getChildren().addAll(textField, veranderKleur);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(0, 0, 0, 0));
        vbox.getChildren().addAll(openOther, hbox);

        x.getChildren().addAll(vbox);
        this.setScene(new Scene(x, 300, 300));
        this.show();

        openOther.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                secondClass = new SecondClass(lijst);
            }//end action
        });

        makeTrue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                for (int i = 0; i < firstList.length; i++) {
                    System.out.println(lijst[i].getFirstName());
                }
            }//end action
        });

        veranderKleur.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if(textField.getText() != null && !textField.getText().isEmpty()) {
                    naam = textField.getText();
                    secondClass.setNaamRood(naam);
                }
            }//end action
        });
    }
}
