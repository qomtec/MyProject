package com.qomtec.controllers;

import com.jfoenix.controls.JFXTextField;
import com.qomtec.utils.Global;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;


public class FrmOdontologo extends Application {
    @FXML private JFXTextField txt_buscar;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {

    }
    @FXML
    protected void initialize(){
        txt_buscar.textProperty().addListener((obs, oldText, newText) -> {
            System.out.println(txt_buscar.getText());
        });
    }

    public void btn_buscarOnAction(Event e){

    }
    public void btn_nuevoOnAction(Event e){
        Global.mostrarformulario("/com/qomtec/views/frm_p_odontologo.fxml","Odontólogo::.",getClass());
    }
    public void btn_modificarOnAction(Event e){
        Global.mostrarformulario("/com/qomtec/views/frm_p_odontologo.fxml","Odontólogo::.",getClass());
    }
    public void btn_eliminarOnAction(Event e){

    }

}
