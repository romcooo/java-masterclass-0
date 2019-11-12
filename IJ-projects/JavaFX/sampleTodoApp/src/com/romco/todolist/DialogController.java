package com.romco.todolist;

import com.romco.todolist.datamodel.TodoData;
import com.romco.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    private static final String DEFAULT_NA_STRING = "N/A";
    private static final LocalDate DEFAULT_NA_DATE = LocalDate.now().plusYears(10);

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

        TodoItem newItem = new TodoItem(
                newDescription.isEmpty() ? DEFAULT_NA_STRING : newDescription,
                newDetails.isEmpty() ? DEFAULT_NA_STRING : newDetails,
                newDate == null ? DEFAULT_NA_DATE : newDate);

        TodoData.getInstance().addTodoItem(newItem);
        return(newItem);
    }
}
