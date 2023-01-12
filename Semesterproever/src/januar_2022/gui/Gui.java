package januar_2022.gui;

import januar_2022.controller.Controller;
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
        stage.setTitle("Festival administration af frivillige");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Løb> lvwLøb = new ListView<>();
    private final ListView<Tilmelding> lvwTilmeldinger = new ListView<>();
    private final ListView<Note> lvwNoter = new ListView<>();
    private final TextField txfVinder = new TextField();
    private final TextField txfForhindring = new TextField();
    private final TextField txfStrafSekunder = new TextField();
    private void initContent(GridPane pane) {

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblLøb = new Label("Løb");
        pane.add(lblLøb, 0, 0);

        Label lblTilmdelinder = new Label("Tilmeldinger");
        pane.add(lblTilmdelinder, 2, 0);

        Label lblNoter = new Label("Noter");
        pane.add(lblNoter, 4, 0);

        Label lblNavnForhindring = new Label("Navn forhindring:");
        pane.add(lblNavnForhindring, 2, 2);

        Label lblStrafSekunder = new Label("Straf sekunder:");
        pane.add(lblStrafSekunder, 2, 3);

        pane.add(lvwLøb, 0, 1, 2, 1);
        lvwLøb.setPrefWidth(300);
        lvwLøb.setPrefHeight(200);
        lvwLøb.getItems().setAll(Controller.getLøb());
        ChangeListener<Løb> løbListener = (ov, o, n) -> this.selectedFestivalChanged();
        lvwLøb.getSelectionModel().selectedItemProperty().addListener(løbListener);

        pane.add(lvwTilmeldinger, 2, 1, 2, 1);
        lvwTilmeldinger.setPrefWidth(300);
        lvwTilmeldinger.setPrefHeight(200);
        ChangeListener<Tilmelding> jobListener = (ov, o, n) -> this.selectedJobChanged();
        lvwTilmeldinger.getSelectionModel().selectedItemProperty().addListener(jobListener);


        pane.add(lvwNoter, 4, 1);
        lvwNoter.setPrefWidth(300);
        lvwNoter.setPrefHeight(200);
        ChangeListener<Note> frivilligListener = (ov, o, n) -> this.selectedFrivilligChanged();
        lvwNoter.getSelectionModel().selectedItemProperty().addListener(frivilligListener);

        Button btnRegistrerNote= new Button("Registrer note");
        pane.add(btnRegistrerNote, 4, 3);
        btnRegistrerNote.setOnAction(event -> tagVagtAction());

        Button btnVinder= new Button("Vinder");
        pane.add(btnVinder, 0, 2);
        btnVinder.setOnAction(event -> tagVagtAction());
    }

    private void tagVagtAction() {
    }

    private void selectedFestivalChanged() {
    }

    private void selectedJobChanged() {
    }

    private void selectedFrivilligChanged() {
    }

    private void updateControls() {
    }
}
