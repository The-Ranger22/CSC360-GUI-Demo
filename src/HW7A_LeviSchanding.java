//Student: Levi Schanding
//Teacher: Molly Hickman
//Class: CSC360-001
//Date: 11/15/2019

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.util.*;

public class HW7A_LeviSchanding extends Application {
    protected TextField textField = new TextField();
    protected TextArea textArea = new TextArea();
    protected LinkedList<Integer> list = new LinkedList<>();

    @Override
    public void start(Stage primaryStage) {

        Button btSort    = new Button("Sort");
        Button btShuffle = new Button("Shuffle");
        Button btReverse = new Button("Reverse");


        HBox paneForTextField = new HBox(10);
        paneForTextField.getChildren().addAll(
                new Label("Enter a number:"), textField);
        paneForTextField.setAlignment(Pos.CENTER);

        HBox paneForButtons = new HBox(5);
        paneForButtons.getChildren().addAll(
                btSort, btShuffle, btReverse);
        paneForButtons.setAlignment(Pos.CENTER);


        textArea.setEditable(false);
        textArea.setWrapText(true);


        BorderPane pane = new BorderPane();
        pane.setTop(paneForTextField);
        pane.setCenter(textArea);
        pane.setBottom(paneForButtons);


        // Adding items to list
        textField.setOnAction(e -> add());

        // Sorting the list
        btSort.setOnAction(e -> {
            Collections.sort(list);
            displayText();
        });

        // Shuffling the list
        btShuffle.setOnAction(e -> {
            Collections.shuffle(list);
            displayText();
        });

        // Reversing the list
        btReverse.setOnAction(e -> {
            Collections.reverse(list);
            displayText();
        });


        Scene scene = new Scene(pane, 400, 150);
        primaryStage.setTitle("Exercise_20_02"); // Set the stage title
        primaryStage.setScene(scene); // Place a scene in the stage
        primaryStage.show(); // Display the stage
    }


    private void add() {
        if(!list.contains(Integer.parseInt(textField.getText()))){
            list.addLast(Integer.parseInt(textField.getText()));
            displayText();
        }

    }

    private void displayText() {
        String output = "";
        for (Integer e: list)
            output += e + " ";

        textArea.setText(output);
        textField.setText("");
    }
}
