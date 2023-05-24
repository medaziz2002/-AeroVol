package com.example.projetvolmanagement;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AeoroportManagementSystem extends Application {

    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument1.fxml"));

        Scene scene = new Scene(root);


        //action a définit une action à exécuter lorsque le bouton de la souris est enfoncé sur l'élément root
        root.setOnMousePressed((MouseEvent event) ->{
            x = event.getSceneX();
            y = event.getSceneY();
        });
//Cela définit une action à exécuter lorsque la souris est déplacée tout en maintenant le bouton enfoncé sur l'élément root
        root.setOnMouseDragged((MouseEvent event) ->{
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);

            stage.setOpacity(.8);
        });
// Cela définit une action à exécuter lorsque le bouton de la souris est relâché sur l'élément root
        root.setOnMouseReleased((MouseEvent event) ->{
            stage.setOpacity(1);
        });



        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
