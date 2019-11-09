package com.romco.todolist;

import com.romco.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea textAreaCenter1;
    @FXML
    private Label deadlineLabel;

    public void initialize() {
        TodoItem item1 = new TodoItem("Mail birthday card",
                "Buy a birthday card for John",
                LocalDate.of(2019, Month.DECEMBER, 25));
        TodoItem item2 = new TodoItem("Doctor's appointment",
                "Visit Dr. House at 123 Hutch Boulevard.",
                LocalDate.of(2019, Month.NOVEMBER, 21));
        TodoItem item3 = new TodoItem("Pick up Doug at train station",
                "Arriving on November 1st, at 11:00",
                LocalDate.of(2019, Month.DECEMBER, 25));
        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                if(t1 != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    textAreaCenter1.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");

                    deadlineLabel.setText(df.format(item.getDueDate()));
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

}
