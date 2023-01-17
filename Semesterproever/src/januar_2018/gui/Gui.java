package januar_2018.gui;

import januar_2018.controller.Controller;
import januar_2018.model.Arrangement;
import januar_2018.model.Tutor;
import januar_2022.model.Løb;
import januar_2022.model.Note;
import januar_2022.model.Tilmelding;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Gui extends Application {

    @Override
    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Administration of tutorer og arrangementer");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Tutor> lvwTutor = new ListView<>();
    private final ListView<Arrangement> lvwTilknyttedeArrangementer = new ListView<>();
    private final ListView<Arrangement> lvwAlleArrangementer = new ListView<>();
    private final TextField txfNav = new TextField();
    private final TextField txfEmail = new TextField();
    private Tutor selectedTutor;
    private Arrangement selectedTilknyttetArrangement;
    private Arrangement selectedAlleArrangement;
    private void initContent(GridPane pane) {

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblTutorer = new Label("Tutorer");
        pane.add(lblTutorer, 0, 0);

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 1, 0);

        Label lblEmail = new Label("Email");
        pane.add(lblEmail, 1, 1);

        Label lblArrangementer = new Label("Arrangementer");
        pane.add(lblArrangementer, 1, 2);

        Label lblAlleArrangementer = new Label("Alle mulige arrangementer");
        pane.add(lblAlleArrangementer, 3, 1);

        pane.add(lvwTutor, 0, 1, 1, 3);
        lvwTutor.setPrefWidth(300);
        lvwTutor.setPrefHeight(200);
        lvwTutor.getItems().setAll(Controller.getTutorere());
        ChangeListener<Tutor> tutorListener = (ov, o, n) -> this.selectedTutorChanged();
        lvwTutor.getSelectionModel().selectedItemProperty().addListener(tutorListener);

        pane.add(lvwTilknyttedeArrangementer, 2, 2);
        lvwTilknyttedeArrangementer.setPrefWidth(300);
        lvwTilknyttedeArrangementer.setPrefHeight(100);
        ChangeListener<Arrangement> tilknyttetArrangementListener = (ov, o, n) -> this.selectedTilknyttetArrangementChanged();
        lvwTilknyttedeArrangementer.getSelectionModel().selectedItemProperty().addListener(tilknyttetArrangementListener);


        pane.add(lvwAlleArrangementer, 3, 2);
        lvwAlleArrangementer.setPrefWidth(300);
        lvwAlleArrangementer.setPrefHeight(100);
        lvwAlleArrangementer.getItems().setAll(Controller.getArrangementer());
        ChangeListener<Arrangement> alleArrangementerListener = (ov, o, n) -> this.selectedAlleArangementChanged();
        lvwAlleArrangementer.getSelectionModel().selectedItemProperty().addListener(alleArrangementerListener);

        Button btnFjern= new Button("Fjern");
        pane.add(btnFjern, 2, 3);
        btnFjern.setOnAction(event -> fjernAction());

        Button btnTilføj= new Button("Tilføj");
        pane.add(btnTilføj, 3, 3);
        btnTilføj.setOnAction(event -> tilføjAction());

        pane.add(txfNav, 2, 0);
        pane.add(txfEmail, 2, 1);
    }

    private void tilføjAction() {
        if (selectedAlleArrangement != null) {
           try {
               Controller.addArrangementToTutor(selectedAlleArrangement, selectedTutor);
               updateControls();
           } catch (RuntimeException e) {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Fejl");
               alert.setHeaderText("Arrangement kunne ikke tilføjes.");
               alert.setContentText(e.getMessage());
               alert.show();
           }
        }
    }

    private void fjernAction() {
        if (selectedTilknyttetArrangement != null) {
            selectedTutor.removeArrangement(selectedTilknyttetArrangement);
            updateControls();
        }
    }

    private void selectedAlleArangementChanged() {
        selectedAlleArrangement = lvwAlleArrangementer.getSelectionModel().getSelectedItem();
    }

    private void selectedTilknyttetArrangementChanged() {
        selectedTilknyttetArrangement = lvwTilknyttedeArrangementer.getSelectionModel().getSelectedItem();
    }

    private void selectedTutorChanged() {
        selectedTutor = lvwTutor.getSelectionModel().getSelectedItem();
        updateControls();
    }

    private void updateControls() {
        if (selectedTutor != null) {
            txfNav.setText(selectedTutor.getNavn());
            txfEmail.setText(selectedTutor.getEmail());
            lvwTilknyttedeArrangementer.getItems().setAll(selectedTutor.getArrangementer());
        } else {
            txfNav.clear();
            txfEmail.clear();
            lvwTilknyttedeArrangementer.getItems().clear();
        }
    }
}
