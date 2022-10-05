package opg5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);
        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Circle circle1 = new Circle(60, 60, 50);
        circle1.setFill(null);
        circle1.setStroke(Color.BLUE);
        circle1.setStrokeWidth(5);

        Circle circle2 = new Circle(160, 60, 50);
        circle2.setFill(null);
        circle2.setStroke(Color.BLACK);
        circle2.setStrokeWidth(5);

        Circle circle3 = new Circle(260, 60, 50);
        circle3.setFill(null);
        circle3.setStroke(Color.RED);
        circle3.setStrokeWidth(5);

        Circle circle4 = new Circle(110, 120, 50);
        circle4.setFill(null);
        circle4.setStroke(Color.YELLOW);
        circle4.setStrokeWidth(5);

        Circle circle5 = new Circle(210, 120, 50);
        circle5.setFill(null);
        circle5.setStroke(Color.GREEN);
        circle5.setStrokeWidth(5);


        pane.getChildren().add(circle1);
        pane.getChildren().add(circle2);
        pane.getChildren().add(circle3);
        pane.getChildren().add(circle4);
        pane.getChildren().add(circle5);

    }
}
