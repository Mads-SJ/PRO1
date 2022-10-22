package opg5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Degree Converter");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField textField = new TextField();

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components 
		pane.setHgap(10);
		// set vertical gap between components 
		pane.setVgap(10);

		Label lblName = new Label("Degrees:");
		pane.add(lblName, 0, 0);

		pane.add(textField, 1, 0);

		Button celsiusBtn = new Button("Celsius");
		pane.add(celsiusBtn, 0, 1);
		celsiusBtn.setOnAction(event -> convertToCelsiusAction());
		GridPane.setMargin(celsiusBtn, new Insets(10, 10, 0, 10));

		Button fahrenheitBtn = new Button("Fahrenheit");
		pane.add(fahrenheitBtn, 1, 1);
		fahrenheitBtn.setOnAction(event -> convertToFahrenheitAction());
		GridPane.setMargin(fahrenheitBtn, new Insets(10, 10, 0, 10));
	}

	public void convertToCelsiusAction() {
		double degree = Double.parseDouble(textField.getText());
		textField.setText("" + (degree - 32) * 5.0 / 9.0);
	}

	public void convertToFahrenheitAction() {
		double degree = Double.parseDouble(textField.getText());
		textField.setText("" + (9.0 / 5.0 * degree + 32));
	}
}
