package animation;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.sql.Time;

public class Transitions extends Application {

    Group root = new Group();
    Scene scene = new Scene(root, 500, 500, Color.CYAN);
    Rectangle rectangle = new Rectangle(200,200, 100, 100);

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        primaryStage.show();
        root.getChildren().add(rectangle);
        rectangle.setFill(Color.RED);
        rectangle.setStrokeWidth(4);
        rectangle.setStroke(Color.BLACK);

        FadeTransition fade = new FadeTransition(Duration.millis(1000), rectangle);
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setCycleCount(Animation.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        ScaleTransition scale = new ScaleTransition(Duration.millis(2000), rectangle);
                scale.setFromX(1.0);
                scale.setFromY(1.0);
                scale.setToX(0.5);
                scale.setToY(0.5);
                scale.setCycleCount(Animation.INDEFINITE);
                scale.setAutoReverse(true);
                scale.play();

        RotateTransition rotate = new RotateTransition(Duration.millis(2000), rectangle);

        rotate.setByAngle(45);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setAutoReverse(true);
        rotate.play();

        ParallelTransition parallel = new ParallelTransition(rectangle);
        parallel.getChildren().addAll(rotate, scale, fade);

        Timeline move = new Timeline();
        KeyValue value1 = new KeyValue(rectangle.xProperty(), 350);
        KeyFrame key1 = new KeyFrame(Duration.millis(1000), value1);
        move.getKeyFrames().add(key1);

        KeyValue value2 = new KeyValue(rectangle.xProperty(), 150);
        KeyFrame key2 = new KeyFrame(Duration.millis(1000), value2);
        move.getKeyFrames().add(key2);

        KeyValue value3 = new KeyValue(rectangle.xProperty(), 200);
        KeyFrame key3 = new KeyFrame(Duration.millis(1000), value3);
        move.getKeyFrames().add(key3);

        SequentialTransition sequance = new SequentialTransition();
        sequance.getChildren().addAll(move, parallel, move, parallel, move, parallel, move);
        sequance.play();
    }
}
