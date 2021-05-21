package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Level1Controller {

    @FXML
    private GridPane gridpane;
    int[][] map = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 3, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 3, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 3, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 3, 1, 4, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int[][] map2 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 3, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 3, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 3, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 3, 1, 4, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private final int mapHeight = map.length - 2;
    private final int mapWidth = map[1].length - 2;
    private int playerX;
    private int playerY;

    public void drawMap() {
        for (int i = 0; i < map.length; i++) {//h
            for (int j = 0; j < map[0].length; j++) {//w
                int tube = 50;
                switch (map[i][j]) {
                    case 1://road
                        Image landImage = new Image(getClass().getResourceAsStream("/image/land.jpg"), tube, tube, false, false);
                        ImageView land = new ImageView(landImage);
                        GridPane.setConstraints(land, j, i);
                        gridpane.getChildren().add(land);
                        break;
                    case 2://fire
                        Image fireImage = new Image(getClass().getResourceAsStream("/image/fire.png"), tube, tube, false, false);
                        ImageView fire = new ImageView(fireImage);
                        GridPane.setConstraints(fire, j, i);
                        gridpane.getChildren().add(fire);
                        break;
                    case 3://ice
                        Image iceImage = new Image(getClass().getResourceAsStream("/image/ice.jpeg"), tube, tube, false, false);
                        ImageView ice = new ImageView(iceImage);
                        GridPane.setConstraints(ice, j, i);
                        gridpane.getChildren().add(ice);
                        break;
                    case 4://player
                        Image playerImage = new Image(getClass().getResourceAsStream("/image/player.png"), tube, tube, false, false);
                        ImageView player = new ImageView(playerImage);
                        GridPane.setConstraints(player, j, i);
                        gridpane.getChildren().add(player);
                        playerY = i;
                        playerX = j;
                        break;
                    case 0:
                        Image wallImage = new Image(getClass().getResourceAsStream("/image/wall.png"), tube, tube, false, false);
                        ImageView wall = new ImageView(wallImage);
                        GridPane.setConstraints(wall, j, i);
                        gridpane.getChildren().add(wall);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void drawMap2() {
        for (int i = 0; i < map2.length; i++) {//h
            for (int j = 0; j < map2[0].length; j++) {//w
                int tube = 50;
                switch (map2[i][j]) {
                    case 1://road
                        if (map2[i][j] != map[i][j]) {
                            Image landImage = new Image(getClass().getResourceAsStream("/image/land.jpg"), tube, tube, false, false);
                            ImageView land = new ImageView(landImage);
                            GridPane.setConstraints(land, j, i);
                            gridpane.getChildren().add(land);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 2://fire
                        if (map2[i][j] != map[i][j]) {
                            Image fireImage = new Image(getClass().getResourceAsStream("/image/fire.png"), tube, tube, false, false);
                            ImageView fire = new ImageView(fireImage);
                            GridPane.setConstraints(fire, j, i);
                            gridpane.getChildren().add(fire);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 3://ice
                        if (map2[i][j] != map[i][j]) {
                            Image iceImage = new Image(getClass().getResourceAsStream("/image/ice.jpeg"), tube, tube, false, false);
                            ImageView ice = new ImageView(iceImage);
                            GridPane.setConstraints(ice, j, i);
                            gridpane.getChildren().add(ice);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 4://player
                        if (map2[i][j] != map[i][j]) {
                            Image playerImage = new Image(getClass().getResourceAsStream("/image/player.png"), tube, tube, false, false);
                            ImageView player = new ImageView(playerImage);
                            GridPane.setConstraints(player, j, i);
                            gridpane.getChildren().add(player);
                            playerY = i;
                            playerX = j;
                            map[i][j] = map2[i][j];
                        }
                        break;

                    case 0:
                        if (map2[i][j] != map[i][j]) {
                            Image wallImage = new Image(getClass().getResourceAsStream("/image/wall.png"), tube, tube, false, false);
                            ImageView wall = new ImageView(wallImage);
                            GridPane.setConstraints(wall, j, i);
                            gridpane.getChildren().add(wall);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
    @FXML
    void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                if(map2[playerY-1][playerX]==0)//底線
                    return;
                if(map2[playerY-1][playerX]==2)//碰到火
                    return;
                if(map2[playerY-1][playerX]==3){//碰到冰塊
                    if(map2[playerY-2][playerX]==0||map2[playerY-2][playerX]==3)
                        return;
                    for(int i=playerY-1;i>=1;i--){
                        if(map2[i][playerX]==2) {//冰塊碰到火
                            map2[i][playerX]=1;
                            map2[i+1][playerX]=1;
                            break;
                        }
                        if((map2[i][playerX]==3||map2[i][playerX]==0)&&i!=playerY-1){//冰塊跟牆壁
                            map2[i+1][playerX]=3;
                            break;
                        }
                        map2[i+1][playerX]=1;
                        map2[i][playerX]=3;
                    }
                }
                map2[playerY][playerX] = 1;
                map2[playerY-1][playerX] = 4;
                System.out.println("up");
                drawMap2();
//                if(playerY.equals(GridPane.getRowIndex(ice)) && playerX.equals(GridPane.getColumnIndex(ice))) {
//
//                    if (GridPane.getColumnIndex(fire).equals(GridPane.getColumnIndex(ice)) && GridPane.getRowIndex(fire) < GridPane.getRowIndex(ice)) {
//
//                        fire.setVisible(false);
//                        ice.setVisible(false);
//                    }
//                    else {
//                        GridPane.setRowIndex(ice, 1);
//                    }
//                }
                break;
            case A:
                if (map2[playerY][playerX - 1] == 0)
                    return;
                if (map2[playerY][playerX - 1] == 2)
                    return;
//                if(playerY.equals(GridPane.getRowIndex(fire)) &&playerX==GridPane.getColumnIndex(fire)+1&&fire.isVisible())//邊線
//                    return;
//                GridPane.setColumnIndex(player,playerX-1);
                if (map2[playerY][playerX - 1] == 3) {//碰到冰塊
                    if (map2[playerY][playerX - 2] == 0 || map2[playerY][playerX - 2] == 3)
                        return;
                    for (int i = playerX - 1; i >= 1; i--) {
                        if (map2[playerY][i] == 2) {
                            map2[playerY][i] = 1;
                            map2[playerY][i + 1] = 1;
                            break;
                        }
                        if ((map2[playerY][i] == 3 || map2[playerY][i] == 0) && i != playerX - 1) {//冰塊跟牆壁(還沒寫)
                            System.out.println("YES");
                            map2[playerY][i + 1] = 3;
                            break;
                        }
                        map2[playerY][i + 1] = 1;
                        map2[playerY][i] = 3;
                    }
                }
                map2[playerY][playerX - 1] = 4;
                map2[playerY][playerX] = 1;
                drawMap2();
                System.out.println("left");

//                if(playerY.equals(GridPane.getRowIndex(ice)) && playerX.equals(GridPane.getColumnIndex(ice))) {
//                    if (GridPane.getRowIndex(fire).equals(GridPane.getRowIndex(ice)) && GridPane.getColumnIndex(fire) < GridPane.getColumnIndex(ice)) {
//                        fire.setVisible(false);
//                        ice.setVisible(false);
//                    }
//                    else {
//                        GridPane.setColumnIndex(ice, 1);
//                    }
//                }
                break;
            case S:
                if (map2[playerY + 1][playerX] == 0)
                    return;
                if (map2[playerY + 1][playerX] == 2)
                    return;
//                if (playerY==GridPane.getRowIndex(fire)-1&& playerX.equals(GridPane.getColumnIndex(fire)) &&fire.isVisible())
//                    return;
//                GridPane.setRowIndex(player,playerY+1);
                if (map2[playerY + 1][playerX] == 3) {//碰到冰塊
                    if (map2[playerY + 2][playerX] == 0 || map2[playerY + 2][playerX] == 3)
                        return;
                    for (int i = playerY + 1; i <= mapHeight; i++) {
                        if (map2[i][playerX] == 2) {
                            map2[i][playerX] = 1;
                            map2[i - 1][playerX] = 1;
                            break;
                        }
                        if ((map2[i][playerX] == 3 || map2[i][playerX] == 0) && i != playerY + 1) {//冰塊跟牆壁(還沒寫)
                            map2[i - 1][playerX] = 3;
                            break;
                        }
                        map2[i - 1][playerX] = 1;
                        map2[i][playerX] = 3;
                    }
                }
                map2[playerY + 1][playerX] = 4;
                map2[playerY][playerX] = 1;
                drawMap2();
                System.out.println("down");
//                if(playerY.equals(GridPane.getRowIndex(ice)) && playerX.equals(GridPane.getColumnIndex(ice))) {
//                    if (GridPane.getColumnIndex(fire).equals(GridPane.getColumnIndex(ice)) && GridPane.getRowIndex(fire) > GridPane.getRowIndex(ice)) {
//                        // && GridPane.getRowIndex(fire) < GridPane.getRowIndex(ice)
//                        fire.setVisible(false);
//                        ice.setVisible(false);
//                    }
//                    else {
//                        GridPane.setRowIndex(ice, mapHeight);
//                    }
//                }
                break;
            case D:
                if (map2[playerY][playerX + 1] == 0)
                    return;
                if (map2[playerY][playerX + 1] == 2)
                    return;
//                if(playerY.equals(GridPane.getRowIndex(fire)) &&playerX==GridPane.getColumnIndex(fire)-1&&fire.isVisible())//邊線
//                    return;
                if (map2[playerY][playerX + 1] == 3) {//碰到冰塊
                    if (map2[playerY][playerX + 2] == 0 || map2[playerY][playerX + 2] == 3)
                        return;
                    for (int i = playerX + 1; i <= mapWidth; i++) {
                        if (map2[playerY][i] == 2) {
                            map2[playerY][i] = 1;
                            map2[playerY][i - 1] = 1;
                            break;
                        }
                        if ((map2[playerY][i] == 3 || map2[playerY][i] == 0) && i != playerX + 1) {//冰塊跟牆壁(還沒寫)
                            map2[playerY][i - 1] = 3;
                            break;
                        }
                        map2[playerY][i - 1] = 1;
                        map2[playerY][i] = 3;
                    }
                }
                map2[playerY][playerX + 1] = 4;
                map2[playerY][playerX] = 1;
                drawMap2();
//                GridPane.setColumnIndex(player,playerX+1);
                System.out.println("right");
//                if(playerY.equals(GridPane.getRowIndex(ice)) && playerX.equals(GridPane.getColumnIndex(ice))) {
//                    if (GridPane.getRowIndex(fire).equals(GridPane.getRowIndex(ice)) && GridPane.getColumnIndex(fire) > GridPane.getColumnIndex(ice)) {
//                        fire.setVisible(false);
//                        ice.setVisible(false);
//                    }
//                    else {
//                        GridPane.setColumnIndex(ice, mapWidth);
//                    }
//                }
                break;
            default:
                break;
        }
    }


}
