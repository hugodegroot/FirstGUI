package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

import java.lang.management.ThreadInfo;
import java.util.ArrayList;

public class SecondClass extends Stage {
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

    ArrayList<String> nietBeschikbaar = new ArrayList<String>();


    private TableView table = new TableView();

    Muziekant[] lijst;

    HBox y = new HBox();

    ListView<String> list = new ListView<>();
    ObservableList<Muziekant> items = FXCollections.observableArrayList();

    ListView<String> list2 = new ListView<>();
    ObservableList<String> items2 = FXCollections.observableArrayList();

    SecondClass(Muziekant[] muziekantenLijstTwee){

        Scene scene = new Scene(y, 300, 300);
        scene.getStylesheets().add("sample/StyleSheet.css");

        table.setEditable(true);

        this.lijst = muziekantenLijstTwee;

        for (int k = 0; k < names.length; k++) {
            items.add(lijst[k]);
            //System.out.println(lijst[k].getFirstName());
        }



        TableColumn firstNameCol = new TableColumn("Artiesten blok 1");
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Muziekant,String>("firstName")
        );

//        TableColumn secondNameCol = new TableColumn("Artiesten blok 2");
//        secondNameCol.setCellValueFactory(
//                new PropertyValueFactory<Muziekant,String>("secondName")
//        );




//        nietBeschikbaar.add("Adai O'Bryan (Puna)");
//        nietBeschikbaar.add("Bert Bieseman (Universal Music België)");



        table.setItems(items);
        table.getColumns().add(firstNameCol);
        //table.getColumns().add(secondNameCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.prefHeightProperty().bind(scene.heightProperty());
        table.prefWidthProperty().bind(scene.widthProperty());




        ScrollPane sp = new ScrollPane();
        sp.setContent(table);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);


        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(0, 0, 0, 0));
        vbox.getChildren().add(sp);

            firstNameCol.setCellFactory(new Callback<TableColumn<Muziekant, String>, TableCell<Muziekant, String>>() {
            @Override
            public TableCell<Muziekant, String> call(TableColumn<Muziekant, String> param) {
                return new TableCell<Muziekant, String>() {
                    @Override
                    protected void updateItem(String name, boolean vol) {
                        super.updateItem(name, vol);
                        if (vol) {
                            setText(null);
                            setStyle("");
                        } else {

                            setText(name);
                            Muziekant joch = getTableView().getItems().get(getIndex());
                            boolean ans = nietBeschikbaar.contains(joch.getFirstName());
                            if (ans) {
                                setStyle("-fx-background-color: red;");
                            } else {
                                setStyle("-fx-background-color: orange;");
                            }
                        }
                    }
                };
            }
        });

//        secondNameCol.setCellFactory(new Callback<TableColumn<Muziekant, String>, TableCell<Muziekant, String>>() {
//            @Override
//            public TableCell<Muziekant, String> call(TableColumn<Muziekant, String> param) {
//                return new TableCell<Muziekant, String>() {
//                    @Override
//                    protected void updateItem(String name, boolean vol) {
//                        super.updateItem(name, vol);
//                        if (vol) {
//                            setText(null);
//                            setStyle("");
//                        } else {
//
//                            setText(name);
//                            Muziekant joch = getTableView().getItems().get(getIndex());
//                            boolean ans = nietBeschikbaar.contains(joch.getSecondName());
//                            if (ans) {
//                                setStyle("-fx-background-color: red;");
//                            } else {
//                                setStyle("-fx-background-color: orange");
//                            }
//                        }
//                    }
//                };
//            }
//        });




        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {

            int o = 0;
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("this is called every 5 seconds on UI thread");
                table.scrollTo(o);
                o += 1;
                if(o == 30){
                    o = 0;
                }
            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();


//        for (int j = 0; j < firstList.length; j++) {
//            if(firstNameCol.getCellData(j).equals("Adai O'Bryan (Puna)")) {
//                firstNameCol.setCellFactory();setStyle("-fx-background-color: yellow");
//            }
//        }








//        this.lijst = muziekantenLijstTwee;
//
//
//        for (int k = 0; k < firstList.length; k++) {
//            items.add(lijst[k].getFirstName());
//
//        }
//
//        for (int k = 0; k < firstList.length; k++) {
//            items2.add(lijst[k].getFirstName());
//
//        }
//
//
//
//        list.setItems(items);
//        list.setId("Beschikbaar");
//        list2.setItems(items2);
//        list2.setId("vol");
//
//
//        //list.setStyle("-fx-control-inner-background: blue");
//
//        list.setPrefHeight(200);
//        list.setPrefWidth(600);
//
//
//        list2.setPrefHeight(200);
//        list2.setPrefWidth(600);

        y.getChildren().addAll(vbox);



        this.setScene(scene);
        this.setFullScreen(true);


        this.show();


    }
    public void setNaamRood(String naam) {
        nietBeschikbaar.add(naam);
        table.refresh();

    }

    public void scrollToBottom(){
        for(int i = 0; i < names.length; i++) {
            table.scrollTo(i);
        }
    }



}
