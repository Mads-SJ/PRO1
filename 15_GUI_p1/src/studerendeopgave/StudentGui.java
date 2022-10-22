package studerendeopgave;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentGui extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Administrer studerende");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfName = new TextField();
	private final TextField txfAge = new TextField();
	private final CheckBox chkActive = new CheckBox();
	private final TextArea txAInf = new TextArea();
	private final Button btnBirthday = new Button("Fødselsdag");
	private final Button btnAdd = new Button("Opret");
	private final Button btnSave = new Button("Gem");
	private final Button btnGet = new Button("Hent");
	private final Button btnDelete = new Button("Slet");

	private Student studerende = null;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		txAInf.setEditable(false);
		txAInf.setPrefWidth(200);
		txAInf.setPrefHeight(60);
		pane.add(txAInf, 0, 0, 5, 1);

		Label lblName = new Label("Navn");
		pane.add(lblName, 0, 1);
		Label lblAge = new Label("Alder");
		pane.add(lblAge, 0, 2);
		Label lblActive = new Label("Aktiv");
		pane.add(lblActive, 0, 3);

		pane.add(txfName, 1, 1, 4, 1);
		pane.add(txfAge, 1, 2, 3, 1);
		pane.add(chkActive, 1, 3);

		// add a buttons to the pane
		btnBirthday.setDisable(true);
		pane.add(btnBirthday, 4, 2);

		pane.add(btnAdd, 0, 5);
		
		btnSave.setDisable(true);
		pane.add(btnSave, 1, 5);
		
		btnGet.setDisable(true);
		pane.add(btnGet, 2, 5);
		
		pane.add(btnDelete, 3, 5);
		btnDelete.setDisable(true);

		// connect a method to the button
		btnBirthday.setOnAction(event -> this.birthdayAction());
		btnAdd.setOnAction(event -> this.addAction());
		btnSave.setOnAction(event -> this.saveAction());
		btnGet.setOnAction(event -> this.getAction());
		btnDelete.setOnAction(event -> this.deleteAction());

	}

	private void addAction() {
		if (studerende == null) {
			studerende = new Student(txfName.getText().trim(), Integer.parseInt(txfAge.getText().trim()), chkActive.isSelected());
			clearFields();
			txAInf.setText(getDescription());
			btnGet.setDisable(false);
			btnAdd.setDisable(true);
			btnBirthday.setDisable(false);
		}

	}

	private void saveAction() {
		if (studerende != null) {
			studerende.setName(txfName.getText().trim());
			studerende.setAge(Integer.parseInt(txfAge.getText().trim()));
			studerende.setActive(chkActive.isSelected());
			clearFields();
			txAInf.setText(getDescription());
			btnSave.setDisable(true);
			btnDelete.setDisable(true);
			btnGet.setDisable(false);
			btnBirthday.setDisable(false);
		}

	}

	private void getAction() {
		if (studerende != null) {
			txfName.setText(studerende.getName());
			txfAge.setText("" + studerende.getAge());
			chkActive.setSelected(studerende.isActive());
			txAInf.setText(getDescription());
			btnSave.setDisable(false);
			btnDelete.setDisable(false);
			btnGet.setDisable(true);
			btnBirthday.setDisable(true);
		}

	}

	private void deleteAction() {
		if (studerende != null) {
			studerende = null;
			clearFields();
			txAInf.clear();
			btnDelete.setDisable(true);
			btnSave.setDisable(true);
			btnGet.setDisable(true);
			btnAdd.setDisable(false);
			btnBirthday.setDisable(true);
		}
	}

	private void birthdayAction() {
		if (studerende != null) {
			studerende.increaseAge();
		}
	}

	private void clearFields() {
		txfName.clear();
		txfAge.clear();
		chkActive.setSelected(false);
	}

	private String getDescription() {
		String result = "Ingen studerende gemt";
		if (studerende != null) {
			result = studerende.toString();
		}
		return result;
	}

}
