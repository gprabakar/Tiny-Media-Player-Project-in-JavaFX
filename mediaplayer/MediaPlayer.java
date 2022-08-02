package mediaplayer;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MediaPlayer extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MediaPlayer.fxml"));
        Scene scene = new Scene(root);
    stage.setTitle("Media Player Application");
    stage.setScene(scene);
    stage.show();
    }
    public static void main(String[] args){
         launch(args);
     }
}


