package com.qomtec.controllers;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.qomtec.objects.Odontologo;
import com.qomtec.utils.GenerateKey;
import com.qomtec.utils.Global;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;

public class FrmPOdontologo extends Application implements Initializable{
    @FXML private TextField txt_codigo_odontologo;
    @FXML private TextField txt_nombre_odontologo;
    @FXML private TextField txt_colegiado_odontologo;
    @FXML private TextField txt_correo_odontologo;
    @FXML private PasswordField txt_pass_1;
    @FXML private PasswordField txt_pass_2;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
    public void btn_guardarOnAction(Event e){
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre_odontologo(txt_nombre_odontologo.getText());
        odontologo.setColegiado_odontologo(txt_colegiado_odontologo.getText());
        odontologo.setClave_odontologo(txt_pass_1.getText());
        odontologo.setCorreo_odontologo(txt_correo_odontologo.getText());
        odontologo.setCodigo_odontologo(GenerateKey.getMD5(txt_correo_odontologo.getText()));
        guardarOdontologo(odontologo);
    }
    FirebaseDatabase db ;
    private void guardarOdontologo(Odontologo odontologo) {
        db = FirebaseDatabase.getInstance();
        DatabaseReference tbl = db.getReference("/tbl_clinica/"+ Global.ID_GENERAL + "/tbl_odontologo");
        DatabaseReference row = tbl.child(odontologo.getCodigo_odontologo().substring(0,20));
        CountDownLatch count = new CountDownLatch(1);
        row.setValue(odontologo, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                System.out.println("Registro completo");
            }
        });
    }

    public void btn_cancelarOnAction(Event e){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = FirebaseDatabase.getInstance();
        if (FrmOdontologo.objeto!=null){
            txt_codigo_odontologo.setText(FrmOdontologo.objeto.getCodigo_odontologo());
            txt_nombre_odontologo.setText(FrmOdontologo.objeto.getNombre_odontologo());
            txt_colegiado_odontologo.setText(FrmOdontologo.objeto.getColegiado_odontologo());
            txt_correo_odontologo.setText(FrmOdontologo.objeto.getCorreo_odontologo());
            txt_pass_1.setText(FrmOdontologo.objeto.getClave_odontologo());
            txt_pass_2.setText(FrmOdontologo.objeto.getClave_odontologo());
        }

    }
}
