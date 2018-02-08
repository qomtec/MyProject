package com.qomtec.controllers;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.qomtec.objects.Paciente;
import com.qomtec.utils.GenerateKey;
import com.qomtec.utils.Global;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FrmPPaciente implements Initializable {
    @FXML private TextField txt_nombre_paciente;
    @FXML private TextField txt_apellido_paciente;
    @FXML private TextField txt_telefono_paciente;
    @FXML private TextField txt_correo_paciente;
    @FXML private TextField txt_edad_paciente;
    @FXML private JFXDatePicker txt_fecha_nacimiento_paciente;
    @FXML private JFXComboBox cb_genero_paciente;
    @FXML private JFXComboBox cb_estado_civil_paciente;
    @FXML private TextField txt_ocupacion;
    @FXML private TextArea txt_alergias;
    FirebaseDatabase db;
    public void btn_guardarOnAction(Event e){
        Paciente paciente = new Paciente();
        paciente.setCodigo_paciente(GenerateKey.getMD5(txt_telefono_paciente.getText()));
        paciente.setNombre_paciente(txt_nombre_paciente.getText());
        paciente.setApellido_paciente(txt_apellido_paciente.getText());
        paciente.setTelefono_paciente(txt_telefono_paciente.getText());
        paciente.setCorreo_paciente(txt_correo_paciente.getText());
        paciente.setEdad_paciente(Integer.parseInt(txt_edad_paciente.getText().toString()));
        paciente.setFecha_nacimiento_paciente(txt_fecha_nacimiento_paciente.getValue().toString());
        paciente.setGenero_paciente(cb_genero_paciente.getSelectionModel().getSelectedItem().toString());
        paciente.setEstado_civil_paciente(cb_estado_civil_paciente.getSelectionModel().getSelectedItem().toString());
        paciente.setOcupacion_paciente(txt_ocupacion.getText());
        paciente.setAlergias_paciente(txt_alergias.getText());
        System.out.println(paciente);
        guardarPaciente(paciente);
    }
    private void guardarPaciente(Paciente paciente){
        DatabaseReference tbl = db.getReference("/tbl_paciente/"+ Global.ID_GENERAL+"/");
        DatabaseReference row = tbl.child(paciente.getCodigo_paciente().substring(0,20));
        row.setValue(paciente, new DatabaseReference.CompletionListener() {
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
    }
}
