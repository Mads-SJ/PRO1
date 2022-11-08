package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import application.model.Employee;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerWindow extends Stage {
	private Customer customer;

	public CustomerWindow(String title, Customer customer) {
		initStyle(StageStyle.UTILITY);
		initModality(Modality.APPLICATION_MODAL);
		setResizable(false);

		this.customer = customer;

		setTitle(title);
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	public CustomerWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private ComboBox<Company> cbbCompany;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblName = new Label("Name");
		pane.add(lblName, 0, 0);

		txfName = new TextField();
		pane.add(txfName, 0, 1);
		txfName.setPrefWidth(200);

		Label lblCompany = new Label("Company");
		pane.add(lblCompany, 0, 2);

		cbbCompany = new ComboBox<>();
		pane.add(cbbCompany, 0, 3);
		cbbCompany.getItems().addAll(Controller.getCompanies());

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 4);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 4);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> okAction());

		lblError = new Label();
		pane.add(lblError, 0, 5);
		lblError.setStyle("-fx-text-fill: red");
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		hide();
	}

	private void okAction() {
		String name = txfName.getText().trim();
		Company company = cbbCompany.getSelectionModel().getSelectedItem();
		if (name.length() == 0) {
			lblError.setText("Name is empty");
		} else {
			Customer customer = Controller.createCustomer(name);
			if (company != null) {
				Controller.addCustomerToCompany(customer, company);
			}
			hide();
		}
	}

}
