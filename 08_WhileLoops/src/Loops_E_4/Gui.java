package Loops_E_4;

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
        // Figure 1
       // int x = 100; // center: (x,y)
       // int y = 100;
       // int r = 20; // radius: r
       // while (r <= 100) {
       //     gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
       //     r += 20;
       // }

        // Figure 2
       // int x = 20; // center: (x,y)
       // int y = 100;
       // int r = 10; // radius: r
       // while (r <= 80) {
       //     gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
       //     x += 10;
       //     r += 10;
       // }

        // Figure 3
        int x = 100; // center: (x,y)
        int y = 100;
        int width = 20;
        int height = 40;
        while (width <= 90) {
            gc.strokeOval(x - width, y - height, 2 * width, 2 * height);
            width += 10;
        }
    }

}
