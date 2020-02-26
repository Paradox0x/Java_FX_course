package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.security.acl.Group;
import java.time.LocalDate;

public class BasicControls extends Application {
    VBox root = new VBox();
    Scene scene = new Scene(root,400, 400, Color.CYAN);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        primaryStage.show();
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        Button button = new Button("PARADOXMSG");
        root.getChildren().add(button);
        button.setPrefWidth(200);
        button.setPrefHeight(50);

        Label label = new Label("Wypisz Szymon");
        root.getChildren().add(label);

        TextField textField = new TextField("PROSZE BARDZO TO MOJ EMAIL:");
        root.getChildren().add(textField);
        textField.setAlignment(Pos.CENTER);
        textField.setMaxWidth(300);
        textField.setOnAction((event -> {
            System.out.println(textField.getText());

        }));
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        root.getChildren().add(textArea);

        button.isCancelButton();
        button.setOnAction((event -> {
        textField.setText("Paradoxmsg@gmail.com");
        textArea.appendText("SPOKO");
        }));

        label.setLabelFor(textField);
        label.setAlignment(Pos.CENTER);

        DatePicker datePicker = new DatePicker((LocalDate.now()));
        root.getChildren().add(datePicker);


        CheckBox checkBox = new CheckBox("CZY MASZ 18LAT I JARRRRASZ?");
        root.getChildren().add(checkBox);
        checkBox.setOnAction((event -> {
            textArea.appendText(" checkbox " + checkBox.isSelected());
        }));
    }



    public static void main(String[] args) {
        launch();
    }

}
