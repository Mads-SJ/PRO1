package semesterprøve_PRO1_januar_2023.gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import semesterprøve_PRO1_januar_2023.application.controller.Controller;
import semesterprøve_PRO1_januar_2023.application.model.Salgsannonce;
import semesterprøve_PRO1_januar_2023.application.model.Vare;

import java.util.ArrayList;
import java.util.List;


public class Gui extends Application {

    @Override
    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Handelsplatform");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Salgsannonce> lvwSalgsannoncer = new ListView<>();
    private final ListView<Vare> lvwVarer = new ListView<>();
    private final TextField txfKøber = new TextField();
    private final TextField txfAftaltPris = new TextField();
    private final TextField txfFilNavn = new TextField();
    private Salgsannonce selectedSalgsannonce;
    private void initContent(GridPane pane) {

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblAktiveAnnoncer = new Label("Aktive Annoncer");
        pane.add(lblAktiveAnnoncer, 0, 0);

        Label lblVarer = new Label("Varer");
        pane.add(lblVarer, 1, 0);

        Label lblKøber = new Label("Køber");
        pane.add(lblKøber, 2, 1);

        Label lblAftaltPris = new Label("Aftalt pris");
        pane.add(lblAftaltPris, 2, 2);

        Label lblFilNavn = new Label("Fil navn");
        pane.add(lblFilNavn, 2, 6);

        pane.add(lvwSalgsannoncer, 0, 1, 1, 4);
        lvwSalgsannoncer.setPrefWidth(300);
        lvwSalgsannoncer.setPrefHeight(200);
        lvwSalgsannoncer.getItems().setAll(Controller.getAktiveSalgsannoncer());
        ChangeListener<Salgsannonce> salgsannonceChangeListener = (ov, o, n) -> this.selectedSalgsannonceChanged();
        lvwSalgsannoncer.getSelectionModel().selectedItemProperty().addListener(salgsannonceChangeListener);

        pane.add(lvwVarer, 1, 1, 1, 4);
        lvwVarer.setPrefWidth(300);
        lvwVarer.setPrefHeight(200);
        lvwVarer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button btnOpretSalg= new Button("Opret salg");
        pane.add(btnOpretSalg, 2, 3);
        btnOpretSalg.setOnAction(event -> opretSalgAction());

        Button btnSalgsFil= new Button("Salgs fil");
        pane.add(btnSalgsFil, 2, 7);
        btnSalgsFil.setOnAction(event -> salgsFilAction());

        pane.add(txfKøber, 3, 1);
        pane.add(txfAftaltPris, 3, 2);
        pane.add(txfFilNavn, 3, 6);
    }

    private void salgsFilAction() {
        Controller.salgTilFil(txfFilNavn.getText());
        txfFilNavn.clear();
    }

    private void opretSalgAction() {
        String køber = txfKøber.getText().trim();
        String aftaltPris = txfAftaltPris.getText().trim();
        List<Vare> valgteVarer = lvwVarer.getSelectionModel().getSelectedItems();
        ArrayList<Vare> valgteVarer2 = new ArrayList<>();
        valgteVarer2.addAll(valgteVarer);


        if (køber.length() > 0 && aftaltPris.length() > 0 && erAlleValgteVarerTilSalg(valgteVarer)) {
            Controller.createSalg(køber, Integer.parseInt(aftaltPris), valgteVarer2);
            selectedSalgsannonce = null;
            updateControls();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Opret salg");
            alert.setHeaderText("Salget kunne ikke oprettes.");
            alert.setContentText("Tjek at alle valgte varer er til salg og at køber og aftalt pris er udfyldt.");
            alert.show();
        }
    }

    private void selectedSalgsannonceChanged() {
        selectedSalgsannonce = lvwSalgsannoncer.getSelectionModel().getSelectedItem();
        updateControls();
    }

    private void updateControls() {
        if (selectedSalgsannonce != null) {
            lvwVarer.getItems().setAll(selectedSalgsannonce.getVarer());
        } else {
            lvwSalgsannoncer.getItems().setAll(Controller.getAktiveSalgsannoncer());
            lvwVarer.getItems().clear();
            txfKøber.clear();
            txfAftaltPris.clear();
        }
    }

    private boolean erAlleValgteVarerTilSalg(List<Vare> valgteVarer) {
        boolean erAlleTilSalg = true;
        int i = 0;
        while (erAlleTilSalg && i < valgteVarer.size()) {
            Vare vare = valgteVarer.get(i);
            if (vare.isSolgt()) {
                erAlleTilSalg = false;
            }
            i++;
        }
        return erAlleTilSalg;
    }
}
