package parkeringshus_test.gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import parkeringshus_test.Bil;
import parkeringshus_test.Controller;
import parkeringshus_test.Parkeringshus;


public class Gui extends Application {

    @Override
    public void init() {
        Controller.createSomeObjects();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Parkeringshuse og pladser");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Parkeringshus> lvwParkeringshus = new ListView<>();
    private final ListView<String> lvwPladser = new ListView<>();
    private final TextField txfNummer = new TextField();
    private Parkeringshus selectedParkeringshus;
    private void initContent(GridPane pane) {

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblParkeringshuse = new Label("Parkeringshuse");
        pane.add(lblParkeringshuse, 0, 0);


        pane.add(lvwParkeringshus, 0, 1);
        lvwParkeringshus.setPrefWidth(200);
        lvwParkeringshus.setPrefHeight(200);
        lvwParkeringshus.getItems().setAll(Controller.getParkeringshuse());
        ChangeListener<Parkeringshus> listener = (ov, o, n) -> this.selectedParkeringshusChanged();
        lvwParkeringshus.getSelectionModel().selectedItemProperty().addListener(listener);

        pane.add(lvwPladser, 1, 1);
        lvwPladser.setPrefWidth(200);
        lvwPladser.setPrefHeight(200);

        Label lblPladser = new Label("Optagne pladser");
        pane.add(lblPladser, 1, 0);

        Label lblOpret = new Label("Opret bil med nummer:");
        pane.add(lblOpret, 0, 2);

        pane.add(txfNummer, 1, 2);

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 1, 3);
        btnOpret.setOnAction(event -> opretAction());
    }

    private void opretAction() {
        String nummer = txfNummer.getText();
        Bil bil = Controller.createBil(nummer);
        Controller.insertCarInLedigPlads(bil, selectedParkeringshus);
        updateControls();
    }

    private void selectedParkeringshusChanged() {
        selectedParkeringshus = lvwParkeringshus.getSelectionModel().getSelectedItem();
        updateControls();
    }

    private void updateControls() {
        lvwPladser.getItems().setAll(selectedParkeringshus.optagnePladser());
        txfNummer.clear();
    }
}
