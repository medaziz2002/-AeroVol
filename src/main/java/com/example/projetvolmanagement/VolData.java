package com.example.projetvolmanagement;

import javafx.beans.property.*;

public class VolData {
    private StringProperty numVol;
    private StringProperty destination;
    private StringProperty heureArrivee;
    private StringProperty heureDepart;
    private IntegerProperty prix;
    private StringProperty dateVol;
    private StringProperty depart;

    private IntegerProperty nbEscale;

    public VolData(String numVol, String destination, String heureArrivee, String heureDepart, int prix, String dateVol,String depart) {
        this.numVol = new SimpleStringProperty(numVol);
        this.destination = new SimpleStringProperty(destination);
        this.heureArrivee = new SimpleStringProperty(heureArrivee);
        this.heureDepart = new SimpleStringProperty(heureDepart);
        this.prix = new SimpleIntegerProperty(prix);
        this.dateVol = new SimpleStringProperty(dateVol);
        this.depart=new SimpleStringProperty(depart);
    }


    public VolData(String numVol, String destination, String heureArrivee, String heureDepart, int prix, String dateVol,String depart,int nbEscale) {
        this.numVol = new SimpleStringProperty(numVol);
        this.destination = new SimpleStringProperty(destination);
        this.heureArrivee = new SimpleStringProperty(heureArrivee);
        this.heureDepart = new SimpleStringProperty(heureDepart);
        this.prix = new SimpleIntegerProperty(prix);
        this.dateVol = new SimpleStringProperty(dateVol);
        this.depart=new SimpleStringProperty(depart);
        this.nbEscale=new SimpleIntegerProperty(nbEscale);
    }
    public String getNumVol() {
        return numVol.get();
    }

    public void setNumVol(String numVol) {
        this.numVol.set(numVol);
    }

    public String getDepart() {
        return depart.get();
    }


    public void setDepart(String depart) {
        this.depart.set(depart);
    }


    public StringProperty departProperty() {
        return depart;
    }

    public StringProperty numVolProperty() {
        return numVol;
    }

    public String getDestination() {
        return destination.get();
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public StringProperty destinationProperty() {
        return destination;
    }

    public String getHeureArrivee() {
        return heureArrivee.get();
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee.set(heureArrivee);
    }

    public StringProperty heureArriveeProperty() {
        return heureArrivee;
    }

    public String getHeureDepart() {
        return heureDepart.get();
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart.set(heureDepart);
    }

    public StringProperty heureDepartProperty() {
        return heureDepart;
    }

    public int getPrix() {
        return prix.get();
    }

    public void setNbEscale(int nbEscale) {
        this.nbEscale.set(nbEscale);
    }

    public int getNbEscale() {
        return nbEscale.get();
    }

    public void setPrix(int prix) {
        this.prix.set(prix);
    }

    public IntegerProperty prixProperty() {
        return prix;
    }

    public String getDateVol() {
        return dateVol.get();
    }

    public void setDateVol(String dateVol) {
        this.dateVol.set(dateVol);
    }

    public StringProperty dateVolProperty() {
        return dateVol;
    }

    public boolean matchesKeyword(String keyword) {
        String lowerCaseKeyword = keyword.toLowerCase();
        return numVol.get().toLowerCase().contains(lowerCaseKeyword)
                || depart.get().toLowerCase().contains(lowerCaseKeyword)
                || destination.get().toLowerCase().contains(lowerCaseKeyword)
                || dateVol.get().toLowerCase().contains(lowerCaseKeyword);
        // Add more conditions if needed based on your data structure
    }
}
