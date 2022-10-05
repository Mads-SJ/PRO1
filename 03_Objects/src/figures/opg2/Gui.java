package figures.opg2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
        int deltaY= 100;
        Color yellow = Color.YELLOW;
        Circle circle = new Circle(70, 70 + deltaY, 30);
        Rectangle rectangle = new Rectangle(100, 100 + deltaY, 50, 50);
        Line line = new Line(20, 20 + deltaY, 40, 40 + deltaY);
        pane.getChildren().add(circle);
        pane.getChildren().add(rectangle);
        pane.getChildren().add(line);
        circle.setFill(yellow);
        circle.setStroke(Color.BLACK);
    }
}
