package opg1;

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
		stage.setTitle("Kombiner navne");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfName1 = new TextField();;
	private final TextField txfName2 = new TextField();;
	private final TextField txfNameCombined = new TextField();;

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
		pane.add(txfName2, 1, 0);
		pane.add(txfNameCombined, 0, 1, 2, 1);

		// add a button to the pane (at col=1, row=1)
		Button btn = new Button("Kombiner");
		pane.add(btn, 0, 2);
		btn.setOnAction(event -> combineAction());
		GridPane.setMargin(btn, new Insets(10, 10, 0, 10));
	}

	public void combineAction() {
		String name1 = txfName1.getText().trim();
		String name2 = txfName2.getText().trim();

		txfNameCombined.setText(name1 + " " + name2);
	}
}
