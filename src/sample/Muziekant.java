package sample;

import javafx.beans.property.SimpleStringProperty;

public class Muziekant {
    public SimpleStringProperty firstName;
//    public SimpleStringProperty secondName;

    public Muziekant(String fName) {
        this.firstName = new SimpleStringProperty(fName);
//        this.secondName = new SimpleStringProperty(sName);
    }

    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String fName) {
        firstName.set(fName);
    }
//    public String getSecondName() {
//        return secondName.get();
//    }
//    public void setSecondName(String sName) {
//        secondName.set(sName);
//    }
}
