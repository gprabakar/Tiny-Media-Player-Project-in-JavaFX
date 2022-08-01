package mediaplayer;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.scene.media.Media;


public class MediaPlayerController implements Initializable {

@FXML
private FontAwesomeIconView play;
@FXML
private FontAwesomeIconView pause;
@FXML
private Slider volumeSlider;
private File file;

@FXML
private MediaView media;
private MediaPlayer mp;
private Media m;
public void playVideo(MouseEvent e){
    play.setVisible(false);
    pause.setVisible(true);
    mp.play();
}
public void pauseVideo(MouseEvent e){
    play.setVisible(true);
    pause.setVisible(false);
    mp.pause();
}
public void lastVideo(MouseEvent e){
    mp.seek(mp.getTotalDuration());
    mp.stop();
}
public void fastVideo(MouseEvent e){
    mp.setRate(1.2);
}
public void slowVideo(MouseEvent e){
    mp.setRate(0.9);
}
public void reloadVideo(MouseEvent e){
    mp.seek(mp.getStartTime());
    mp.play();
}

public void openVideo(ActionEvent e){
    FileChooser filechooser = new FileChooser();
    filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Videos File","*.mp4","*.mkv"));
    file = filechooser.showOpenDialog(null);
    String path = file.getAbsolutePath();
    path = path.replace("\\", "/");
    if(file!=null){
        m = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(m);
        media.setMediaPlayer(mp);
        mp.play();
        play.setVisible(false);
        pause.setVisible(true);
        volumeSlider.setValue(mp.getVolume()*100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
              mp.setVolume(volumeSlider.getValue()/100);
              
            }
        });
        DoubleProperty width = media.fitWidthProperty();
        DoubleProperty height = media.fitHeightProperty();
        width.bind(Bindings.selectDouble(media.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(media.sceneProperty(), "height"));        
    }
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       pause.setVisible(false);
       
    }    
    
}
