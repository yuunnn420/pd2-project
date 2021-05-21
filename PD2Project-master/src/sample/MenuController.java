package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
    }
    @FXML
    private ImageView menu;
    @FXML
    private ImageView hotpot;

    private int y=1;
    //一個選項的單位
    public void selected(){

    }
    public void nonselected(){

    }
    public int getHotpotY() {
        return y;
    }

    public void up() {
        //火鍋圖向上移動32
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(hotpot);
        translate.setDuration(Duration.millis(1));
        translate.setByY(-32);
        translate.play();
        y--;

    }
    public void down() {
        //火鍋圖向下移動32
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(hotpot);
        translate.setDuration(Duration.millis(1));
        translate.setByY(32);
        translate.play();
        y++;

    }
    public void toLevel1() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level1.fxml"));
            Parent root = loader.load();
            Scene level1 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level1);
            stage.setTitle("Level 1");
            Level1Controller controller=loader.getController();
            controller.drawMap();
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private VBox menubox;
}
