package guifx;

import application.model.Konference;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class KonferencePane extends GridPane {
    Label lblKonference = new Label("Konferencer");

    public KonferencePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.add(lblKonference, 0,0);
    }
}
