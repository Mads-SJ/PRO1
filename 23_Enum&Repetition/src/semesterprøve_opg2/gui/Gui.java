package semesterprøve_opg2.gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import semesterprøve_opg2.application.controller.Controller;
import semesterprøve_opg2.application.model.Plads;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Netcafe administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<Plads> lvwPladser = new ListView<>();

    private void initContent(GridPane pane) {
        this.initPersons();

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 1);
        GridPane.setValignment(lblNames, VPos.TOP);

        pane.add(txfName, 1, 0);

        pane.add(lvwPladser, 1, 1);
        lvwPladser.setPrefWidth(200);
        lvwPladser.setPrefHeight(200);
        lvwPladser.getItems().setAll();

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 0);
        btnAdd.setOnAction(event -> this.addAction());

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 2, 1);
        btnDelete.setOnAction(event -> this.deleteAction());
    }

    // -------------------------------------------------------------------------

    private void initPersons() {
//        persons.add(new Person("Jens", "Jensen", "jj@eaaa.dk"));
//        persons.add(new Person("Hans", "Hansen", "hh@eaaa.dk"));
//        persons.add(new Person("Pia", "Peters", "pp@eaaa.dk"));
    }

    // -------------------------------------------------------------------------
    // Selected item changed in lvwPersons

    private void personsItemSelected() {
//        Person selected = lvwPladser.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            txfName.setText(selected.toString());
//        } else {
//            txfName.clear();
//        }
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
//        String name = txfName.getText().trim();
//        if (name.length() > 0) {
//            Person p = new Person(name, "Hansen", name + "@mail.com");
//            persons.add(p);
//            lvwPladser.getItems().setAll(persons);
//        } else {
//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("Add person");
//            alert.setHeaderText("No named typed");
//            alert.setContentText("Type the name of the person");
//            alert.show();
//
//            // wait for the modal dialog to close
//        }
    }

    private void deleteAction() {
//        int index = lvwPladser.getSelectionModel().getSelectedIndex();
//        if (index >= 0) {
//            persons.remove(index);
//            txfName.clear();
//            lvwPladser.getItems().setAll(persons);
//        } else {
//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("Delete person");
//            alert.setHeaderText("No person selected");
//            alert.setContentText("Select a person to be deleted");
//            alert.show();
//
//            // wait for the modal dialog to close
//        }
    }
}
