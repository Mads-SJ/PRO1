package opg3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
        Circle circle = new Circle(100, 100, 200);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        Line line = new Line(40, 100, 80, 100);
        Circle eye1 = new Circle(25, 50, 20);
        Circle eye2 = new Circle(75, 50, 20);
        pane.getChildren().add(circle);
        pane.getChildren().add(line);
        pane.getChildren().add(eye1);
        pane.getChildren().add(eye2);
    }
}
