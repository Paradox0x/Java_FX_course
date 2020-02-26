package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("Hello: World, World: Hello, Hello: Hello World, World: Hello Hello");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Rectangle rectangle = new Rectangle(10, 10, 100, 100);
        root.getChildren().add(rectangle);
        rectangle.setFill(Color.RED);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(5);
        rectangle.setRotate(45);

        Circle circle = new Circle(200, 200, 50);
        root.getChildren().add(circle);
        circle.setFill(Color.VIOLET);

        Line line = new Line(0, 0, 100, 100);
        line.setStroke(Color.GREEN);
        line.setStrokeWidth(4);
        root.getChildren().add(line);

        CubicCurve curve = new CubicCurve(0, 0, 120, 120, 10, 120, 200, 200);
        curve.setStrokeWidth(5);
        root.getChildren().add(curve);
        curve.setStroke(Color.RED);
        curve.setFill(Color.TRANSPARENT);

        Path path = new Path();
        path.getElements().addAll(
                new MoveTo(50, 100),
                new LineTo(100,150),
                new CubicCurveTo(0, 200, 150, 300, 200, 200),
                new LineTo(50, 100)
        );
        path.setFill(Color.BLUE);
        root.getChildren().add(path);

        Path arrow = Shapes.arrow(50, 50, 150);
        root.getChildren().add(arrow);
        arrow.setStroke(Color.BLACK);
        arrow.setStrokeWidth(8);

        Text napis = new Text(40, 40, "Hello");
        root.getChildren().add(napis);
        napis.setFont(Font.font("Calibri", 40));







    }


    public static void main(String[] args) {
        launch(args);
    }

}
