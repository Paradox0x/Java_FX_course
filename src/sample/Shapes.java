package sample;

import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

final public class Shapes {

    private Shapes(){

    }

    public static Path arrow(double x, double y, double size){
        Path arrow = new Path();
        arrow.getElements().addAll(

                new MoveTo(10, 10),
                new LineTo(100, 100),
                new MoveTo(80, 40),
                new LineTo(100, 100),
                new MoveTo(40, 80),
                new LineTo(100, 100)
        );
        return arrow;
    }
}
