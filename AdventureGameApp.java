import AdventureModel.AdventureGame;
import javafx.application.Application;
import javafx.stage.Stage;
import views.AdventureGameView;
import javafx.fxml.*;
import views.SelectView;
import views.Visualize;

import java.io.IOException;

/**
 * Class AdventureGameApp.
 */
public class AdventureGameApp extends  Application implements Visualize {

    AdventureGame model;
    AdventureGameView view;

    public static void main(String[] args) {
        launch(args);
    }
    /*
    * JavaFX is a Framework, and to use it we will have to
    * respect its control flow!  To start the game, we need
    * to call "launch" which will in turn call "start" ...
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.model = new AdventureGame("Survivegame"); //change the name of the game if you want to try something bigger!
        SelectView selectView = new SelectView(model, primaryStage);
        // pass the AdventureGame and Stage object so the

        selectView.start(new Stage()); // Launching the GUI of the SelectView class object.
        //User will choose their accessibility level here.
        selectView.getStage().setOnCloseRequest(event -> { // Retrieve the selected object when the stage closes.
            this.view = selectView.getSelectedObject();
        });

    }

}
