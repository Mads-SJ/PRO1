package guifx;

import application.controller.Controller;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;

public class StartWindow extends Application {

	
	@Override
	public void init() {
		Controller.init();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Konference Administrationssystem (KAS)");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tabKonferencer = new Tab("Konferencer");
		tabPane.getTabs().add(tabKonferencer);
		KonferencePane konferencePane = new KonferencePane();
		tabKonferencer.setContent(konferencePane);

		Tab tabHoteller = new Tab("Hoteller");
		tabPane.getTabs().add(tabHoteller);
		HotelPane hotelPane = new HotelPane();
		tabHoteller.setContent(hotelPane);

		Tab tabTilmeldinger = new Tab("Tilmeldinger");
		tabPane.getTabs().add(tabTilmeldinger);
		TilmeldingsPane tilmeldingsPane = new TilmeldingsPane();
		tabTilmeldinger.setContent(tilmeldingsPane);
		//tabKonferencer.setOnSelectionChanged(event -> );

//		Tab tabCompanies = new Tab("Companies");
//		tabPane.getTabs().add(tabCompanies);
//
//		CompanyPane companyPane = new CompanyPane();
//		tabCompanies.setContent(companyPane);
//		tabCompanies.setOnSelectionChanged(event -> companyPane.updateControls());
//
//		Tab tabEmployees = new Tab("Employees");
//		tabPane.getTabs().add(tabEmployees);
//
//		EmployeePane employeePane = new EmployeePane();
//		tabEmployees.setContent(employeePane);
//		tabEmployees.setOnSelectionChanged(event -> employeePane.updateControls());


	}

}
