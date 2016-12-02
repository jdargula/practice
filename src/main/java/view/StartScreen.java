package view;

import model.Civilization;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        //TODO
        // initialize image
        ImageView iv = new ImageView("File:./src/main/java/view/civ_background.png");


        // initialize grid contents
        Label beginLabel = new Label("Select a Civilization to Begin.");
        ListView<CivEnum> civList = getCivList();
        Button beginBT = getStartButton();

        // form layout
        //      initialize grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //      set layout
        GridPane.setConstraints(beginLabel, 0,0);
        GridPane.setConstraints(civList, 0, 1);
        GridPane.setConstraints(beginBT, 0, 2);

        //      add to grid
        grid.getChildren().addAll(beginLabel, civList, beginBT);


        // add grid to stackpane
        this.getChildren().addAll(iv, grid);
    }


    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        //TODO
        // initialize button
        Button start = new Button("Start Game");
        start.setOnAction(event -> {

            System.out.print(InitializeSettlement.initializeSettlement());

            CivEnum selectedCiv = getCivList().getSelectionModel()
                    .getSelectedItem();
            System.out.println(selectedCiv.name() + " clicked");
        });
        return start;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        //TODO
        ObservableList<CivEnum> civListData = FXCollections
                .observableArrayList(CivEnum.values());
        ListView<CivEnum> civList = new ListView<>(civListData);
        civList.setPrefSize(100, 100);
        return civList;
    }
}