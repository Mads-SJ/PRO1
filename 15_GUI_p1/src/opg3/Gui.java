package opg3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
	@Override
	public void start(Stage stage) {
		stage.setTitle("Split text");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfName1 = new TextField();
	private final TextField txfName2 = new TextField();
	private final TextField txfNameCombined = new TextField();

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components 
		pane.setHgap(10);
		// set vertical gap between components 
		pane.setVgap(10);

		pane.add(txfNameCombined, 0, 0, 2, 1);
		pane.add(txfName1, 0, 1);
		pane.add(txfName2, 1, 1);

		// add a button to the pane (at col=1, row=1)
		Button btn = new Button("Split");
		pane.add(btn, 0, 2);
		btn.setOnAction(event -> splitAction());
		GridPane.setMargin(btn, new Insets(10, 10, 0, 10));
	}

	public void splitAction() {
		String[] names = txfNameCombined.getText().trim().split(" ");
		txfName1.setText(names[0]);
		txfName2.setText(names[1]);
	}
}
