package gui;


import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import model.Yatzy;
import org.w3c.dom.Text;

public class YatzyGui extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// Shows the face values of the 5 dice.
	private TextField[] txfValues;
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds;
	// Shows the results previously selected .
	// For free results (results not set yet), the results
	// corresponding to the actual face values of the 5 dice are shown.
	private TextField[] txfResults;
	// Shows points in sums, bonus and total.
	private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
	// Shows the number of times the dice has been rolled.
	private Label lblRolled;

	private Button btnRoll;
	private GridPane dicePane;
	private GridPane scorePane;
	private final int w = 50; // width of the text fields

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");

		// initialize txfValues, chbHolds, btnRoll and lblRolled
		initValuesAndCheckboxes();
		initRoll();

		// ---------------------------------------------------------------------

		scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");

		// Initialize labels for results, txfResults,
		// labels and text fields for sums, bonus and total.
		initResultLabels();
		initResultTextFields();
		initExtraLabelsAndTextFields();
	}

	// -------------------------------------------------------------------------

	private Yatzy yatzy = new Yatzy();

	// Create a method for btnRoll's action.
	// Hint: Create small helper methods to be used in the action method.
	private void rollAction() {
		if (yatzy.getThrowCount() < 3) {
			boolean[] holds = getHolds();
			yatzy.throwDice(holds);
			updateAfterRoll();
		}
	}

	// -------------------------------------------------------------------------

	// Create a method for mouse click on one of the text fields in txfResults.
	// Hint: Create small helper methods to be used in the mouse click method.
	public void chooseFieldAction(Event event) {
		if (yatzy.getThrowCount() > 0) {
			TextField selectedTextField = (TextField) event.getSource();
			updateAfterSelect(selectedTextField);
			updateSum();
			resetAfterSelect();
		}
	}

	private void initRoll() {
		btnRoll = new Button("Roll");
		btnRoll.setPrefSize(70, 50);
		dicePane.add(btnRoll, 3, 2);
		btnRoll.setOnAction(event -> rollAction());

		lblRolled = new Label("Rolled: 0");
		dicePane.add(lblRolled, 4, 2);
	}
	private void initValuesAndCheckboxes() {
		txfValues = new TextField[5];
		chbHolds = new CheckBox[5];
		for (int i = 0; i < 5; i++) {
			TextField textField = new TextField();
			textField.setPrefSize(100,100);
			textField.setAlignment(Pos.CENTER);
			textField.setFont(Font.font("Roboto", 30));
			textField.setEditable(false);
			txfValues[i] = textField;
			dicePane.add(textField, i, 0);

			CheckBox checkBox = new CheckBox("Hold");
			chbHolds[i] = checkBox;
			dicePane.add(checkBox, i, 1);
		}
	}

	private void initResultLabels() {
		scorePane.add(new Label("1-s"), 0,0);
		scorePane.add(new Label("2-s"), 0,1);
		scorePane.add(new Label("3-s"), 0,2);
		scorePane.add(new Label("4-s"), 0,3);
		scorePane.add(new Label("5-s"), 0,4);
		scorePane.add(new Label("6-s"), 0,5);
		scorePane.add(new Label("One pair"), 0,6);
		scorePane.add(new Label("Two pairs"), 0,7);
		scorePane.add(new Label("Three same"), 0,8);
		scorePane.add(new Label("Four same"), 0,9);
		scorePane.add(new Label("Full House"), 0,10);
		scorePane.add(new Label("Small straight"), 0,11);
		scorePane.add(new Label("Large straight"), 0,12);
		scorePane.add(new Label("Chance"), 0,13);
		scorePane.add(new Label("Yatzy"), 0,14);
	}

	private void initResultTextFields() {
		txfResults = new TextField[15];
		for (int i = 0; i < 15; i++) {
			TextField textField = new TextField();
			textField.setPrefWidth(w);
			textField.setEditable(false);
			textField.setOnMouseClicked(event -> this.chooseFieldAction(event));
			txfResults[i] = textField;
			scorePane.add(textField, 1, i);
		}
	}

	private void initExtraLabelsAndTextFields() {
		scorePane.add(new Label("Sum:"), 2, 5);
		scorePane.add(new Label("Sum:"), 2, 14);

		txfSumSame = new TextField("0");
		txfSumSame.setEditable(false);
		txfSumSame.setPrefWidth(w);
		scorePane.add(txfSumSame, 3, 5);

		txfBonus = new TextField("0");
		txfBonus.setEditable(false);
		txfBonus.setPrefWidth(w);
		scorePane.add(txfBonus, 5, 5);

		scorePane.add(new Label("Bonus:"), 4, 5);
		scorePane.add(new Label("Total:"), 4, 14);

		txfSumOther = new TextField("0");
		txfSumOther.setEditable(false);
		txfSumOther.setPrefWidth(w);
		scorePane.add(txfSumOther, 3, 14);

		txfTotal = new TextField("0");
		txfTotal.setEditable(false);
		txfTotal.setPrefWidth(w);
		scorePane.add(txfTotal, 5, 14);
	}

	private boolean[] getHolds() {
		boolean[] holds = new boolean[5];
		for (int i = 0; i < chbHolds.length; i++) {
			holds[i] = chbHolds[i].isSelected();
		}
		return holds;
	}

	private void updateAfterRoll() {
		int[] values = yatzy.getValues();
		for (int i = 0; i < txfValues.length; i++) {
			txfValues[i].setText("" + values[i]);
		}

		lblRolled.setText("Rolled: " + yatzy.getThrowCount());

		int[] results = yatzy.getResults();
		for (int i = 0; i < txfResults.length; i++) {
			if (!txfResults[i].isDisable()) {
				txfResults[i].setText("" + results[i]);
			}
		}

		if (yatzy.getThrowCount() == 3) {
			btnRoll.setDisable(true);
			dicePane.requestFocus();
		}
	}

	private void updateAfterSelect(TextField selectedTextField) {
		selectedTextField.setDisable(true);

		for (TextField textField : txfResults) {
			if (!textField.isDisable()) {
				textField.setText("");
			}
		}
	}

	private void updateSum() {
		int sumSame = 0;
		int sumOther = 0;
		for (int i = 0; i < 15; i++) {
			String textValue = txfResults[i].getText();
			if (!textValue.equals("")) {
				int value = Integer.parseInt(textValue);
				if (i < 6) {
					sumSame += value;
				} else {
					sumOther += value;
				}
			}

		}

		txfSumSame.setText("" + sumSame);
		txfSumOther.setText("" + sumOther);

		if (sumSame >= 63) {
			txfBonus.setText("50");
		}

		txfTotal.setText("" + (sumSame + sumOther + Integer.parseInt(txfBonus.getText())));
	}

	private void resetAfterSelect() {
		for (int i = 0; i < 5; i++) {
			txfValues[i].setText("");
			chbHolds[i].selectedProperty().set(false);
		}

		btnRoll.setDisable(false);
		yatzy.resetThrowCount();
		lblRolled.setText("Rolled: 0");
		scorePane.requestFocus();
	}
}
