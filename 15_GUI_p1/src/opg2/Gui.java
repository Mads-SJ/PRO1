package opg2;

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
		stage.setTitle("Swap frame");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfName1 = new TextField();;
	private final TextField txfName2 = new TextField();;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components 
		pane.setHgap(10);
		// set vertical gap between components 
		pane.setVgap(10);

		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		pane.add(txfName1, 0, 0);
		pane.add(txfName2, 0, 1);

		// add a button to the pane (at col=1, row=1)
		Button btn = new Button("Ombyt");
		pane.add(btn, 0, 2);
		btn.setOnAction(event -> switchAction());
		GridPane.setMargin(btn, new Insets(10, 10, 0, 10));
	}

	public void switchAction() {
		String name1 = txfName1.getText().trim();
		String name2 = txfName2.getText().trim();
		txfName1.setText(name2);
		txfName2.setText(name1);
	}
}
