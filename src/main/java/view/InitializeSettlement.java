package view;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InitializeSettlement {

    public static String name;

    public static String initializeSettlement() {

        // initialize stage
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("A New Settlement");


        // initialize contents
        Label inputLabel = new Label("Choose a name for your new "
                + "Settlement:");
        final TextField textInput = new TextField();
        textInput.setPromptText("Enter name here");
        Label notificationLabel = new Label("You have built a settlement.");
        Button okBT = new Button("OK");
        Button cancelBT = new Button("Cancel");


        // set button functions
        okBT.setOnAction(e -> {
            if (textInput.getText() != null && !textInput.getText().isEmpty()) {
                name = textInput.getText();
                popup.close();
            } else {
                textInput.setPromptText("You must enter a name.");
            }
                });

        cancelBT.setOnAction(e -> popup.close());


        // form layout
        //      initialize grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(10);

        //      set layout
        GridPane.setConstraints(notificationLabel, 0, 0);
        GridPane.setConstraints(inputLabel, 0, 1);
        GridPane.setConstraints(textInput, 1, 1);
        GridPane.setConstraints(okBT, 1, 2);
        GridPane.setConstraints(cancelBT, 2, 2);

        //      add to grid
        grid.getChildren().addAll(notificationLabel, inputLabel, textInput,
                okBT, cancelBT);


        // display stage
        Scene scene = new Scene(grid, 550, 170);
        popup.setScene(scene);
        popup.showAndWait();

        return name;
    }

}
