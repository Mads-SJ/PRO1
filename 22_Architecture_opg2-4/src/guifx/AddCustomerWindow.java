package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AddCustomerWindow extends Stage {
	private Company selectedCompany;

	public AddCustomerWindow(String title) {
		initStyle(StageStyle.UTILITY);
		initModality(Modality.APPLICATION_MODAL);
		setResizable(false);

		setTitle(title);
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	// -------------------------------------------------------------------------

	private ComboBox<Company> cbbCompany;
	private ListView<Customer> lwNotInCompany, lwInCompany;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblName = new Label("Company");
		pane.add(lblName, 0, 0);

		cbbCompany = new ComboBox<>();
		pane.add(cbbCompany, 0, 1);
		cbbCompany.getItems().addAll(Controller.getCompanies());
		cbbCompany.getSelectionModel().selectFirst();
		cbbCompany.getSelectionModel().selectedItemProperty().addListener((ov, o, n) -> this.onCompanyChange());

		lwNotInCompany = new ListView<>();
		pane.add(lwNotInCompany, 0, 2, 1, 3);
		lwNotInCompany.setPrefWidth(200);
		lwNotInCompany.setPrefHeight(200);

		lwInCompany = new ListView<>();
		pane.add(lwInCompany, 2, 2 , 1, 3);
		lwInCompany.setPrefWidth(200);
		lwInCompany.setPrefHeight(200);

		this.onCompanyChange();

		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 1, 2);
		btnAdd.setOnAction(event -> addCustomer());

		Button btnRemove = new Button("Remove");
		pane.add(btnRemove, 1, 3);
		btnRemove.setOnAction(event -> removeCustomer());

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 5);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 5);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> okAction());

		lblError = new Label();
		pane.add(lblError, 0, 6);
		lblError.setStyle("-fx-text-fill: red");
	}

	// -------------------------------------------------------------------------

	private void onCompanyChange() {
		selectedCompany = cbbCompany.getValue();
		lwInCompany.getItems().setAll(selectedCompany.getCustomers());

		ArrayList<Customer> allCustomers = Controller.getCustomers();
		allCustomers.removeAll(selectedCompany.getCustomers());

		lwNotInCompany.getItems().setAll(allCustomers);
	}

	private void addCustomer() {
		Customer selectedCustomer = lwNotInCompany.getSelectionModel().getSelectedItem();

		if (selectedCustomer != null) {
			lwInCompany.getItems().add(selectedCustomer);
			lwNotInCompany.getItems().remove(selectedCustomer);
		}
	}

	private void removeCustomer() {
		Customer selectedCustomer = lwInCompany.getSelectionModel().getSelectedItem();

		if (selectedCustomer != null) {
			lwNotInCompany.getItems().add(selectedCustomer);
			lwInCompany.getItems().remove(selectedCustomer);
		}
	}

	private void cancelAction() {
		hide();
	}

	private void okAction() {
		for (Customer c : lwNotInCompany.getItems()) {
			if (selectedCompany.getCustomers().contains(c)) {
				Controller.removeCustomerFromCompany(c, selectedCompany);
			}
		}

		for (Customer c : lwInCompany.getItems()) {
			if (!selectedCompany.getCustomers().contains(c)) {
				Controller.addCustomerToCompany(c, selectedCompany);
			}
		}

		hide();
	}

}
