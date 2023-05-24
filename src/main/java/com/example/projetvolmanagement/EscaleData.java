package com.example.projetvolmanagement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EscaleData {
    private StringProperty idEscale;
    private StringProperty heureArrivee;
    private StringProperty heureDepart;
    private StringProperty ville;
    private StringProperty vol;
    private IntegerProperty durre;
    public EscaleData(String idEscale , String vol,String heureArrivee, String heureDepart, String ville,Integer durre) {
        this.idEscale=new SimpleStringProperty(idEscale);
        this.vol = new SimpleStringProperty(vol);
        this.heureArrivee = new SimpleStringProperty(heureArrivee);
        this.heureDepart = new SimpleStringProperty(heureDepart);
        this.ville = new SimpleStringProperty(ville);
        this.durre=new SimpleIntegerProperty(durre) ;
    }

    public EscaleData(String idEscale,String heureArrivee, String heureDepart, String ville) {
        this.idEscale=new SimpleStringProperty(idEscale);
        this.heureArrivee = new SimpleStringProperty(heureArrivee);
        this.heureDepart = new SimpleStringProperty(heureDepart);
        this.ville = new SimpleStringProperty(ville);
    }

    public EscaleData(String idEscale ,String heureArrivee, String heureDepart, String ville,Integer durre) {
        this.idEscale=new SimpleStringProperty(idEscale);
        this.heureArrivee = new SimpleStringProperty(heureArrivee);
        this.heureDepart = new SimpleStringProperty(heureDepart);
        this.ville = new SimpleStringProperty(ville);
        this.durre=new SimpleIntegerProperty(durre) ;
    }

    public Integer getDurre() {
        return durre.get();
    }

    public void setDuree(Integer durre) {
        this.durre.set(durre);
    }

    public IntegerProperty dureeProperty() {
        return durre;
    }


    public String getIdEscale() {
        return idEscale.get();
    }

    public void setIdEscale(String idEscale) {
        this.idEscale.set(idEscale);
    }

    public StringProperty idEscaleProperty() {
        return idEscale;
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

    public String getVille() {
        return ville.get();
    }

    public void setVille(String ville) {
        this.ville.set(ville);
    }

    public StringProperty villeProperty() {
        return ville;
    }

    public String getVol() {
        return vol.get();
    }

    public void setVol(String vol) {
        this.vol.set(vol);
    }

    public StringProperty volProperty() {
        return vol;
    }
}
