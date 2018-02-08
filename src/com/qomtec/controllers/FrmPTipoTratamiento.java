package com.qomtec.controllers;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.qomtec.objects.TipoTratamiento;
import com.qomtec.utils.Global;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class FrmPTipoTratamiento implements Initializable {
    FirebaseDatabase db;
    @FXML TextField txt_codigo_tipo_tratamiento;
    @FXML TextField txt_nombre_tipo_tratamiento;
    public void btn_guardarOnAction(Event e){
        TipoTratamiento tipoTratamiento = new TipoTratamiento();
        tipoTratamiento.setNombre_tipo_tratamiento(txt_nombre_tipo_tratamiento.getText());
        tipoTratamiento.setCodigo_tipo_tratamiento(txt_codigo_tipo_tratamiento.getText());
        guardarTipoTratamiento(tipoTratamiento);
    }

    private void guardarTipoTratamiento(TipoTratamiento tipoTratamiento) {
        if (tipoTratamiento!=null){
            DatabaseReference tbl = db.getReference("/tbl_tipo_tratamiento/");
            DatabaseReference row = tbl.child("");
            row.push().setValue(tipoTratamiento, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    System.out.println("Registro completo");
                }
            });
        }

    }

    public void btn_cancelarOnAction(Event e){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = FirebaseDatabase.getInstance();
    }
}
