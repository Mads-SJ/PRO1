package guifx;

import application.model.Service;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NyServiceWindow extends Stage {
    private Service service;

    public NyServiceWindow(String title, Service service) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.service = service;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public NyServiceWindow(String title) {
        this(title, null);
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
        pane.add(txfService, 0, 1);

        Label lblPris = new Label("Pris");
        pane.add(lblPris, 0, 2);
        pane.add(txfPris, 0, 3);
    }
}
