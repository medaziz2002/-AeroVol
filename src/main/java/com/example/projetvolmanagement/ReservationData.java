package com.example.projetvolmanagement;

import javafx.beans.property.*;

public class ReservationData {
    private final IntegerProperty idReservation;
    private final IntegerProperty idVolReservation;
    private final StringProperty destination;
    private final StringProperty dateVol;
    private final DoubleProperty prix;
    private final BooleanProperty status;

    public ReservationData(Integer idReservation, int idVolReservation, String destination, String dateVol, double prix, boolean status) {
        this.idReservation = new SimpleIntegerProperty(idReservation);
        this.idVolReservation = new SimpleIntegerProperty(idVolReservation);
        this.destination = new SimpleStringProperty(destination);
        this.dateVol = new SimpleStringProperty(dateVol);
        this.prix = new SimpleDoubleProperty(prix);
        this.status = new SimpleBooleanProperty(status);
    }

    public int getIdReservation() {
        return idReservation.get();
    }

    public IntegerProperty idReservationProperty() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation.set(idReservation);
    }

    public int getIdVolReservation() {
        return idVolReservation.get();
    }

    public IntegerProperty idVolReservationProperty() {
        return idVolReservation;
    }

    public void setIdVolReservation(int idVolReservation) {
        this.idVolReservation.set(idVolReservation);
    }

    public String getDestination() {
        return destination.get();
    }

    public StringProperty destinationProperty() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public String getDateVol() {
        return dateVol.get();
    }

    public StringProperty dateVolProperty() {
        return dateVol;
    }

    public void setDateVol(String dateVol) {
        this.dateVol.set(dateVol);
    }

    public double getPrix() {
        return prix.get();
    }

    public DoubleProperty prixProperty() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix.set(prix);
    }

    public boolean isStatus() {
        return status.get();
    }

    public BooleanProperty statusProperty() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status.set(status);
    }
}
