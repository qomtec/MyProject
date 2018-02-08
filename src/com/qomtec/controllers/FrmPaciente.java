package com.qomtec.controllers;

import com.google.firebase.database.*;
import com.jfoenix.controls.JFXTextField;
import com.qomtec.objects.Odontologo;
import com.qomtec.objects.Paciente;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FrmPaciente extends Application implements Initializable {
    @FXML private JFXTextField txt_buscar;
    @FXML private TableView tv_lista_paciente;
    @FXML private TableColumn tc_codigo_paciente;
    @FXML private TableColumn tc_nombre_paciente;
    @FXML private TableColumn tc_apellido_paciente;
    @FXML private TableColumn tc_telefono_paciente;
    @FXML private TableColumn tc_correo_paciente;
    @FXML private TableColumn tc_edad_paciente;
    @FXML private TableColumn tc_fecha_nacimiento_paciente;
    @FXML private TableColumn tc_estado_civil_paciente;
    @FXML private TableColumn tc_ocupacion_paciente;
    @FXML private TableColumn tc_alergias_paciente;
    @FXML private TableColumn tc_genero_paciente;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = FirebaseDatabase.getInstance();
        tv_lista_paciente.setEditable(false);
        tv_lista_paciente.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (tv_lista_paciente.getSelectionModel().getSelectedItem()!=null){
                    TableView.TableViewSelectionModel selectionModel = tv_lista_paciente.getSelectionModel();
                    ObservableList selectedCells = selectionModel.getSelectedCells();
                    TablePosition position = (TablePosition) selectedCells.get(0);
                    Object val = position.getTableColumn().getCellData(newValue);
                }
            }
        });
        tv_lista_paciente.setRowFactory(tv -> {
            TableRow<Paciente> row = new TableRow<>();
            row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount()==1 && (!row.isEmpty())){
                        Paciente paciente = row.getItem();
                        System.out.println(paciente);
                    }
                }
            });
            return row;
        });
        listarPaciente();
    }
    public void listarPaciente(){
        DatabaseReference tbl = db.getReference("/tbl_paciente/" + Global.ID_GENERAL+"/");
        ObservableList<Paciente> lista = FXCollections.observableArrayList();
        tbl.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Paciente paciente = dataSnapshot.getValue(Paciente.class);
                lista.add(paciente);
                System.out.println(paciente);
                listar(lista);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Paciente paciente = dataSnapshot.getValue(Paciente.class);
                lista.add(paciente);
                System.out.println(paciente);
                listar(lista);
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

    private void listar(ObservableList<Paciente> lista) {
        tc_alergias_paciente.setCellValueFactory(new PropertyValueFactory<>("alergias_paciente"));
        tc_apellido_paciente.setCellValueFactory(new PropertyValueFactory<>("apellido_paciente"));
        tc_codigo_paciente.setCellValueFactory(new PropertyValueFactory<>("codigo_paciente"));
        tc_correo_paciente.setCellValueFactory(new PropertyValueFactory<>("correo_paciente"));
        tc_edad_paciente.setCellValueFactory(new PropertyValueFactory<>("edad_paciente"));
        tc_estado_civil_paciente.setCellValueFactory(new PropertyValueFactory<>("estado_civil_paciente"));
        tc_fecha_nacimiento_paciente.setCellValueFactory(new PropertyValueFactory<>("fecha_nacimiento_paciente"));
        tc_nombre_paciente.setCellValueFactory(new PropertyValueFactory<>("nombre_paciente"));
        tc_ocupacion_paciente.setCellValueFactory(new PropertyValueFactory<>("ocupacion_paciente"));
        tc_telefono_paciente.setCellValueFactory(new PropertyValueFactory<>("telefono_paciente"));
        tc_genero_paciente.setCellValueFactory(new PropertyValueFactory<>("genero_paciente"));
        tv_lista_paciente.setItems(null);
        tv_lista_paciente.setItems(lista);
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
    FirebaseDatabase db;
    public void btn_buscarOnAction(Event e){

    }
    public void btn_nuevoOnAction(Event e){
        Global.mostrarformulario("../views/frm_p_paciente.fxml","Paciente::.",getClass());
    }
    public void btn_modificarOnAction(Event e){
        Global.mostrarformulario("../views/frm_p_paciente.fxml","Paciente::.",getClass());
    }
    public void btn_eliminarOnAction(Event e){

    }

}
