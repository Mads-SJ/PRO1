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

public class NyServiceWindow extends Stage {
    private Service service;
    private Hotel hotel;

    public NyServiceWindow(String title, Hotel hotel) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.service = null;
        this.hotel = hotel;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private TextField txfService = new TextField();
    private TextField txfPris = new TextField();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblService = new Label("Service");
        pane.add(lblService,0,0);
        pane.add(txfService, 0, 1, 2, 1);

        Label lblPris = new Label("Pris");
        pane.add(lblPris, 0, 2);
        pane.add(txfPris, 0, 3, 2, 1);

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
        String service = txfService.getText();
        double pris = Double.parseDouble(txfPris.getText());

        Controller.createService(service, pris, hotel);
        this.hide();
    }
}
