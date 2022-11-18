package guifx;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.List;

public class HotelPane extends GridPane {
    private final TextField txfNavn, txfEnkeltPris, txfDobbeltPris, txfLokation;
    private Hotel selectedHotel;

    private final ListView<Hotel> lvHoteller = new ListView<>();
    private final ListView<Service> lvServices = new ListView<>();
    public HotelPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblHoteller = new Label("Hoteller");
        this.add(lblHoteller, 0,0);

        lvHoteller.getItems().setAll(Controller.getHoteller());
        lvHoteller.setPrefHeight(200);
        this.add(lvHoteller, 0, 1, 1, 6);
        ChangeListener<Hotel> listener = (ov, oldCompny, newCompany) -> this.selectedHotelChanged();
        lvHoteller.getSelectionModel().selectedItemProperty().addListener(listener);

        lvServices.setPrefHeight(200);
        this.add(lvServices, 2, 5);

        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        this.add(separator, 1, 0, 1, 7);

        Label lblNavn = new Label("Navn");
        this.add(lblNavn, 2, 0);
        txfNavn = new TextField();
        txfNavn.setEditable(false);
        this.add(txfNavn, 2, 1);

        Label lblLokation = new Label("Lokation");
        this.add(lblLokation, 3, 0);
        txfLokation = new TextField();
        txfLokation.setEditable(false);
        this.add(txfLokation, 3, 1);

        Label lblEnkeltPris = new Label("Enkeltværelse pris (pr. nat)");
        this.add(lblEnkeltPris, 2, 2);
        txfEnkeltPris = new TextField();
        txfEnkeltPris.setEditable(false);
        this.add(txfEnkeltPris, 2, 3);

        Label lblDobbeltPris = new Label("Dobbeltværelse pris (pr. nat)");
        this.add(lblDobbeltPris, 3, 2);
        txfDobbeltPris = new TextField();
        txfDobbeltPris.setEditable(false);
        this.add(txfDobbeltPris, 3, 3);

        Label lblServices = new Label("Services");
        this.add(lblServices, 2, 4);

        Button btnNyService = new Button("Ny service...");
        this.add(btnNyService, 3, 5);
        btnNyService.setOnAction(event -> nyServiceAction());

        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 0, 7);
        btnOpret.setOnAction(event -> nytHotelAction());
    }

    private void nytHotelAction() {
        NytHotelWindow nytHotelWindow = new NytHotelWindow("Nyt Hotel");
        nytHotelWindow.showAndWait();

        lvHoteller.getItems().setAll(Controller.getHoteller());
    }

    private void nyServiceAction() {
        NyServiceWindow nyServiceWindow = new NyServiceWindow("Ny Service", selectedHotel);
        nyServiceWindow.showAndWait();

        lvServices.getItems().setAll(selectedHotel.getServices());
    }

    private void selectedHotelChanged() {
        selectedHotel = lvHoteller.getSelectionModel().getSelectedItem();
        updateControls();
    }

    private void updateControls() {
        if (selectedHotel != null) {
            txfNavn.setText(selectedHotel.getNavn());
            txfLokation.setText(selectedHotel.getLokation());
            txfEnkeltPris.setText("" + selectedHotel.getEnkeltDagspris());
            txfDobbeltPris.setText("" + selectedHotel.getDobbeltDagspris());
            lvServices.getItems().setAll(selectedHotel.getServices());
        }
    }
}
