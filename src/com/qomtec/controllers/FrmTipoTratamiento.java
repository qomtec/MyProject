package com.qomtec.controllers;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.jfoenix.controls.JFXTextField;
import com.qomtec.objects.TipoTratamiento;
import com.qomtec.utils.Global;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FrmTipoTratamiento implements Initializable {
    @FXML private JFXTextField txt_buscar;
    @FXML private TableColumn tc_codigo_tipo_tratamiento;
    @FXML private TableColumn tc_nombre_tipo_tratamiento;
    @FXML private TableView tv_lista_tratamientos;
    public void btn_buscarOnAction(Event e){

    }
    public void btn_nuevoOnAction(Event e){
        Global.mostrarformulario("../views/frm_p_tipo_tratamiento.fxml","Tipos de tratamiento::.",getClass());
    }
    public void btn_modificarOnAction(Event e){
        Global.mostrarformulario("../views/frm_p_tipo_tratamiento.fxml","Tipos de tratamiento::.",getClass());
    }
    public void btn_eliminarOnAction(Event e){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_buscar.textProperty().addListener((obs, oldText, newText) -> {
            System.out.println(txt_buscar.getText());
        });
        listarTipoTratamiento();
    }
    public void listarTipoTratamiento(){
        DatabaseReference tbl = Global.DB.getReference("/tbl_tipo_tratamiento/");
        ObservableList<TipoTratamiento> list = FXCollections.observableArrayList();
        tbl.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                TipoTratamiento tipoTratamiento = dataSnapshot.getValue(TipoTratamiento.class);
                list.add(tipoTratamiento);
                listar(list);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void listar(ObservableList<TipoTratamiento> list) {
        tc_codigo_tipo_tratamiento.setCellValueFactory(new PropertyValueFactory<>("codigo_tipo_tratamiento"));
        tc_nombre_tipo_tratamiento.setCellValueFactory(new PropertyValueFactory<>("nombre_tipo_tratamiento"));
        tv_lista_tratamientos.setItems(null);
        tv_lista_tratamientos.setItems(list);
    }
}
