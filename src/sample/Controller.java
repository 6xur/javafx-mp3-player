package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Button playButton;

    @FXML
    private AnchorPane anchorPane;

    MediaPlayer mediaPlayer;

    int playStatus = 0;

    double dX;
    double dY;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String bip = "High Pressure Dave-Ny_HsSmiL9A.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);

    }

    public void playAudio(){
        if(playStatus == 0){
            mediaPlayer.play();
            playButton.setText("⏸");
            playStatus = 1;
        } else if(playStatus == 1){
            mediaPlayer.pause();
            playStatus = 0;
            playButton.setText("▶");
        }
    }

    public void lighten(){
        playButton.setTextFill(Color.BEIGE);
    }

    public void darken(){
        playButton.setTextFill(Color.LIGHTGREY);
    }

    @FXML
    protected void setOnMousePressed(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        dX = stage.getX() - event.getScreenX();
        dY = stage.getY() - event.getScreenY();
    }

    @FXML
    protected void setOnMouseDragged(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setX(event.getScreenX() + dX);
        stage.setY(event.getScreenY() + dY);
    }


}