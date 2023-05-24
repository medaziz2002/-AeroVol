package com.example.projetvolmanagement;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import aeroport.Vol;
import com.itextpdf.text.*;

import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;



public class dashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;
    @FXML
    private TableView<VolData> user_vols_tableview;

    @FXML
    private TableColumn<VolData, String> id_vol;

    @FXML
    private TableColumn<VolData, String> depart_vol;

    @FXML
    private TableColumn<VolData, String> destination_vol;

    @FXML
    private TableColumn<VolData, String> date_depart_vol;

    @FXML
    private TableColumn<VolData, String> heure_depart_vol;

    @FXML
    private TableColumn<VolData, String> heure_arrivee_vol;

    @FXML
    private TableColumn<VolData, Integer> prix_vol;

    @FXML
    private TableColumn<VolData, Integer> escales_vol;

    @FXML
    private AnchorPane admin_gestion_vols;

    @FXML
    private AnchorPane sidebar_client;

    @FXML
    private AnchorPane user_liste_vols;

    @FXML
    private AnchorPane user_reservations;

    @FXML
    private AnchorPane user_listes_escales;

    @FXML
    private AnchorPane client_interface;


    @FXML
    private AnchorPane admin_gestion_clients;

    @FXML
    private AnchorPane admin_gestion_escales;

    @FXML
    private Button close;

    @FXML
    private Button minimize;
    @FXML
    private Button accepter_client;

    @FXML
    private Label username;


    @FXML
    private Label home_totale_revenu ;
    @FXML
    private Label username1;

    @FXML
    private Label email;

    @FXML
    private Button home_btn;

    @FXML
    private Button gestion_vols;

    @FXML
    private Button gestion_escales;


    @FXML
    private Button vols_reservees;

    @FXML
    private Button listes_vols;


    @FXML
    private Button gestion_clients;
    @FXML
    private Button logout;


    @FXML
    private TableView<EscaleData> user_escales_tableview;

    @FXML
    private TableColumn<EscaleData, String> heure_arrivee;

    @FXML
    private TableColumn<EscaleData, String> heure_depart;

    @FXML
    private TableColumn<EscaleData, String> ville;


    @FXML
    private AnchorPane home;

    @FXML
    private Label home_totalEmployees;

    @FXML
    private Label home_totalPresents;

    @FXML
    private Label home_totalInactiveEm;

    @FXML
    private BarChart<?, ?> home_chart;

    @FXML
    private AnchorPane addEmployee_form;

    @FXML
    private TableView<VolData> admin_vols_tableview;
    @FXML
    private TableView<EscaleData> escales_tableview;

    @FXML
    private TextField rechercher_vol1;
    @FXML
    private TextField recherche_vol;


    @FXML
    private TextField addEmployee_employeeID;

    @FXML
    private TextField champs_id_vol;

    @FXML
    private TextField champs_prix_vol;
    @FXML
    private TextField champs_destination_vol;


    @FXML
    private TableView<ReservationData> user_reservations_tableview;

    @FXML
    private TableColumn<ReservationData, Integer> id_reservation;

    @FXML
    private TableColumn<ReservationData, Integer> id_vol_reservation;

    @FXML
    private TableColumn<ReservationData, String> destination;

    @FXML
    private TableColumn<ReservationData, LocalDate> date_vol;

    @FXML
    private TableColumn<ReservationData, Double> prix;

    @FXML
    private TableColumn<ReservationData, String> status;


    @FXML
    private TextField champs_herue_arrivee;

    @FXML
    private TextField champs_heure_depart;

    @FXML
    private DatePicker champs_date_vol;
    @FXML
    private TextField   champs_depart_vol;
    @FXML
    private ComboBox<?> addEmployee_gender;

    @FXML
    private TextField addEmployee_phoneNum;

    @FXML
    private ComboBox<?> addEmployee_position;

    @FXML
    private ImageView addEmployee_image;

    @FXML
    private Button addEmployee_importBtn;

    @FXML
    private Button addEmployee_addBtn;

    @FXML
    private Button addEmployee_updateBtn;

    @FXML
    private Button addEmployee_deleteBtn;

    @FXML
    private Button addEmployee_clearBtn;

    @FXML
    private Button user_escales_btn;

    @FXML
    private AnchorPane salary_form;

    @FXML
    private AnchorPane admin_interface;


    @FXML
    private TextField salary_employeeID;

    @FXML
    private Label salary_firstName;

    @FXML
    private Label salary_lastName;

    @FXML
    private Label salary_position;

    @FXML
    private TextField salary_salary;

    @FXML
    private Button salary_updateBtn;

    @FXML
    private Button salary_clearBtn;

     @FXML
     private Button   ajouter_escale;

     @FXML
     private Button    supprimer_escale;

    @FXML
    private Button    annuler_escale;

    @FXML
    private TableColumn<VolData, String> id_vol1;

    @FXML
    private TableColumn<VolData, String> depart_vol1;

    @FXML
    private TableColumn<VolData, String> destination_vol1;

    @FXML
    private TableColumn<VolData, String> date_vol1;


    @FXML
    private TableColumn<VolData, String> heure_depart_vol1;

    @FXML
    private TableColumn<VolData, String> heure_arrivee_vol1;

    @FXML
    private TableColumn<VolData, String> prix_vol1;
    @FXML
    private ComboBox<String> volComboBox;
    @FXML
    private ComboBox<String> volComboBox1;

    @FXML
    private TextField champs_numero_escale;

    @FXML
    private TextField champs_heure_arrivee_escale;

    @FXML
    private TextField champs_heure_depart_escale;


    @FXML
    private TextField champs_ville_escale;


    @FXML
    private TableColumn<EscaleData, String> vol_escale;

    @FXML
    private TableColumn<EscaleData, String> heure_arrivee_escale1;

    @FXML
    private TableColumn<EscaleData, String> heure_depart_escale1;

    @FXML
    private TableColumn<EscaleData, String> ville_escale1;
    @FXML
    private TableColumn<EscaleData, Integer> duree1;

    @FXML
    private TableColumn<EscaleData, Integer> durre;

    @FXML
    private Label home_pays;

    @FXML
    private Label  home_totale_clients;

//ligne
    @FXML
    private TableView<ReservationData> gestion_clients_tableview;

    @FXML
    private TableColumn<ReservationData, String> id_reservation1;

    @FXML
    private TableColumn<ReservationData, String> nom_client;

    @FXML
    private TableColumn<ReservationData, String> destination_reservation;

    @FXML
    private TableColumn<ReservationData, String> date_vol_reservation;

    @FXML
    private TableColumn<ReservationData, String> status_reservation;

    // Définissez les autres identifiants nécessaires pour les autres composants
    @FXML
    private TextField id_escale;
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    public void homeTotalClients() {
        String sql = "SELECT COUNT(client_id) AS totalClients FROM reservation WHERE status = true";

        connect = database.connectDb();
        int totalClients = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                totalClients = result.getInt("totalClients");
            }

            home_totale_clients.setText(String.valueOf(totalClients));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void homeTotalRevenue() {
        String sql = "SELECT SUM(v.prix) AS totalRevenue " +
                "FROM vol v, reservation r " +
                "WHERE r.vol_num_vol = v.num_vol " +
                "AND r.status = true " +
                "AND YEAR(v.dateDepart) = YEAR(CURDATE())";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.connectDb();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            double totalRevenue = 0;

            if (resultSet.next()) {
                totalRevenue = resultSet.getDouble("totalRevenue");
            }

            home_totale_revenu.setText(String.valueOf(totalRevenue));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources de la base de données
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void homePaysLaPlusVisite() {
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Ajouter 1 car les mois sont indexés à partir de 0 dans Calendar

        String sql = "SELECT destination, COUNT(*) AS visits " +
                "FROM vol " +
                "JOIN reservation ON reservation.vol_num_vol = vol.num_vol " +
                "WHERE reservation.status = true AND MONTH(vol.dateDepart) = ? " +
                "GROUP BY destination " +
                "ORDER BY visits DESC " +
                "LIMIT 1";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.connectDb();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, currentMonth); // Passer la valeur du mois actuel au paramètre de la requête
            resultSet = statement.executeQuery();

            String paysPlusVisite = "";

            if (resultSet.next()) {
                paysPlusVisite = resultSet.getString("destination");
            }

            home_pays.setText(paysPlusVisite);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources de la base de données
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void homeChart() {

        home_chart.getData().clear();

        String sql = "SELECT dateDepart, COUNT(*) FROM vol GROUP BY dateDepart ORDER BY TIMESTAMP(dateDepart) ASC LIMIT 7";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    public void getVolsFromDatabase() throws SQLException {
        String sql = "SELECT * FROM vol";
        connect = database.connectDb();
        ObservableList<String> volList = FXCollections.observableArrayList();
        ObservableList<Vol> volList1 = FXCollections.observableArrayList();

        try {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String numVol = resultSet.getString("num_vol");
                String depart = resultSet.getString("depart");
                String destination = resultSet.getString("destination");
                int numVol1 = resultSet.getInt("num_vol");
                String depart1 = resultSet.getString("depart");
                String destination1 = resultSet.getString("destination");

                Vol flight = new Vol(numVol1, depart, destination);
                volList1.add(flight);
                volList.add(numVol + " - " + depart + " - " + destination);

            }
            ObservableList<String> volStringList = FXCollections.observableArrayList();
            for (Vol vol : volList1) {
                String volString = vol.getNum_vol() + " - " + vol.getDepart() + " - " + vol.getDestination();
                volStringList.add(volString);
            }
            volComboBox.getItems().clear();
            volComboBox.getItems().addAll(volList);
            volComboBox1.getItems().clear();
            volComboBox1.setItems(volStringList);

        } catch (SQLException e) {
            // Gérer l'erreur
            e.printStackTrace();
        }


    }

/*
        volComboBox.setOnAction(event -> {
            VolData selectedVol = volComboBox.getValue(); // Récupérer le vol sélectionné
            if (selectedVol != null) {
                String volId = selectedVol.getNumVol(); // Récupérer l'ID du vol
                // Enregistrer l'ID du vol dans la table des escales ou effectuer toute autre opération nécessaire
                champs_numero_escale.setText(volId); // Par exemple, définir l'ID du vol dans le champ de texte champs_numero_escale
            }
        });*/



public void addVolAdd() {
    // Obtenir la date actuelle
    Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

    String sql = "INSERT INTO vol "
            + "(num_vol, dateDepart, heure_d, heure_a, prix, destination,depart) "
            + "VALUES (?, ?, ?, ?, ?, ?,?)";

    connect = database.connectDb();

    try {
        Alert alert;
        // Vérifier si les champs requis sont vides ou non sélectionnés
        if (champs_id_vol.getText().isEmpty()
                || champs_date_vol.getValue() == null
                || champs_herue_arrivee.getText().isEmpty()
                || champs_heure_depart.getText().isEmpty()
                || champs_prix_vol.getText().isEmpty()
                || champs_depart_vol.getText().isEmpty()
                || champs_destination_vol.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required fields");
            alert.showAndWait();
        } else {
            // Vérifier si le numéro de vol existe déjà dans la base de données
            String check = "SELECT num_vol FROM vol WHERE num_vol = '"
                    + champs_id_vol.getText() + "'";

            statement = connect.createStatement();
            result = statement.executeQuery(check);

            if (result.next()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vol number: " + champs_id_vol.getText() + " already exists!");
                alert.showAndWait();
            } else {
                // Convertir le prix en entier
                int prixVol = Integer.parseInt(champs_prix_vol.getText());

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, champs_id_vol.getText());
                prepare.setDate(2, sqlDate);
                prepare.setString(3, champs_heure_depart.getText());
                prepare.setString(4, champs_herue_arrivee.getText());
                prepare.setInt(5, prixVol);
                prepare.setString(6, champs_destination_vol.getText());
                prepare.setString(7, champs_depart_vol.getText());
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                // Réinitialiser les champs après l'ajout
                champs_id_vol.setText("");
                champs_date_vol.setValue(null);
                champs_heure_depart.setText("");
                champs_herue_arrivee.setText("");
                champs_prix_vol.setText("");
                champs_destination_vol.setText("");
                champs_depart_vol.setText("");
                addVolShowListData();
                homeChart();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void addVolUpdate() {
        // Récupérer les valeurs des champs
        String numVol = champs_id_vol.getText();
        LocalDate dateDepart = champs_date_vol.getValue();
        String heureDepart = champs_heure_depart.getText();
        String heureArrivee = champs_herue_arrivee.getText();
        String prix = champs_prix_vol.getText();
        String destination = champs_destination_vol.getText();
        String depart=champs_depart_vol.getText();
        // Vérifier si tous les champs sont remplis
        if (numVol.isEmpty() || dateDepart == null || heureDepart.isEmpty()
                || heureArrivee.isEmpty() || prix.isEmpty() || destination.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields");
            alert.showAndWait();
            return;
        }

        // Effectuer les opérations de mise à jour
        try {
            // Connexion à la base de données (à adapter selon votre code)
            Connection connection = database.connectDb();

            // Construction de la requête SQL d'update
            String sql = "UPDATE vol SET dateDepart = ?, heure_d = ?, heure_a = ?, prix = ?, destination = ? , depart=? WHERE num_vol = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(dateDepart));
            statement.setString(2, heureDepart);
            statement.setString(3, heureArrivee);
            statement.setString(4, prix);
            statement.setString(5, destination);
            statement.setString(6, depart);
            statement.setString(7, numVol);

            // Exécution de la requête
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Vol successfully updated!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Failed to update vol. Please check the provided information.");
                alert.showAndWait();
            }

            // Fermeture de la connexion et réinitialisation des champs
            statement.close();
            connection.close();
            addVolReset();

            // Actualisation de l'affichage de la liste des vols
            addVolShowListData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addVolDelete() {
        // Récupérer la valeur du champ numVol
        String numVol = champs_id_vol.getText();

        // Vérifier si le champ numVol est rempli
        if (numVol.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter the vol ID");
            alert.showAndWait();
            return;
        }

        // Effectuer les opérations de suppression
        try {
            // Connexion à la base de données (à adapter selon votre code)
            Connection connection = database.connectDb();

            // Construction de la requête SQL de suppression
            String sql = "DELETE FROM vol WHERE num_vol = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, numVol);

            // Exécution de la requête
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Vol successfully deleted!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Failed to delete vol. Please check the vol ID.");
                alert.showAndWait();
            }

            // Fermeture de la connexion et réinitialisation des champs
            statement.close();
            connection.close();
            addVolReset();

            // Actualisation de l'affichage de la liste des vols
            addVolShowListData();

        }
        catch (SQLIntegrityConstraintViolationException e) {
            // Handle the exception here
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Il faut d'abord supprimer les réservations de ce vol.");
            alert.showAndWait();
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void addVolReset() {

        champs_id_vol.setText("");
        champs_date_vol.setValue(null);
        champs_heure_depart.setText("");
        champs_herue_arrivee.setText("");
        champs_prix_vol.setText("");
        champs_depart_vol.setText("");
        champs_destination_vol.setText("");
    }

     /*public void addVolSearch() {
        FilteredList<VolData> filter = new FilteredList<>(addVolList, e -> true);

        rechercher_vol1.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            filter.setPredicate(predicateVolData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateVolData.getNumVol().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateVolData.getDestination().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateVolData.getHeureArrivee().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateVolData.getPrix()).contains(searchKey)) {
                    return true;
                } else {
                    // Check date of vol
                    LocalDate dateVol = LocalDate.parse(predicateVolData.getDateVol(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String formattedDateVol = dateVol.format(dateFormatter);
                    if (formattedDateVol.contains(searchKey)) {
                        return true;
                    }
               }

                return false;
            });
        });

        SortedList<VolData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(admin_vols_tableview.comparatorProperty());
        admin_vols_tableview.setItems(sortList);
    }*/


    @FXML
    private void handleSearch(KeyEvent event) {
        String keyword = ((TextField) event.getSource()).getText();
        ObservableList<VolData> filteredList = searchVolData(keyword);
        admin_vols_tableview.setItems(filteredList);
    }

    private ObservableList<VolData> searchVolData(String keyword) {
        ObservableList<VolData> filteredList = FXCollections.observableArrayList();
        for (VolData vol : addVolList) {
            if (vol.matchesKeyword(keyword)) {
                filteredList.add(vol);
            }
        }
        return filteredList;
    }


    public ObservableList<VolData> addVolListData() {
        ObservableList<VolData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM vol";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                VolData vol = new VolData(
                        result.getString("num_vol"),
                        result.getString("destination"),
                        result.getString("heure_a"),
                        result.getString("heure_d"),
                        result.getInt("prix"),
                        result.getString("dateDepart"),
                        result.getString("depart")
                );

                listData.add(vol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }


    public ObservableList<VolData> addVolListCountEscale() {
        ObservableList<VolData> listData = FXCollections.observableArrayList();
        String sql = "SELECT COUNT(e.id_escale) AS nbEscale, v.num_vol, v.dateDepart, v.heure_a, v.heure_d, v.prix, v.depart, v.destination " +
                "FROM vol v LEFT JOIN escale e ON v.num_vol = e.id_vol " +
                "GROUP BY v.num_vol";


        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();


            while (result.next()) {
                Integer escale=result.getInt("nbEscale");
                System.out.println("le depart"+result.getString("dateDepart"));
                VolData vol = new VolData(
                        result.getString("num_vol"),
                        result.getString("destination"),
                        result.getString("heure_a"),
                        result.getString("heure_d"),
                        result.getInt("prix"),
                        result.getString("dateDepart"),
                        result.getString("depart"),
                        escale

                );

                listData.add(vol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    public ObservableList<ReservationData> getReservationDataList() {
        ObservableList<ReservationData> listData = FXCollections.observableArrayList();
        String sql = "SELECT r.num_reservation, r.vol_num_vol, v.destination, v.dateDepart, r.status, v.prix " +
                "FROM vol v JOIN reservation r ON r.vol_num_vol = v.num_vol " +
                "JOIN users u ON r.client_id = u.user_id and u.user_id=?";




        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, getData.getUserId());
            result = prepare.executeQuery();

            while (result.next()) {
                ReservationData reservation = new ReservationData(
                        result.getInt("num_reservation"),
                        result.getInt("vol_num_vol"),
                        result.getString("destination"),
                        result.getString("dateDepart"),
                        result.getDouble("prix"),
                        result.getBoolean("status")
                );

                listData.add(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

//recherche reservation par vol************
private ObservableList<ReservationData> filterReservationsByFlight(int flightId) {
    ObservableList<ReservationData> filteredList = FXCollections.observableArrayList();
    reservationList = getReservationDataList();
    for (ReservationData reservation : reservationList) {
        if (reservation.getIdVolReservation() == flightId) {
            filteredList.add(reservation);
        }
    }
    return filteredList;
}


    @FXML
    private void addEmployeeSelect() {
        VolData selectedVol = admin_vols_tableview.getSelectionModel().getSelectedItem();
        if (selectedVol != null) {
            champs_id_vol.setText(selectedVol.getNumVol());
            champs_destination_vol.setText(selectedVol.getDestination());
            String dateVol = selectedVol.getDateVol();
            if (dateVol != null && !dateVol.isEmpty()) {
                LocalDate localDate = LocalDate.parse(dateVol);
                champs_date_vol.setValue(localDate);
            } else {
                champs_date_vol.setValue(null);
            }

            champs_heure_depart.setText(selectedVol.getHeureDepart());
            champs_herue_arrivee.setText(selectedVol.getHeureArrivee());
            champs_prix_vol.setText(Integer.toString(selectedVol.getPrix()));
            champs_depart_vol.setText(selectedVol.getDepart());
        }
    }

    private ObservableList<VolData> addVolList;

    public void addVolShowListData() {
        addVolList = addVolListData();

        id_vol1.setCellValueFactory(new PropertyValueFactory<>("numVol"));
        depart_vol1.setCellValueFactory(new PropertyValueFactory<>("depart"));
        destination_vol1.setCellValueFactory(new PropertyValueFactory<>("destination"));
        date_vol1.setCellValueFactory(new PropertyValueFactory<>("dateDepart"));
        heure_depart_vol1.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));
        heure_arrivee_vol1.setCellValueFactory(new PropertyValueFactory<>("heureArrivee"));
        prix_vol1.setCellValueFactory(new PropertyValueFactory<>("prix"));
        date_vol1.setCellValueFactory(new PropertyValueFactory<>("dateVol"));

        admin_vols_tableview.setItems(addVolList);
    }

    private ObservableList<ReservationData> reservationList;


// ...

    public void addReservationShowListData() {
        reservationList = getReservationDataList();

        id_reservation.setCellValueFactory(new PropertyValueFactory<>("idReservation"));
        id_vol_reservation.setCellValueFactory(new PropertyValueFactory<>("idVolReservation"));
        destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        date_vol.setCellValueFactory(new PropertyValueFactory<>("dateVol"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));

        // Appliquer la Callback personnalisée pour la colonne "Status"
        status.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ReservationData, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ReservationData, String> cellData) {
                BooleanProperty statusProperty = cellData.getValue().statusProperty();
                String statusText = statusProperty.get() ? "Accepté" : "Pas encore";
                return new ReadOnlyStringWrapper(statusText);
            }
        });

        user_reservations_tableview.setItems(reservationList);
    }


    private ObservableList<VolData> volDataList;

    public void populateVolTableView() {
        volDataList = addVolListCountEscale();

        id_vol.setCellValueFactory(new PropertyValueFactory<>("numVol"));
        depart_vol.setCellValueFactory(new PropertyValueFactory<>("depart"));
        destination_vol.setCellValueFactory(new PropertyValueFactory<>("destination"));
        date_depart_vol.setCellValueFactory(new PropertyValueFactory<>("dateVol"));
        heure_depart_vol.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));
        heure_arrivee_vol.setCellValueFactory(new PropertyValueFactory<>("heureArrivee"));
        prix_vol.setCellValueFactory(new PropertyValueFactory<>("prix"));
        escales_vol.setCellValueFactory(new PropertyValueFactory<>("nbEscale"));

        user_vols_tableview.setItems(volDataList);
    }

    public void supprimerReservation() {
        // Récupérer la réservation sélectionnée dans la table
        ReservationData selectedReservation = user_reservations_tableview.getSelectionModel().getSelectedItem();
        if (selectedReservation == null) {
            // Aucune réservation sélectionnée, afficher une alerte d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Aucune réservation sélectionnée");
            alert.setContentText("Veuillez sélectionner une réservation à supprimer.");
            alert.showAndWait();
            return;
        }

        // Récupérer l'ID de la réservation sélectionnée
        int reservationId = selectedReservation.getIdReservation();

        // Supprimer la réservation de la base de données
        String deleteQuery = "DELETE FROM reservation WHERE num_reservation = ?";
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(deleteQuery);
            prepare.setInt(1, reservationId);
            int rowsAffected = prepare.executeUpdate();

            if (rowsAffected > 0) {
                // La réservation a été supprimée avec succès
                System.out.println("Réservation supprimée avec succès !");
                // Actualiser la liste des réservations affichées dans la table
                reservationList.remove(selectedReservation);
            } else {
                // Échec de suppression de la réservation
                System.out.println("Échec de suppression de la réservation.");
            }
            addReservationShowListData();
        } catch (Exception e) {
            e.printStackTrace();
            // Afficher un message d'erreur ou effectuer une autre action appropriée en cas d'échec
        }
    }

    public void defaultNav() {
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
    }

    public void displayUsername() {
        String userEmail = getData.getEmail();
        username.setText(getData.login_username);
        username1.setText(getData.login_username);
        Integer userId=getData.getUserId();

        System.out.println("Le username est : " + getData.login_username);
        System.out.println("L'e-mail est : " + userEmail);
        System.out.println("le id "+userId);
    }

    public void switchForm(ActionEvent event) {
        String role = getData.getRole();




        if (event.getSource() == home_btn) {
            home.setVisible(true);
            admin_gestion_vols.setVisible(false);
            admin_gestion_escales.setVisible(false);
            admin_gestion_clients.setVisible(false);
            client_interface.setVisible(false);
            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            gestion_escales.setStyle("-fx-background-color:transparent");
            gestion_clients.setStyle("-fx-background-color:transparent");
            gestion_vols.setStyle("-fx-background-color:transparent");

            homeChart();

        } else if (event.getSource() == gestion_vols) {
            home.setVisible(false);
            admin_gestion_vols.setVisible(true);
            admin_gestion_escales.setVisible(false);
            admin_gestion_clients.setVisible(false);
            client_interface.setVisible(false);
            gestion_vols.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            home_btn.setStyle("-fx-background-color:transparent");
            gestion_escales.setStyle("-fx-background-color:transparent");
            gestion_clients.setStyle("-fx-background-color:transparent");
       //     salary_btn.setStyle("-fx-background-color:transparent");

            //addVolSearch();

        } else if (event.getSource() == gestion_clients) {
            home.setVisible(false);
            admin_gestion_vols.setVisible(false);
            admin_gestion_escales.setVisible(false);
            admin_gestion_clients.setVisible(true);
            client_interface.setVisible(false);
          //  salary_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            home_btn.setStyle("-fx-background-color:transparent");
            gestion_clients.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            gestion_escales.setStyle("-fx-background-color:transparent");
            gestion_vols.setStyle("-fx-background-color:transparent");

        }else if(event.getSource()==gestion_escales)
        {

            try {
                getVolsFromDatabase();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            home.setVisible(false);
            admin_gestion_vols.setVisible(false);
            admin_gestion_escales.setVisible(true);
            admin_gestion_clients.setVisible(false);
            client_interface.setVisible(false);
            //  salary_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            gestion_vols.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            gestion_escales.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            gestion_clients.setStyle("-fx-background-color:transparent");


        }


       if (event.getSource() == listes_vols) {

           try {
               getVolsFromDatabase();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
           user_reservations.setVisible(false);
           user_liste_vols.setVisible(true);
           user_listes_escales.setVisible(false);

           listes_vols.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
           vols_reservees.setStyle("-fx-background-color:transparent");


           homeChart();

       } else if (event.getSource() == vols_reservees) {
           user_reservations.setVisible(true);
           user_liste_vols.setVisible(false);
           user_listes_escales.setVisible(false);

           vols_reservees.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
           listes_vols.setStyle("-fx-background-color:transparent");
           //     salary_btn.setStyle("-fx-background-color:transparent");

           //addEmployeeGendernList();
           //addEmployeePositionList();
           //addVolSearch();

       } else if (event.getSource() == user_escales_btn ) {
           if( VoirEscale() != null){
            populateEscaleTable();
           user_reservations.setVisible(false);
           user_liste_vols.setVisible(false);
           user_listes_escales.setVisible(true);
           //  salary_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
           listes_vols.setStyle("-fx-background-color:transparent");
           vols_reservees.setStyle("-fx-background-color:transparent");}

       }
   }


    public void addEscale() {

        admin_vols_tableview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                VolData selectedProduit = admin_vols_tableview.getSelectionModel().getSelectedItem();
                id_vol1.setText(selectedProduit.numVolProperty().get());
                id_vol1.setId(selectedProduit.getNumVol());
            }
        });

        String id=volComboBox.getValue();
        System.out.println("le code est"+id);
        String[] parts = id.split(" - ");
        String extractedValue = parts[0];
        if (id != null) {

            Integer numVol = Integer.parseInt(extractedValue);
            System.out.println("le code2 est"+numVol);
            // Récupérer les autres valeurs des champs
            String heureArrivee = champs_heure_arrivee_escale.getText();
            String heureDepart = champs_heure_depart_escale.getText();
            String ville = champs_ville_escale.getText();

            // Effectuer l'insertion dans la base de données
            String sql = "INSERT INTO escale (id_escale, heure_d, heure_a, ville, id_vol) VALUES (?, ?, ?, ?, ?)";

            try {
                connect = database.connectDb();
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, champs_numero_escale.getText());
                prepare.setString(2, heureDepart);
                prepare.setString(3, heureArrivee);
                prepare.setString(4, ville);
                prepare.setInt(5, numVol);
                prepare.executeUpdate();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                // Réinitialiser les champs après l'ajout
                champs_numero_escale.setText("");
                champs_heure_arrivee_escale.setText("");
                champs_heure_depart_escale.setText("");
                champs_ville_escale.setText("");
                volComboBox.getSelectionModel().clearSelection();
                addEscaleShowListData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un vol.");
            alert.showAndWait();

        }
    }
//a refaire
    public void deleteEscale() {
        String numVol = champs_numero_escale.getText();

        // Vérifier si le champ numVol est rempli
        if (numVol.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter the escale ID");
            alert.showAndWait();
            return;
        }

        // Effectuer les opérations de suppression
        try {
            // Connexion à la base de données (à adapter selon votre code)
            Connection connection = database.connectDb();

            // Construction de la requête SQL de suppression
            String sql = "DELETE FROM escale WHERE id_escale = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, numVol);

            // Exécution de la requête
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Escale successfully deleted!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Failed to delete escale. Please check the vol ID.");
                alert.showAndWait();
            }

            // Fermeture de la connexion et réinitialisation des champs
            statement.close();
            connection.close();
           addEscaleReset();


            // Actualisation de l'affichage de la liste des escales
            addEscaleShowListData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public ObservableList<EscaleData> addEscaleListData() {
        ObservableList<EscaleData> listData = FXCollections.observableArrayList();
        String sql = "SELECT num_vol, v.depart, v.destination, e.heure_d, e.heure_a, e.ville ,e.id_escale FROM vol v JOIN escale e ON num_vol = e.id_vol";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                String vol = result.getString("num_vol") + " - " + result.getString("depart") + " to " + result.getString("destination");
                String heureDepart = result.getString("heure_d");
                String heureArrivee = result.getString("heure_a");
                String ville = result.getString("ville");

                int durationInMinutes;

                if (heureDepart.length() >= 5 || heureArrivee.length() >= 5) {
                    // Extract hours and minutes from the time strings
                    int departHour = Integer.parseInt(heureDepart.substring(0, 2));
                    int departMinute = Integer.parseInt(heureDepart.substring(3, 5));
                    int arriveHour = Integer.parseInt(heureArrivee.substring(0, 2));
                    int arriveMinute = Integer.parseInt(heureArrivee.substring(3, 5));
                    durationInMinutes = (departHour * 60 + departMinute) - (arriveHour * 60 + arriveMinute);
                } else {
                    int departHour = Integer.parseInt(heureDepart);
                    int arriveHour = Integer.parseInt(heureArrivee);
                    durationInMinutes = (departHour * 60) - (arriveHour * 60);
                }

                EscaleData escale = new EscaleData(
                        result.getString("id_escale"),
                        vol,
                        heureArrivee,
                        heureDepart,
                        ville,
                        durationInMinutes
                );

                listData.add(escale);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }



    public void addEscaleUpdate() {
        // Récupérer les valeurs des champs
        String numEscale = champs_numero_escale.getText();
        String heureDepart = champs_heure_depart_escale.getText();
        String heureArrivee = champs_heure_arrivee_escale.getText();
        String ville = champs_ville_escale.getText();

        // Vérifier si tous les champs sont remplis
        if (numEscale.isEmpty() || heureDepart.isEmpty()
                || heureArrivee.isEmpty() || ville.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields");
            alert.showAndWait();
            return;
        }

        // Effectuer les opérations de mise à jour
        try {
            // Connexion à la base de données (à adapter selon votre code)
            Connection connection = database.connectDb();

            // Construction de la requête SQL d'update
            String sql = "UPDATE escale SET heure_d = ?, heure_a = ?, ville = ? WHERE id_escale = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, heureDepart);
            statement.setString(2, heureArrivee);
            statement.setString(3, ville);
            statement.setString(4, numEscale);

            // Exécution de la requête
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Escale successfully updated!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Failed to update escale. Please check the provided information.");
                alert.showAndWait();
            }

            // Fermeture de la connexion et réinitialisation des champs
            statement.close();
            connection.close();
            addEscaleReset();

            // Actualisation de l'affichage de la liste des escales
            addEscaleShowListData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ObservableList<EscaleData> addEscaleList;

    public void addEscaleShowListData() {
        addEscaleList = addEscaleListData();

        vol_escale.setCellValueFactory(new PropertyValueFactory<>("vol"));

        heure_arrivee_escale1.setCellValueFactory(new PropertyValueFactory<>("heureArrivee"));
        heure_depart_escale1.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));
        ville_escale1.setCellValueFactory(new PropertyValueFactory<>("ville"));
        duree1.setCellValueFactory(new PropertyValueFactory<>("durre"));

        escales_tableview.setItems(addEscaleList);
    }



    @FXML
    private void addEscaleSelect() {
        EscaleData selectedEscale = escales_tableview.getSelectionModel().getSelectedItem();
        if (selectedEscale != null) {
            champs_numero_escale.setText(selectedEscale.getIdEscale());
            champs_heure_arrivee_escale.setText(selectedEscale.getHeureArrivee());
            champs_heure_depart_escale.setText(selectedEscale.getHeureDepart());
            champs_ville_escale.setText(selectedEscale.getVille());

            // Set the selected vol in the ComboBox
            volComboBox.getSelectionModel().select(selectedEscale.getVol());
        }
    }


    public void reserverVol() {
        // Vérifier si un vol est sélectionné dans la table
        VolData selectedVol = user_vols_tableview.getSelectionModel().getSelectedItem();
        if (selectedVol == null) {
            // Aucun vol sélectionné, afficher un message d'erreur ou effectuer une autre action appropriée
            return;
        }

        // Récupérer l'ID de l'utilisateur et l'ID du vol sélectionné
        Integer userId = getData.userId;
        Integer volId = Integer.parseInt(selectedVol.getNumVol());
        System.out.println("le volId es"+volId);
        System.out.println("le userId es"+userId);
        // Insérer une nouvelle réservation dans la table reservation
        String insertQuery = "INSERT INTO reservation (client_id, vol_num_vol, status) VALUES (?, ?, false)";
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            prepare.setInt(1, userId);
            prepare.setInt(2, volId);
            prepare.executeUpdate();

            // Récupérer l'ID auto-incrémenté de la réservation
            ResultSet generatedKeys = prepare.getGeneratedKeys();
            if (generatedKeys.next()) {
                int reservationId = generatedKeys.getInt(1);
                System.out.println("Réservation créée avec succès ! ID de réservation : " + reservationId);
            } else {
                // Échec de récupération de l'ID de réservation auto-incrémenté
                System.out.println("Échec de création de réservation. Impossible de récupérer l'ID de réservation.");
            }
            addReservationShowListData();
        } catch (Exception e) {
            e.printStackTrace();
            // Afficher un message d'erreur ou effectuer une autre action appropriée en cas d'échec
        }
    }

    public void addEscaleReset() {
        champs_numero_escale.setText("");
        champs_heure_arrivee_escale.setText("");
        champs_heure_depart_escale.setText("");
        champs_ville_escale.setText("");
        volComboBox.getSelectionModel().clearSelection();
    }


    private ObservableList<EscaleData> escaleList;





    public ObservableList<EscaleData> VoirEscale() {
        // Récupérer la réservation sélectionnée dans la table
        ReservationData selectedReservation = user_reservations_tableview.getSelectionModel().getSelectedItem();
        if (selectedReservation == null) {
            // Aucune réservation sélectionnée, afficher une alerte d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Aucune réservation sélectionnée");
            alert.setContentText("Veuillez sélectionner une réservation pour afficher les escales.");
            alert.showAndWait();
            return null;
        }
        // Vérifier si le statut de la réservation est true
        if (selectedReservation.isStatus()) {
            // Statut de réservation est true, afficher les escales
            int volNum = selectedReservation.getIdVolReservation();
            String escaleQuery = "select e.id_escale ,e.heure_a, e.heure_d , e.ville from escale e , vol v where e.id_vol = v.num_vol and e.id_vol = ?";
            connect = database.connectDb();

            try {
                prepare = connect.prepareStatement(escaleQuery);
                prepare.setInt(1, volNum);
                result = prepare.executeQuery();

                ObservableList<EscaleData> escaleList = FXCollections.observableArrayList();

                // Récupérer les données des escales
                while (result.next()) {
                    String heureDepart = result.getString("heure_d");
                    String heureArrivee = result.getString("heure_a");
                    String ville = result.getString("ville");
                    String id=result.getString("id_escale");
                    int durationInMinutes;

                    if (heureDepart.length() >= 5 || heureArrivee.length() >= 5) {
                        // Extract hours and minutes from the time strings
                        int departHour = Integer.parseInt(heureDepart.substring(0, 2));
                        int departMinute = Integer.parseInt(heureDepart.substring(3, 5));
                        int arriveHour = Integer.parseInt(heureArrivee.substring(0, 2));
                        int arriveMinute = Integer.parseInt(heureArrivee.substring(3, 5));
                        durationInMinutes = (departHour * 60 + departMinute) - (arriveHour * 60 + arriveMinute);
                    } else {
                        int departHour = Integer.parseInt(heureDepart);
                        int arriveHour = Integer.parseInt(heureArrivee);
                        durationInMinutes = (departHour * 60) - (arriveHour * 60);
                    }
                    EscaleData escaleData = new EscaleData(id,heureArrivee,heureDepart, ville,durationInMinutes);
                    escaleList.add(escaleData);
                }

                // Afficher la liste des escales dans la table
                //user_escales_tableview.setItems(escaleList);

                return escaleList;
            } catch (Exception e) {
                e.printStackTrace();
                // Afficher un message d'erreur ou effectuer une autre action appropriée en cas d'échec
            }
        } else {
            // Statut de réservation est false, afficher une alerte d'information
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Réservation non acceptée");
            alert.setContentText("La réservation sélectionnée n'a pas encore été acceptée.");
            alert.showAndWait();
        }

        return null;
    }

    public void populateEscaleTable() {
        escaleList = VoirEscale();

        heure_arrivee.setCellValueFactory(new PropertyValueFactory<>("heureArrivee"));
        heure_depart.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        durre.setCellValueFactory(new PropertyValueFactory<>("durre"));
       /* for (EscaleData escale : escaleList) {
            System.out.println("Heure Arrivée: " + escale.getHeureArrivee());
            System.out.println("Heure Départ: " + escale.getHeureDepart());
            System.out.println("Ville: " + escale.getVille());
            System.out.println("--------------------");
        }*/
        user_escales_tableview.getItems().clear();
        user_escales_tableview.setItems(escaleList);
    }


    public void retrieveReservationDataListAdmin() {
        reservationList = retrieveReservationDataList();

        id_reservation1.setCellValueFactory(new PropertyValueFactory<>("idReservation"));
        nom_client.setCellValueFactory(new PropertyValueFactory<>("email"));
        destination_reservation.setCellValueFactory(new PropertyValueFactory<>("destination"));
        date_vol_reservation.setCellValueFactory(new PropertyValueFactory<>("dateVol"));

        status_reservation.setCellValueFactory(param -> {
            Boolean statusValue = param.getValue().isStatus();
            String statusText = statusValue ? "Accepté" : "Pas encore";
            return new SimpleStringProperty(statusText);
        });

        gestion_clients_tableview.setItems(reservationList);
    }

    public ObservableList<ReservationData> retrieveReservationDataList() {
        ObservableList<ReservationData> listData = FXCollections.observableArrayList();
        String sql = "SELECT r.num_reservation, u.email as email, v.destination, v.dateDepart, r.status " +
                "FROM reservation r " +
                "JOIN vol v ON r.vol_num_vol = v.num_vol " +
                "JOIN users u ON r.client_id = u.user_id";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                ReservationData reservation = new ReservationData(
                        result.getInt("num_reservation"),
                        result.getString("email"),
                        result.getString("destination"),
                        result.getString("dateDepart"),
                        result.getBoolean("status")
                );

                listData.add(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }



    // Méthode appelée lorsqu'on clique sur le bouton "Accepter"
    @FXML
    private void accepteReservation(ActionEvent event) {
        ReservationData selectedReservation = gestion_clients_tableview.getSelectionModel().getSelectedItem();
        if (selectedReservation != null) {
            // Récupérer l'ID de la réservation sélectionnée
            int reservationId = selectedReservation.getIdReservation();

            // Récupérer l'e-mail de la réservation sélectionnée
            String email = selectedReservation.getEmail();

            // Effectuer la mise à jour dans la base de données
            boolean success = updateReservationStatus(reservationId);

            if (success) {
                // Mettre à jour le statut dans l'objet ReservationData
                selectedReservation.setStatus(true);
                gestion_clients_tableview.refresh(); // Rafraîchir la TableView pour refléter les modifications

                // Utiliser l'e-mail récupéré
                System.out.println("E-mail: " + email);
                EnvoyerEmail test = new EnvoyerEmail();
                test.envoyer(email);
                homePaysLaPlusVisite();
                homeTotalClients();
                homeTotalRevenue();
            } else {
                // La mise à jour a échoué, afficher un message d'erreur ou prendre d'autres mesures nécessaires
            }
        }
    }
    // Méthode pour effectuer la mise à jour du statut dans la base de données
    private boolean updateReservationStatus(int reservationId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Établir la connexion à la base de données
            connection = database.connectDb();

            // Préparer la requête SQL
            String sql = "UPDATE reservation SET status = true WHERE num_reservation = ?";
            statement = connection.prepareStatement(sql);

            // Définir les valeurs des paramètres de la requête
            statement.setInt(1, reservationId);

            // Exécuter la requête de mise à jour
            int rowsAffected = statement.executeUpdate();

            // Vérifier si la mise à jour a réussi
            if (rowsAffected > 0) {
                return true;




            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Fermer les ressources de la base de données
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ... Autres méthodes et logique de votre contrôleur


    @FXML
    public void onButtonClicked(ActionEvent event) throws DocumentException, FileNotFoundException {
        // Récupérer la réservation sélectionnée dans la TableView
        ReservationData selectedReservation = user_reservations_tableview.getSelectionModel().getSelectedItem();

        if (selectedReservation != null) {
            int reservationId = selectedReservation.getIdReservation();

            // Appeler la méthode generateTicketPDF() en passant l'ID de réservation
            generateTicketPDF(reservationId);
        }
    }


    public void generateTicketPDF(int reservationId) throws FileNotFoundException, DocumentException {
        // Création du document PDF



        Document document = new Document();


        String filePath = "C:\\Users\\jungleboy\\Desktop\\Downloads\\ticket.pdf";
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        document.open();

            // Requête SQL pour récupérer les informations de réservation
            String sql = "SELECT u.nom, u.prenom as prenom,  v.dateDepart, v.heure_d, v.depart, v.destination, r.num_reservation " +
                    "FROM reservation r, vol v, users u " +
                    "WHERE r.vol_num_vol = v.num_vol " +
                    "AND r.client_id = u.user_id " +
                    "AND r.status = true " +
                    "AND r.num_reservation = ? and r.client_id=?";

            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                connection = database.connectDb();
                statement = connection.prepareStatement(sql);
                statement.setInt(1, reservationId);
                statement.setInt(2,getData.getUserId());
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // Récupérer les informations de réservation depuis le ResultSet
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String dateDepart = resultSet.getString("dateDepart");
                    String heureDepart = resultSet.getString("heure_d");
                    String depart = resultSet.getString("depart");
                    String destination = resultSet.getString("destination");
                    int numReservation = resultSet.getInt("num_reservation");

                    // Ajouter le contenu du ticket
                    document.add(new Paragraph("Ticket de réservation"));
                    document.add(new Paragraph("Nom : " + nom));
                    document.add(new Paragraph("Prénom : " + prenom));
                    document.add(new Paragraph("Date de départ : " + dateDepart));
                    document.add(new Paragraph("Heure de départ : " + heureDepart));
                    document.add(new Paragraph("Départ : " + depart));
                    document.add(new Paragraph("Destination : " + destination));
                    document.add(new Paragraph("Numéro de réservation : " + numReservation));

                    // Fermer le document PDF
                    document.close();

                    // Afficher un message de succès
                    System.out.println("Le ticket a été généré avec succès.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            } finally {
                // Fermer les ressources de la base de données
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

    }







    private double x = 0;
    private double y = 0;

    public void logout() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument1.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });



                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//extraire id vol de comboBox
private int extractFlightId(String selectedFlight) {
    // Assuming the flight ID is the substring before the first space character
    String[] parts = selectedFlight.split(" ");
    return Integer.parseInt(parts[0]);
}


    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        String role = getData.getRole();
        vols_reservees.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");

        if(role.equals("admin")) {
            admin_gestion_vols.setVisible(false);
            admin_gestion_escales.setVisible(false);
            admin_gestion_clients.setVisible(false);
            home.setVisible(true);
            admin_interface.setVisible(true);
            client_interface.setVisible(false);
    }else
        {
            admin_interface.setVisible(false);
            client_interface.setVisible(true);
            try {
                getVolsFromDatabase();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            volComboBox1.setOnAction(event -> {
                String selectedFlight = volComboBox1.getValue();
                //System.out.println("******VolCombBox value: " + volComboBox1.getValue());
                // Extract the flight ID from the selected flight string
                if(volComboBox1.getValue() != null){
                int selectedFlightId = extractFlightId(selectedFlight);
                ObservableList<ReservationData> filteredReservations = filterReservationsByFlight(selectedFlightId);
                user_reservations_tableview.setItems(filteredReservations);}
                else{
                    addReservationShowListData();

                }
            });


        }


        //recherche vols dans l'interface client****
        recherche_vol.setOnKeyReleased(event -> {
            String keyword = recherche_vol.getText().toLowerCase(); // Retrieve the search keyword
            if(recherche_vol.getText() != ""){
            // Filter the volDataList based on the keyword using matchesKeyword() method
            ObservableList<VolData> filteredList = volDataList.filtered(vol ->
                    vol.matchesKeyword(keyword)
            );

            // Update the user_vols_tableview with the filtered list
            user_vols_tableview.setItems(filteredList);}
            else{
                populateVolTableView();
            }
        });

        displayUsername();
        defaultNav();
        homeChart();
        addReservationShowListData();
       addVolShowListData();
       addEscaleShowListData();
        populateVolTableView();
        retrieveReservationDataListAdmin();
        homePaysLaPlusVisite();
        homeTotalClients();
        homeTotalRevenue();
    }

}
