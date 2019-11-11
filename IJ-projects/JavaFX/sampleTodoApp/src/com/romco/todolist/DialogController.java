package com.romco.todolist;

import com.romco.todolist.datamodel.TodoData;
import com.romco.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextArea detailsTextArea;
    @FXML
    private DatePicker dueDateDatePicker;

    public TodoItem processResults() {
        String newDescription = descriptionTextField.getText().trim();
        String newDetails = detailsTextArea.getText().trim();
        LocalDate newDate = dueDateDatePicker.getValue();
        TodoItem newItem = new TodoItem(newDescription, newDetails, newDate);
        TodoData.getInstance().addTodoItem(newItem);
        return(newItem);
    }

}
