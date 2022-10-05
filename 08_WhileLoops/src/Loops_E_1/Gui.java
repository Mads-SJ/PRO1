package Loops_E_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application
{
    

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc)
    {
        // draw an arrowhead at (50,30)
        int x = 50;
        int y = 30;
        int length = 20;
        int width = 8;
        gc.strokeLine(x, y, x + length, y - width);
        gc.strokeLine(x, y, x + length, y + width);

        // draw an arrowhead at (25,140)
        x = 25;
        y = 140;
        gc.strokeLine(x, y, x + length, y - width);
        gc.strokeLine(x, y, x + length, y + width);
    }

}
