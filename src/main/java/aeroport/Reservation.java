package aeroport;

public class Reservation {

    private int num_reservation;
    private Client client;
    private Vol vol;
    private String status="en attente";

    public int getNum_reservation() {
        return num_reservation;
    }

    public void setNum_reservation(int num_reservation) {
        this.num_reservation = num_reservation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void confirmer() {
        status= "confirmé";}

    public void refuser(){
        status= "refusé";
    }
}
