package aeroport;

public class Client {

    private String nom, prenom,email;
    private int id_client;
    private boolean passager;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public boolean isPassager() {
        return passager;
    }

    public void setPassager(boolean passager) {
        this.passager = passager;
    }
}
