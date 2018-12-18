package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class Controller3 implements Initializable {
    @FXML
    private Circle player;
    @FXML
    private Circle seed;
    @FXML
    private Label Timer;
    @FXML
    private Label Score;
    @FXML
    private AnchorPane content;

    static int scoree = 0;
    String sec = "15";
    static int interval;
    static Timer timer;

    public static void timer(URL location, ResourceBundle resources) {

    }

    private final int setInterval() throws IOException, InterruptedException {
        if (interval == 1) {
            timer.cancel();
            //  sleep(2000);
            System.out.println("game end");
        }

        return --interval;
    }


    public void up(ActionEvent actionEvent) {
        player.setLayoutY(player.getLayoutY() - 10);
        check(player.getLayoutX(), player.getLayoutY());
    }

    public void down(ActionEvent actionEvent) {
        player.setLayoutY(player.getLayoutY() + 10);
        check(player.getLayoutX(), player.getLayoutY());
    }

    public void left(ActionEvent actionEvent) {
        player.setLayoutX(player.getLayoutX() - 10);
        check(player.getLayoutX(), player.getLayoutY());
    }

    public void right(ActionEvent actionEvent) {
        player.setLayoutX(player.getLayoutX() + 10);
        check(player.getLayoutX(), player.getLayoutY());
    }

    public void check(double x, double y) {

        if ((x <= seed.getLayoutX() + 10 && x >= seed.getLayoutX() - 10) && (y <= seed.getLayoutY() + 10 && y >= seed.getLayoutY() - 10)) {
            scoree += 10;
            sec = String.valueOf((Integer.parseInt(sec) + 2));
            interval = Integer.parseInt(sec);
            System.out.println(sec);
            Score.setText(scoree + "");
            Random rnd = new Random();
            int newx = rnd.nextInt(321) + 43;
            rnd = new Random();
            int newy = rnd.nextInt(250) + 33;
            seed.setLayoutX(newx);
            seed.setLayoutY(newy);
            Timer.setText(sec);

        }
    }

    public void s(KeyEvent keyEvent) {
        if (keyEvent.getText().equals("w")) {
            player.setLayoutY(player.getLayoutY() - 10);
            check(player.getLayoutX(), player.getLayoutY());
            blocks(player.getLayoutX(), player.getLayoutY());
        }
        if (keyEvent.getText().equals("s")) {
            player.setLayoutY(player.getLayoutY() + 10);
            check(player.getLayoutX(), player.getLayoutY());
            blocks(player.getLayoutX(), player.getLayoutY());
        }
        if (keyEvent.getText().equals("a")) {
            player.setLayoutX(player.getLayoutX() - 10);
            check(player.getLayoutX(), player.getLayoutY());
            blocks(player.getLayoutX(), player.getLayoutY());
        }
        if (keyEvent.getText().equals("d")) {
            player.setLayoutX(player.getLayoutX() + 10);
            check(player.getLayoutX(), player.getLayoutY());
            blocks(player.getLayoutX(), player.getLayoutY());
        }
    }

    public void blocks(double x, double y) {
        if (y + 4.5 >= 82 && y + 4.5 <= 257 && x >= 153 && x <= 165) {
            player.setLayoutX(179);
            player.setLayoutY(200);
            scoree -= 5;
            Score.setText(scoree + "");

        }
        if (y + 4.5 >= 66 && y + 4.5 <= 78 && x >= 70 && x <= 209) {
            player.setLayoutX(179);
            player.setLayoutY(200);
            scoree -= 8;
            Score.setText(scoree + "");
        }
        if (y + 4.5 >= 217 && y + 4.5 <= 229 && x >= 165 && x <= 342) {
            player.setLayoutX(179);
            player.setLayoutY(200);
            scoree -= 5;
            Score.setText(scoree + "");

        }
        if (y + 4.5 >= 134 && y + 4.5 <= 217 && x >= 294 && x <= 306) {
            player.setLayoutX(179);
            player.setLayoutY(200);
            scoree -= 5;
            Score.setText(scoree + "");

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt(sec);
        System.out.println(sec);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                Platform.runLater(() -> {
                    try {
                        int x = setInterval();
                        if (x == 1) {
                            System.out.println("stop");
                            AnchorPane pane = FXMLLoader.load(getClass().getResource("Endgame.fxml"));
                            content.getChildren().setAll(pane);
                        } else {
                            Timer.setText(String.valueOf(x));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }, delay, period);

    }

}
