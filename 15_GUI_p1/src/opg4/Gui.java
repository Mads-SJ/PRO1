package opg4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Count");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField textField = new TextField("50");

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components 
		pane.setHgap(10);
		// set vertical gap between components 
		pane.setVgap(10);

		Label lblName = new Label("Number:");
		pane.add(lblName, 0, 1);

		pane.add(textField, 1, 1);

		Button plusBtn = new Button("+");
		pane.add(plusBtn, 2, 0);
		plusBtn.setOnAction(event -> plusAction());
		GridPane.setMargin(plusBtn, new Insets(10, 10, 0, 10));

		Button minusBtn = new Button("-");
		pane.add(minusBtn, 2, 2);
		minusBtn.setOnAction(event -> minusAction());
		GridPane.setMargin(minusBtn, new Insets(10, 10, 0, 10));
	}

	public void plusAction() {
		int count = Integer.parseInt(textField.getText());
		textField.setText("" + ++count);
	}

	public void minusAction() {
		int count = Integer.parseInt(textField.getText());
		textField.setText("" + --count);
	}
}
