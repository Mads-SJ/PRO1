package opg1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

  
    @Override
    public void start(Stage stage) {
        stage.setTitle("Person Administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox checkBox = new CheckBox();

    private void initContent(GridPane pane) {
        this.initPersons();

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);

        Label lblSenior = new Label("Senior");
        pane.add(lblSenior, 2, 2);

        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 3);

        pane.add(txfName, 1, 0, 2, 1);
        pane.add(txfTitle, 1, 1, 2, 1);
        pane.add(checkBox, 1, 2);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 3, 2, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add person");
        pane.add(btnAdd, 6, 2);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        if (name.length() > 0) {
            Person p = new Person(name, "Hansen", name + "@mail.com");
            persons.add(p);
            lvwPersons.getItems().setAll(persons);
        }
    }

    private void initPersons() {
        persons.add(new Person("Jens", "Jensen", "jens@eaaa.dk"));
        persons.add(new Person("Hans", "Hansen", "hans@eaaa.dk"));
        persons.add(new Person("Pia", "Peters", "pia @eaaa.dk"));
    }

    // -------------------------------------------------------------------------
    // Selection changed action

    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getFirstName());
        } else {
            txfName.clear();
        }
    }
}
