package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField textField1;
    @FXML
    private Button helloButton, byeButton;

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
        System.out.println("The following button was pressed " + e.getSource());
    }

    @FXML public void handleKeyReleased() {
        String text = textField1.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

}
