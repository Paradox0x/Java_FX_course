package animation;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BouncingBall extends Application {

    Circle ball = new Circle(100, 100, 40, Color.VIOLET);
    Text counterInfo = new Text(10, 20, "Kliknięcia: 0");
    Group root = new Group();
    Scene scene = new Scene(root, 600, 400, Color.AQUA);
    Text clockInfo = new Text(scene.getWidth() - 100, 20, "10");
    AtomicInteger counterClick = new AtomicInteger(0);
    AtomicBoolean canPlay = new AtomicBoolean(true);
    int timeToPlay = 10000;

    //milisekund

    public static void main(String[] args) {
    launch();
}

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bouncing Ball");
        primaryStage.show();
        root.getChildren().add(ball);
        ExecutorService service = Executors.newCachedThreadPool();

        //utworzenie i uruchomienie animacji

        service.execute(new Bouncing(ball, scene, 10, 10));
        Random rand = new Random();
        List<Circle> balls = Stream.generate(() -> new Circle(200, 200, 20)).limit(20).collect(Collectors.toList());
        root.getChildren().addAll(balls);

        //mozna dać random

        for (Circle c : balls) {
            service.execute(new Bouncing(c, scene, 10 + rand.nextInt(5), 10 + rand.nextInt(5)));
        }

        root.getChildren().add(counterInfo);
        ball.setOnMouseClicked((event) -> {
            double clickX = event.getX();
            double clickY = event.getY();
            System.out.println(clickX + " " + clickY);

            if (canPlay.get()) {
                int count = counterClick.incrementAndGet();
                counterInfo.setText("Kliknięć: " + count);
            }
            if (counterClick.incrementAndGet() == 10 ){
                Platform.runLater(() -> {
                    for (Circle c : balls) {
                        service.execute(new Bouncing(c, scene, 15 + rand.nextInt(5), 15 + rand.nextInt(5)));
                    }
                });
            }
        });

        root.getChildren().add(clockInfo);
        clockInfo.setTextAlignment(TextAlignment.JUSTIFY);
        service.execute(() -> {

            while (timeToPlay > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timeToPlay -= 1000;
                Platform.runLater(() -> {
                    clockInfo.setText(" " + timeToPlay / 1000);
                });
            }
            canPlay.set(false);
            Platform.runLater(() -> {
                clockInfo.setText("Koniec Gry!");
            });
        });
    }
}


