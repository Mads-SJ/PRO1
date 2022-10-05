package opg4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        Circle circle1 = new Circle(200, 200, 100);
        circle1.setFill(null);
        circle1.setStroke(Color.BLACK);
        circle1.setStrokeWidth(20);

        Circle circle2 = new Circle(200, 200, 60);
        circle2.setFill(null);
        circle2.setStroke(Color.BLACK);
        circle2.setStrokeWidth(20);

        Circle circle3 = new Circle(200, 200, 30);
        circle3.setStroke(Color.BLACK);


        pane.getChildren().add(circle1);
        pane.getChildren().add(circle2);
        pane.getChildren().add(circle3);

    }
}
