package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.robot.Robot;


public class Controller {
    private Robot robot = new Robot();
    
    @FXML
    ToggleButton stayAwakeToggle;
    
    private Runnable keepAlive = () -> {
        while (stayAwakeToggle.isSelected()) {
            Platform.runLater(() -> robot.mouseMove(robot.getMousePosition()));
            System.out.println("Staying alive;");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    
    private Thread keepAliveDaemon;
    
    @FXML
    private void popUp() {
        if(stayAwakeToggle.isSelected() && (keepAliveDaemon == null || !keepAliveDaemon.isAlive())) {
            keepAliveDaemon = new Thread(keepAlive);
            keepAliveDaemon.setDaemon(true);
            keepAliveDaemon.start();
        }
    }
}
