package aeroport;

import java.util.*;

public class Vol {

    private int num_vol;
    private Date dateDepart;
    private String heure_d, heure_a, depart,destination;
    List<Escale> escales = new ArrayList<>();
    private float prix;


    public Vol(int numVol, String depart,String destination){
        this.num_vol = numVol;
        this.depart = depart;
        this.destination = destination;
    }
    public int getNum_vol() {
        return num_vol;
    }

    public void setNum_vol(int num_vol) {
        this.num_vol = num_vol;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getHeure_d() {
        return heure_d;
    }

    public void setHeure_d(String heure_d) {
        this.heure_d = heure_d;
    }

    public String getHeure_a() {
        return heure_a;
    }

    public void setHeure_a(String heure_a) {
        this.heure_a = heure_a;
    }

    public List<Escale> getEscales() {
        return escales;
    }

    public void setEscales(List<Escale> escales) {
        this.escales = escales;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void ajouterEscale(Escale e){
        escales.add(e);    }

    public void supprimerEscale(Escale e){
        escales.remove(e);
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
