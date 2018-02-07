package com.qomtec.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Global {

    public static String ID_EMAIL_GENERAL;
    public static String ID_GENERAL;
    public static void mostrarformulario(String formulario, String titulo,Class cc){
        try {
            FXMLLoader loader = new FXMLLoader(cc.getResource(formulario));
            Parent root1 = (Parent) loader.load();
            Scene scene = new Scene(root1);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(titulo);
            stage.initStyle(StageStyle.UTILITY);
            stage.showAndWait();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
