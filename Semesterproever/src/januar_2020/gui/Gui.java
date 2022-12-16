package januar_2020.gui;

import januar_2020.model.Festival;
import januar_2020.model.Frivillig;
import januar_2020.model.Job;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import januar_2020.controller.Controller;


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

    private final ListView<Festival> lvwFestival = new ListView<>();
    private final ListView<Job> lvwJobs = new ListView<>();
    private final ListView<Frivillig> lvwFrivillige = new ListView<>();
    private final TextField txfTimer = new TextField();
    private final TextArea txfaTildelteJobs = new TextArea();
    private Job selectedJob;
    private Frivillig selectedFrivillig;
    private void initContent(GridPane pane) {

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblFestivaller = new Label("Festivaller");
        pane.add(lblFestivaller, 0, 0);

        Label lblJobs = new Label("Jobs");
        pane.add(lblJobs, 1, 0);

        Label lblFrivillige = new Label("Frivillige");
        pane.add(lblFrivillige, 2, 0);

        Label lblTildelteJobs = new Label("Tildelte jobs");
        pane.add(lblTildelteJobs, 4, 0);

        Label lblTimer = new Label("Timer");
        pane.add(lblTimer, 2, 2);

        pane.add(lvwFestival, 0, 1);
        lvwFestival.setPrefWidth(300);
        lvwFestival.setPrefHeight(200);
        lvwFestival.getItems().setAll(Controller.getFestivaller());
        ChangeListener<Festival> festivalListener = (ov, o, n) -> this.selectedFestivalChanged();
        lvwFestival.getSelectionModel().selectedItemProperty().addListener(festivalListener);

        pane.add(lvwJobs, 1, 1);
        lvwJobs.setPrefWidth(300);
        lvwJobs.setPrefHeight(200);
        ChangeListener<Job> jobListener = (ov, o, n) -> this.selectedJobChanged();
        lvwJobs.getSelectionModel().selectedItemProperty().addListener(jobListener);


        pane.add(lvwFrivillige, 2, 1, 2, 1);
        lvwFrivillige.setPrefWidth(300);
        lvwFrivillige.setPrefHeight(200);
        lvwFrivillige.getItems().setAll(Controller.getFrivillige());
        ChangeListener<Frivillig> frivilligListener = (ov, o, n) -> this.selectedFrivilligChanged();
        lvwFrivillige.getSelectionModel().selectedItemProperty().addListener(frivilligListener);

        pane.add(txfaTildelteJobs, 4, 1);


        pane.add(txfTimer, 3, 2);

        Button btnTagVagt = new Button("Tag vagt");
        pane.add(btnTagVagt, 4, 2);
        btnTagVagt.setOnAction(event -> tagVagtAction());
    }

    private void tagVagtAction() {
        int timer = Integer.parseInt(txfTimer.getText());

        try {
            Controller.tagVagt(selectedJob, selectedFrivillig, timer);
            updateControls();
            txfTimer.clear();

        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tag vagt");
            alert.setHeaderText("Fejl ved oprettelse af vagt.");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    private void selectedFestivalChanged() {
        Festival selectedFestival = lvwFestival.getSelectionModel().getSelectedItem();
        lvwJobs.getItems().setAll(selectedFestival.getJobs());
    }

    private void selectedJobChanged() {
        selectedJob = lvwJobs.getSelectionModel().getSelectedItem();
    }

    private void selectedFrivilligChanged() {
        selectedFrivillig = lvwFrivillige.getSelectionModel().getSelectedItem();
        txfaTildelteJobs.clear();
        txfaTildelteJobs.appendText(selectedFrivillig.oversigt());
    }

    private void updateControls() {
        txfaTildelteJobs.clear();
        txfaTildelteJobs.appendText(selectedFrivillig.oversigt());
    }
}
