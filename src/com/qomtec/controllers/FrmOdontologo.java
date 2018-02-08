package com.qomtec.controllers;

import com.google.firebase.database.*;
import com.jfoenix.controls.JFXTextField;
import com.qomtec.objects.Odontologo;
import com.qomtec.utils.Global;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;


public class FrmOdontologo implements Initializable{
    @FXML private TextField txt_buscar;
    @FXML private TableView tv_lista_odontologo;
    @FXML private TableColumn tc_codigo_odontologo;
    @FXML private TableColumn tc_nombre_odontologo;
    @FXML private TableColumn tc_colegiado_odontologo;
    @FXML private TableColumn tc_usuario_odontologo;
    @FXML private TableColumn tc_clave_odontologo;

    public void btn_nuevoOnAction(Event e){
        Global.mostrarformulario("/com/qomtec/views/frm_p_odontologo.fxml","Odontólogo::.",getClass());
    }
    public void btn_modificarOnAction(Event e){
        if (objeto!=null){
            Global.mostrarformulario("/com/qomtec/views/frm_p_odontologo.fxml","Odontólogo::.",getClass());
        }

    }
    public void btn_eliminarOnAction(Event e){

    }
    public static Odontologo objeto = new Odontologo();
    FirebaseDatabase db;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = FirebaseDatabase.getInstance();
        tv_lista_odontologo.setEditable(true);
        tv_lista_odontologo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if (tv_lista_odontologo.getSelectionModel().getSelectedItem() != null) {
                    TableView.TableViewSelectionModel selectionModel = tv_lista_odontologo.getSelectionModel();
                    ObservableList selectedCells = selectionModel.getSelectedCells();
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    Object val = tablePosition.getTableColumn().getCellData(newValue);
                    /*Productos productos = (Productos) tv_lista_odontologo.getSelectionModel().getSelectedItem();
                    System.out.println(productos);*/
                }
            }
        });
        tv_lista_odontologo.setRowFactory(tv -> {
            TableRow<Odontologo> row = new TableRow<>();
            row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getClickCount()== 1 && (!row.isEmpty())){
                        Odontologo odontologo = row.getItem();
                        objeto = odontologo;
                        System.out.println(odontologo);
                    }
                }
            });
            return row;
        });
        txt_buscar.textProperty().addListener((obs, oldText, newText) -> {
            buscar(txt_buscar.getText());
            System.out.println(txt_buscar.getText());
        });
        listarOdontologo();
    }
    public void buscar(String texti){
        DatabaseReference tbl = db.getReference("/tbl_odontologo/"+ Global.ID_GENERAL +"/");
        DatabaseReference busqueda = (DatabaseReference) tbl.orderByChild("nombre_odontologo").startAt(texti);
        busqueda.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Odontologo odontologo = dataSnapshot.getValue(Odontologo.class);
                System.out.println(odontologo);
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
    public void listarOdontologo(){
        DatabaseReference tbl = db.getReference("/tbl_odontologo/"+ Global.ID_GENERAL +"/");
        try {
            ObservableList<Odontologo> listaOdontologos = FXCollections.observableArrayList();
            tbl.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Odontologo odontologo = dataSnapshot.getValue(Odontologo.class);
                    listaOdontologos.add(odontologo);
                    listar(listaOdontologos);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    Odontologo odontologo = dataSnapshot.getValue(Odontologo.class);
                    listaOdontologos.add(odontologo);
                    listar(listaOdontologos);
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void listar(ObservableList<Odontologo> listaOdontologos){
        tc_codigo_odontologo.setCellValueFactory(new PropertyValueFactory("codigo_odontologo"));
        tc_nombre_odontologo.setCellValueFactory(new PropertyValueFactory("nombre_odontologo"));
        tc_colegiado_odontologo.setCellValueFactory(new PropertyValueFactory("colegiado_odontologo"));
        tc_usuario_odontologo.setCellValueFactory(new PropertyValueFactory("correo_odontologo"));
        tc_clave_odontologo.setCellValueFactory(new PropertyValueFactory("clave_odontologo"));
        tv_lista_odontologo.setItems(null);
        tv_lista_odontologo.setItems(listaOdontologos);

    }
}
