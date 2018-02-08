package com.qomtec.utils;

import com.google.firebase.database.FirebaseDatabase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Global {

    public static String ID_EMAIL_GENERAL;
    public static String ID_GENERAL;
    public static FirebaseDatabase DB;
    public static void mostrarformulario(String formulario, String titulo,Class cc){
        try {
            FXMLLoader loader = new FXMLLoader(cc.getResource(formulario));
            Parent root1 = (Parent) loader.load();
            Scene scene = new Scene(root1);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle(titulo);
            stage.initStyle(StageStyle.UTILITY);


            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
