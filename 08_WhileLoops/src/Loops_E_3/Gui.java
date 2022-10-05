package Loops_E_3;

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
        //int y1 = 10;
        //int y2 = 190;
        //int x = 20;

        //while(x <= 220) {
        //    gc.strokeLine(x, y1, x, y2);
        //    x += 40;
        //}

        // Figure 3
        int x1 = 10;
        int x2 = 190;
        int y = 20;
        int i = 0;

        while(i < 5) {
            gc.strokeLine(x1, y, x2, y);
            x1 += 20;
            x2 -= 20;
            y += 40;
            i++;
        }


    }

}
