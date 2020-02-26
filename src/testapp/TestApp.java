package testapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TestApp extends Application {

    VBox root = new VBox();
    Scene scene = new Scene(root,500, 500, Color.CYAN);

    HBox nav = new HBox();
    VBox radios = new VBox();



    TextArea question = new TextArea();

    RadioButton answer1 = new RadioButton();
    RadioButton answer2 = new RadioButton();
    RadioButton answer3 = new RadioButton();
    javafx.scene.control.Button nextBtn = new javafx.scene.control.Button("Next");
    javafx.scene.control.Button prevBtn = new javafx.scene.control.Button("Prev");
    javafx.scene.control.Button submit = new javafx.scene.control.Button("Ostatecznie");


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
        primaryStage.setScene(scene);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        root.getChildren().add(nav);
        root.getChildren().add(radios);


        radios.getChildren().addAll(answer1, answer2, answer3);
        nav.getChildren().addAll(prevBtn, question, nextBtn, submit);

    }
  //  List<TextItem> getTest(){
   //     List<TestItem> list = new ArrayList<>();
  //      list.add(new TestItem("Stolica Polski?", "Dabrowa Gornicza", "Krakow", "Warszawa", 1));

    //    return list;
   // }

    public static void main(String[] args) {
        launch();
    }
}
