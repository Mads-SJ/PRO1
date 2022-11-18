package guifx;

import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TilmeldingsPane extends GridPane {
    private TextField txfStartDato, txfSlutDato, txfNavn, txfTlf, txfBy, txfLand, txfFirma, txfFirmaTlf, txfLedsagerNavn;

    private CheckBox cbHotel, cbLedsager, cbForedragsholder;

    private ListView<Konference> lvwKonferencer;

    private ListView<Udflugt> lvwUdflugter;

    private ListView<Hotel> lvwHoteller;

    private ListView<Service> lvwServices;

    private Konference valgtKonference;

    private Hotel valgtHotel;

    private Udflugt valgtUdflugt;

    private DatePicker vaelgAnkomstDato;

    private DatePicker vaelgAfrejseDato;

    public TilmeldingsPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblKonference = new Label("Konferencer:");
        this.add(lblKonference, 0, 0);

        lvwKonferencer = new ListView<>();
        this.add(lvwKonferencer, 0, 1,1,15);
        lvwKonferencer.setPrefWidth(200);
        lvwKonferencer.setPrefHeight(200);
        lvwKonferencer.getItems().setAll(Controller.getKonferencer());
        ChangeListener<Konference> listenerK = (ov, oldKonference, newKonference) -> this.selectedKonferenceChange();
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listenerK);


        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        this.add(separator,1,0,1,22);

        Label lblKonVarighed = new Label("Start- og Slutdato");
        this.add(lblKonVarighed,2,0);

        txfStartDato = new TextField();
        this.add(txfStartDato,3,0);
        txfStartDato.setPrefWidth(50);
        txfStartDato.setEditable(false);

        Label lblStreg = new Label("til");
        this.add(lblStreg,4,0);

        txfSlutDato = new TextField();
        this.add(txfSlutDato,5,0);
        txfSlutDato.setPrefWidth(50);
        txfSlutDato.setEditable(false);

        Separator separator1 = new Separator();
        separator1.setOrientation(Orientation.HORIZONTAL);
        this.add(separator1,2,1,5,1);

        Label lblNavn = new Label("Navn:");
        this.add(lblNavn,2,2);

        txfNavn = new TextField();
        this.add(txfNavn,3,2);
        txfNavn.setPrefWidth(75);
        txfNavn.setDisable(true);

        Label lblTlf = new Label("TlfNr.: ");
        this.add(lblTlf,4,2);

        txfTlf = new TextField();
        this.add(txfTlf,5,2);
        txfTlf.setPrefWidth(100);
        txfTlf.setDisable(true);

        Label lblBy = new Label("By: ");
        this.add(lblBy,2,3);

        txfBy = new TextField();
        this.add(txfBy,3,3);
        txfBy.setPrefWidth(50);
        txfBy.setDisable(true);

        Label lblLand = new Label("Land: ");
        this.add(lblLand,4,3);

        txfLand = new TextField();
        this.add(txfLand,5,3);
        txfLand.setPrefWidth(50);
        txfLand.setDisable(true);

        Label lblFirma = new Label("Firma: ");
        this.add(lblFirma,2,4);

        txfFirma = new TextField();
        this.add(txfFirma,3,4);
        txfFirma.setPrefWidth(50);
        txfFirma.setDisable(true);

        Label lblFirmaTlf = new Label("FirmaTlf: ");
        this.add(lblFirmaTlf,4,4);

        txfFirmaTlf = new TextField();
        this.add(txfFirmaTlf,5,4);
        txfFirmaTlf.setPrefWidth(50);
        txfFirmaTlf.setDisable(true);

        Label lblAnkomstDato = new Label("Ankomstdato: ");
        this.add(lblAnkomstDato,2,5);

        vaelgAnkomstDato = new DatePicker();
        this.add(vaelgAnkomstDato,3,5);
        vaelgAnkomstDato.setDisable(true);

        Label lblAfrejseDato = new Label("Afrejsedato: ");
        this.add(lblAfrejseDato,4,5);

        vaelgAfrejseDato = new DatePicker();
        this.add(vaelgAfrejseDato,5,5);
        vaelgAfrejseDato.setDisable(true);

        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.HORIZONTAL);
        this.add(separator2,2,6,5,1);

        Label lblForedragsholder = new Label("Foredragsholder: ");
        this.add(lblForedragsholder,2,7);

        cbForedragsholder = new CheckBox();
        this.add(cbForedragsholder,3,7);
        cbForedragsholder.setDisable(true);

        Separator separator3 = new Separator();
        separator3.setOrientation(Orientation.HORIZONTAL);
        this.add(separator3,2,8,5,1);

        Label lblLedsager = new Label("Ledsager: ");
        this.add(lblLedsager,2,9);

        cbLedsager = new CheckBox();
        this.add(cbLedsager,3,9);
        cbLedsager.selectedProperty().addListener((ov, old, n) -> chbLedsagerChange());
        cbLedsager.setDisable(true);

        Label lblLedsagerNavn = new Label("Ledsagernavn: ");
        this.add(lblLedsagerNavn,2,10);

        txfLedsagerNavn = new TextField();
        this.add(txfLedsagerNavn,3,10);
        txfLedsagerNavn.setPrefWidth(50);
        txfLedsagerNavn.setDisable(true);

        Label lblUdflugt = new Label("Udflugt: ");
        this.add(lblUdflugt,4,9);

        lvwUdflugter = new ListView<>();
        this.add(lvwUdflugter, 4, 10,2,4);
        lvwUdflugter.setPrefWidth(200);
        lvwUdflugter.setPrefHeight(200);
        lvwUdflugter.setDisable(true);
        lvwUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Separator separator4 = new Separator();
        separator4.setOrientation(Orientation.HORIZONTAL);
        this.add(separator4,2,14,5,1);

        Label lblHotel = new Label("Hotel: ");
        this.add(lblHotel,2,15);

        cbHotel = new CheckBox();
        this.add(cbHotel,3,15);
        cbHotel.setDisable(true);

        cbHotel.selectedProperty().addListener((ov, old, n) -> chbHotelChange());

        Label lblHoteller = new Label("Hoteller: ");
        this.add(lblHoteller,2,16);

        lvwHoteller = new ListView<>();
        this.add(lvwHoteller,2,17,2,3);
        lvwHoteller.setPrefWidth(200);
        lvwHoteller.setPrefHeight(200);
        ChangeListener<Hotel> listenerH = (ov, oldHotel, newHotel) -> this.selectedHotelChange();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listenerH);
        lvwHoteller.setDisable(true);

        Label lblServices = new Label("Services: ");
        this.add(lblServices,4,16);

        lvwServices = new ListView<>();
        this.add(lvwServices,4,17,2,3);
        lvwServices.setPrefWidth(200);
        lvwServices.setPrefHeight(200);
        lvwServices.setDisable(true);
        lvwServices.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons,4,21,3,1);
        hbxButtons.setPadding(new Insets(10,0,0,0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnOpret = new Button("Opret");
        hbxButtons.getChildren().add(btnOpret);
        btnOpret.setOnAction(event -> this.createTilmelding());
    }

    private void selectedKonferenceChange() {
        valgtKonference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (valgtKonference != null) {
            txfStartDato.setText("" + valgtKonference.getStartDato());
            txfSlutDato.setText("" + valgtKonference.getSlutDato());
            vaelgAnkomstDato.setValue(valgtKonference.getStartDato());
            vaelgAfrejseDato.setValue(valgtKonference.getSlutDato());
            txfNavn.setDisable(false);
            txfTlf.setDisable(false);
            txfBy.setDisable(false);
            txfLand.setDisable(false);
            txfFirma.setDisable(false);
            txfFirmaTlf.setDisable(false);
            cbLedsager.setDisable(false);
            cbForedragsholder.setDisable(false);
            cbHotel.setDisable(false);
            vaelgAnkomstDato.setDisable(false);
            vaelgAfrejseDato.setDisable(false);

        } else {
            txfStartDato.clear();
            txfSlutDato.clear();
            txfFirmaTlf.clear();
            txfLand.clear();
            txfFirma.clear();
            txfTlf.clear();
            txfLedsagerNavn.clear();
            txfNavn.clear();
            txfBy.clear();
        }
    }

    private void selectedHotelChange() {
        valgtHotel = lvwHoteller.getSelectionModel().getSelectedItem();
        if (valgtHotel != null) {
            lvwServices.getItems().setAll(valgtHotel.getServices());
        } else {
            lvwServices.getItems().setAll(Collections.emptyList());
        }
    }

    private void chbLedsagerChange() {
        boolean ledIsSelected = cbLedsager.isSelected();
        txfLedsagerNavn.setDisable(!ledIsSelected);
        lvwUdflugter.setDisable(!ledIsSelected);
        lvwUdflugter.getItems().setAll(valgtKonference.getUdflugter());
        if (!ledIsSelected) {
            lvwUdflugter.getItems().setAll(Collections.emptyList());
            txfLedsagerNavn.clear();
        }
    }

    private void chbHotelChange() {
        boolean hotIsSelected = cbHotel.isSelected();
        lvwHoteller.setDisable(!hotIsSelected);
        lvwServices.setDisable(!hotIsSelected);
        lvwHoteller.getItems().setAll(valgtKonference.getHoteller());
        if (!hotIsSelected) {
           lvwServices.getItems().setAll(Collections.emptyList());
           lvwHoteller.getItems().setAll(Collections.emptyList());
        }
    }

    private void createTilmelding() {
        String navn = txfNavn.getText();
        String tlf = txfTlf.getText();
        String by = txfBy.getText();
        String land = txfLand.getText();
        String firma = txfFirma.getText();
        String firmaTlf = txfFirmaTlf.getText();

        Deltager deltager = Controller.createDeltager(navn,tlf,by,land,firma,firmaTlf);

        boolean isForedragsholder = cbForedragsholder.isSelected();

        LocalDate afrejseDato = vaelgAfrejseDato.getValue();
        LocalDate ankomstDato = vaelgAnkomstDato.getValue();

        Tilmelding tilmelding = Controller.createTilmelding(isForedragsholder,ankomstDato,afrejseDato,deltager,valgtKonference);

        if (cbLedsager.isSelected()) {
            String ledsagerNavn = txfLedsagerNavn.getText();
            Ledsager ledsager = Controller.createLedsager(ledsagerNavn,tilmelding);
            List<Udflugt> valgteUdflugter = lvwUdflugter.getSelectionModel().getSelectedItems();
            Controller.addUdflugterToLedsager(valgteUdflugter,ledsager);
        }

        if (cbHotel.isSelected()) {


            valgtHotel = lvwHoteller.getSelectionModel().getSelectedItem();
            Controller.setHotelForTilmelding(valgtHotel,tilmelding);
            List<Service> valgteServices = lvwServices.getSelectionModel().getSelectedItems();
            Controller.addServicesToTilmelding(valgteServices,tilmelding);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ordrebekræftelse");
        alert.setHeaderText("Tak for din tilmelding. Ønsker De at afmelde, er det bare ærgeligt");
        Optional<ButtonType> result = alert.showAndWait();

        clearTilmelding();
    }

    public void clearTilmelding() {
        txfStartDato.clear();
        txfSlutDato.clear();
        txfFirmaTlf.clear();
        txfLand.clear();
        txfFirma.clear();
        txfTlf.clear();
        txfLedsagerNavn.clear();
        txfNavn.clear();
        txfBy.clear();
        txfBy.setDisable(true);
        txfNavn.setDisable(true);
        txfTlf.setDisable(true);
        txfFirma.setDisable(true);
        txfLedsagerNavn.setDisable(true);
        txfFirmaTlf.setDisable(true);
        vaelgAfrejseDato.setValue(null);
        vaelgAnkomstDato.setValue(null);
        cbHotel.setDisable(true);
        cbForedragsholder.setDisable(true);
        cbLedsager.setDisable(true);
        cbLedsager.setSelected(false);
        cbHotel.setSelected(false);
        cbForedragsholder.setSelected(false);
        lvwServices.getItems().setAll(Collections.emptyList());
        lvwUdflugter.getItems().setAll(Collections.emptyList());
        lvwHoteller.getItems().setAll(Collections.emptyList());
        lvwHoteller.setDisable(true);
        lvwUdflugter.setDisable(true);
        lvwServices.setDisable(true);
        lvwKonferencer.getSelectionModel().clearSelection();
    }
}
