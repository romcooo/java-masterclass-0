package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField textField1;
    @FXML
    private Button helloButton, byeButton;
    @FXML private CheckBox checkBox1;
    @FXML private Label label1;

    private CheckBox ourCheckBox;

    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if(e.getSource().equals(helloButton)) {
            System.out.println("Hello, "+textField1.getText());
        } else if(e.getSource().equals(byeButton)) {
            System.out.println("Bye, "+textField1.getText());
        }
//        System.out.println("The following button was pressed " + e.getSource());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "FX Thread" : "Background Thread";
                    System.out.println("Going to sleep on the: " + s);
                    Thread.sleep(5000);
                    System.out.println("waited 5 seconds");
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "FX Thread" : "Background Thread";
                            System.out.println("Updating label on the: " + s);
                            label1.setText("waited 5 seconds successfully.");
                        }
                    });
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
        if (checkBox1.isSelected()) {
            textField1.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }

    @FXML public void handleKeyReleased() {
        String text = textField1.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML public void handleChange() {
        System.out.println("The checkbox is " + (checkBox1.isSelected() ? "checked" : "unchecked"));
    }

}
