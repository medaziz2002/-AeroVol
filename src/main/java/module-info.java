module com.example.projetvolmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.mail;
    requires itextpdf;
    //requires java.mail;

    opens com.example.projetvolmanagement to javafx.fxml;
    exports com.example.projetvolmanagement;
}