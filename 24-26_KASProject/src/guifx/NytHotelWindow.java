package guifx;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Service;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NytHotelWindow extends Stage {
    TextField txfNavn, txfEnkeltPris, txfDobbeltPris, txfLokation;
    private Hotel hotel;

    public NytHotelWindow(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.hotel = null;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 0, 0);
        txfNavn = new TextField();
        pane.add(txfNavn, 0, 1);

        Label lblLokation = new Label("Lokation");
        pane.add(lblLokation, 1, 0);
        txfLokation = new TextField();
        pane.add(txfLokation, 1, 1);

        Label lblEnkeltPris = new Label("Enkeltværelse pris (pr. nat)");
        pane.add(lblEnkeltPris, 0, 2);
        txfEnkeltPris = new TextField();
        pane.add(txfEnkeltPris, 0, 3);

        Label lblDobbeltPris = new Label("Dobbeltværelse pris (pr. nat)");
        pane.add(lblDobbeltPris, 1, 2);
        txfDobbeltPris = new TextField();
        pane.add(txfDobbeltPris, 1, 3);

        Button btnCancel = new Button("Annullèr");
        pane.add(btnCancel, 0, 4);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOk = new Button("Ok");
        pane.add(btnOk, 1,4);
        btnOk.setOnAction(event -> okAction());
    }

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String navn = txfNavn.getText();
        String lokation = txfLokation.getText();
        double enkeltPris = Double.parseDouble(txfEnkeltPris.getText());
        double dobbeltPris = Double.parseDouble(txfDobbeltPris.getText());

        Controller.createHotel(navn, enkeltPris, dobbeltPris, lokation);

        this.hide();
    }
}
