package semesterprøve_opg2.gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import semesterprøve_opg2.application.controller.Controller;
import semesterprøve_opg2.application.model.Område;
import semesterprøve_opg2.application.model.Plads;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void init() {
        Controller.initStorage();
    }

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

    private final ListView<Plads> lvwPladser = new ListView<>();
    private final ToggleGroup toggleGroup = new ToggleGroup();
    private final TextField txfNummer = new TextField();

    private void initContent(GridPane pane) {

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblPladser = new Label("Pladser:");
        pane.add(lblPladser, 0, 0);


        pane.add(lvwPladser, 0, 1, 2, 1);
        lvwPladser.setPrefWidth(200);
        lvwPladser.setPrefHeight(200);
        lvwPladser.getItems().setAll(Controller.getPladser());
        lvwPladser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Label lblOmråde = new Label("Område:");
        pane.add(lblOmråde, 0, 2);

        VBox box = new VBox();
        pane.add(box, 1, 2);

        String[] labels = {"Standard", "VIP", "Børne", "Turnering"};
        Område[] områder = {Område.STANDARD, Område.VIP, Område.BØRNE, Område.TURNERING};

        for (int i = 0; i < områder.length; i++) {
            RadioButton rb = new RadioButton();
            rb.setText(labels[i]);
            rb.setUserData(områder[i]);
            rb.setToggleGroup(toggleGroup);
            box.getChildren().add(rb);
        }

        Label lblNummer = new Label("Nummer:");
        pane.add(lblNummer, 0, 3);

        pane.add(txfNummer, 1, 3);

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 1, 4);
        btnOpret.setOnAction(event -> opretAction());
    }

    private void opretAction() {
        RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();
        Område område = (Område) rb.getUserData();
        int nr = Integer.parseInt(txfNummer.getText());
        Controller.createPlads(nr, område);
        lvwPladser.getItems().setAll(Controller.getPladser());
        toggleGroup.selectToggle(null);
        txfNummer.clear();
    }
}
