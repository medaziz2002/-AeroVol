package com.example.projetvolmanagement;



import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

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
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class dashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;


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
    private Label username;

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
    private TextField addEmployee_employeeID;

    @FXML
    private TextField champs_id_vol;

    @FXML
    private TextField champs_prix_vol;
    @FXML
    private TextField champs_destination_vol;




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
// Définissez les autres identifiants nécessaires pour les autres composants
    @FXML
    private TextField id_escale;
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    private Image image;

    public void homeTotalEmployees() {
/*
        String sql = "SELECT COUNT(num_vol) FROM vol";

        connect = database.connectDb();
        int countData = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(num_vol)");
            }

            home_totalEmployees.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }

    public void homeEmployeeTotalPresent() {
/*
        String sql = "SELECT COUNT(id) FROM vol";

        connect = database.connectDb();
        int countData = 0;
        try {
            statement = connect.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }
            home_totalPresents.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }

    public void homeTotalInactive() {
/*
        String sql = "SELECT COUNT(id) FROM vol WHERE prix = '0.0'";

        connect = database.connectDb();
        int countData = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id)");
            }
            home_totalInactiveEm.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }

    public void homeChart() {
/*
        home_chart.getData().clear();

        String sql = "SELECT dateDepart, COUNT(id) FROM vol GROUP BY dateDepart ORDER BY TIMESTAMP(dateDepart) ASC LIMIT 7";

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
*/
    }




    public void getVolsFromDatabase() throws SQLException {
        String sql = "SELECT * FROM vol";

        ObservableList<String> volList = FXCollections.observableArrayList();
        try {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String numVol = resultSet.getString("num_vol");
                String depart = resultSet.getString("depart");
                String destination = resultSet.getString("destination");
                volList.add(numVol + " - " + depart + " - " + destination);
            }

            volComboBox.getItems().addAll(volList);

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

        } catch (Exception e) {
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

    public void addEmployeeInsertImage() {
/*
        FileChooser open = new FileChooser();
        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {
            getData.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 101, 127, false, true);
            addEmployee_image.setImage(image);
        }*/
    }

    private String[] positionList = {"Marketer Coordinator", "Web Developer (Back End)", "Web Developer (Front End)", "App Developer"};

    public void addEmployeePositionList() {
        /*
        List<String> listP = new ArrayList<>();

        for (String data : positionList) {
            listP.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listP);
        addEmployee_position.setItems(listData);*/
    }

    private String[] listGender = {"Male", "Female", "Others"};

    public void addEmployeeGendernList() {
        /*
        List<String> listG = new ArrayList<>();

        for (String data : listGender) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        addEmployee_gender.setItems(listData);
        */

    }

    public void addVolSearch() {
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


    public void salaryUpdate() {
/*
        String sql = "UPDATE employee_info SET salary = '" + salary_salary.getText()
                + "' WHERE employee_id = '" + salary_employeeID.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (salary_employeeID.getText().isEmpty()
                    || salary_firstName.getText().isEmpty()
                    || salary_lastName.getText().isEmpty()
                    || salary_position.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select item first");
                alert.showAndWait();
            } else {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                salaryShowListData();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
   */

    }

    public void salaryReset() {
        salary_employeeID.setText("");
        salary_firstName.setText("");
        salary_lastName.setText("");
        salary_position.setText("");
        salary_salary.setText("");


    }

    public ObservableList<employeeData> salaryListData() {

        ObservableList<employeeData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM vol";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            employeeData employeeD;

            while (result.next()) {
                employeeD = new employeeData(result.getInt("employee_id"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("position"),
                        result.getDouble("salary"));

                listData.add(employeeD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<employeeData> salaryList;

    public void salaryShowListData() {
        /*
        salaryList = salaryListData();

        salary_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        salary_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        salary_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        salary_col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
        salary_col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        salary_tableView.setItems(salaryList);
*/
    }

    public void salarySelect() {

     /*   employeeData employeeD = salary_tableView.getSelectionModel().getSelectedItem();
        int num = salary_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        salary_employeeID.setText(String.valueOf(employeeD.getEmployeeId()));
        salary_firstName.setText(employeeD.getFirstName());
        salary_lastName.setText(employeeD.getLastName());
        salary_position.setText(employeeD.getPosition());
        salary_salary.setText(String.valueOf(employeeD.getSalary()));
*/
    }

    public void defaultNav() {
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
    }

    public void displayUsername() {

        username.setText(getData.login_username);
        System.out.println("le username est hhhhhhhhhhhhh "+username);
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
            gestion_vols.setStyle("-fx-background-color:transparent");
            admin_gestion_clients.setStyle("-fx-background-color:transparent");

            homeTotalEmployees();
            homeEmployeeTotalPresent();
            homeTotalInactive();
            homeChart();

        } else if (event.getSource() == gestion_vols) {
            home.setVisible(false);
            admin_gestion_vols.setVisible(true);
            admin_gestion_escales.setVisible(false);
            admin_gestion_clients.setVisible(false);
            client_interface.setVisible(false);
            gestion_vols.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            home_btn.setStyle("-fx-background-color:transparent");
       //     salary_btn.setStyle("-fx-background-color:transparent");

            addEmployeeGendernList();
            addEmployeePositionList();
            addVolSearch();

        } else if (event.getSource() == gestion_clients) {
            home.setVisible(false);
            admin_gestion_vols.setVisible(false);
            admin_gestion_escales.setVisible(false);
            admin_gestion_clients.setVisible(true);
            client_interface.setVisible(false);
          //  salary_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            gestion_vols.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");

            salaryShowListData();

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
        }


       if (event.getSource() == listes_vols) {

           user_reservations.setVisible(false);
           user_liste_vols.setVisible(true);
           user_listes_escales.setVisible(false);

           home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
           gestion_vols.setStyle("-fx-background-color:transparent");
           admin_gestion_clients.setStyle("-fx-background-color:transparent");

           homeTotalEmployees();
           homeEmployeeTotalPresent();
           homeTotalInactive();
           homeChart();

       } else if (event.getSource() == vols_reservees) {
           user_reservations.setVisible(true);
           user_liste_vols.setVisible(false);
           user_listes_escales.setVisible(false);

           gestion_vols.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
           home_btn.setStyle("-fx-background-color:transparent");
           //     salary_btn.setStyle("-fx-background-color:transparent");

           addEmployeeGendernList();
           addEmployeePositionList();
           addVolSearch();

       } else if (event.getSource() == user_escales_btn) {

           user_reservations.setVisible(false);
           user_liste_vols.setVisible(false);
           user_listes_escales.setVisible(true);

           //  salary_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
           gestion_vols.setStyle("-fx-background-color:transparent");
           home_btn.setStyle("-fx-background-color:transparent");

           salaryShowListData();

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
           // addEscaleReset();

            // Actualisation de l'affichage de la liste des escales
            addEscaleShowListData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



  public void annulerEscale()
    {

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

                EscaleData escale = new EscaleData(
                        result.getString("id_escale"),
                        vol,

                        result.getString("heure_a"),
                        result.getString("heure_d"),
                        result.getString("ville")
                );

                listData.add(escale);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }


    private ObservableList<EscaleData> addEscaleList;

    public void addEscaleShowListData() {
        addEscaleList = addEscaleListData();

        vol_escale.setCellValueFactory(new PropertyValueFactory<>("vol"));

        heure_arrivee_escale1.setCellValueFactory(new PropertyValueFactory<>("heureArrivee"));
        heure_depart_escale1.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));
        ville_escale1.setCellValueFactory(new PropertyValueFactory<>("ville"));

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

        if(role.equals("admin")) {
            home.setVisible(true);
            admin_interface.setVisible(true);
            client_interface.setVisible(false);
        }else
        {
            admin_interface.setVisible(false);
            client_interface.setVisible(true);
        }


        displayUsername();
        defaultNav();

        homeTotalEmployees();
        homeEmployeeTotalPresent();
        homeTotalInactive();
        homeChart();

       addVolShowListData();
       addEscaleShowListData();
        addEmployeeGendernList();
        addEmployeePositionList();



        salaryShowListData();
    }

}
