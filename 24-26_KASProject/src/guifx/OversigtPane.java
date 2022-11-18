package guifx;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Konference;
import application.model.Tilmelding;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class OversigtPane extends GridPane {
    private TextArea konferenceOversigt, hotelOversigt, udflugtOversigt;
    public OversigtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblKonferencer = new Label("Konferencer");
        this.add(lblKonferencer, 0,0);
        konferenceOversigt = new TextArea();
        this.add(konferenceOversigt, 0, 1);
        konferenceOversigt.setPrefWidth(300);
        konferenceOversigt.setPrefHeight(500);
        konferenceOversigt.setEditable(false);

        Label lblHoteller = new Label("Hoteller");
        this.add(lblHoteller, 1, 0);
        hotelOversigt = new TextArea();
        this.add(hotelOversigt, 1, 1);
        hotelOversigt.setPrefWidth(300);
        hotelOversigt.setPrefHeight(500);
        hotelOversigt.setEditable(false);

        Label lblUdflugter = new Label("Udflugter");
        this.add(lblUdflugter, 2, 0);
        udflugtOversigt = new TextArea();
        this.add(udflugtOversigt, 2, 1);
        udflugtOversigt.setPrefWidth(300);
        udflugtOversigt.setPrefHeight(500);
        udflugtOversigt.setEditable(false);

        updateTextAreas();
    }

    public void updateTextAreas() {
        konferenceOversigt.setText(Controller.getKonferenceOversigt());
        hotelOversigt.setText(Controller.getHotelOversigt());
        udflugtOversigt.setText(Controller.getUdflugtOversigt());
    }
}
