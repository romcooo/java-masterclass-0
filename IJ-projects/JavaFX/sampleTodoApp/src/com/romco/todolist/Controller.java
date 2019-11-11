package com.romco.todolist;

import com.romco.todolist.datamodel.TodoData;
import com.romco.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {

    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea textAreaCenter1;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;

    public void initialize() {
        todoItems = new ArrayList<>();
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        listContextMenu.getItems().addAll(deleteMenuItem);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                if(t1 != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    textAreaCenter1.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                    deadlineLabel.setText(df.format(item.getDueDate()));
                }
            }
        });

        todoItems = TodoData.getInstance().getTodoItems();
        todoListView.setItems(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>() {
                    @Override
                    protected void updateItem(TodoItem todoItem, boolean b) {
                        super.updateItem(todoItem, b);
                        if(b) {
                            setText(null);
                        } else {
                            setText(todoItem.getDescription());
                            if(todoItem.getDueDate().equals(LocalDate.now())) {
                                setTextFill(Color.RED);
                            } else if (todoItem.getDueDate().isBefore(LocalDate.now())) {
                                setTextFill(Color.DARKRED);
                            } else if (todoItem.getDueDate().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.DEEPPINK);
                            }
                        }
                    }
                };

                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if(isNowEmpty) {
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(listContextMenu);
                            }
                        }
                );

                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New ToDo Item");
        dialog.setHeaderText("Use this dialog to add a new Todo item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("todoItemDialog.fxml"));
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException ex) {
            System.out.println("Couldn't read dialog");
            ex.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("OK pressed.");
            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller.processResults();
            todoListView.getSelectionModel().select(newItem);
        } else {
            System.out.println("Cancel pressed.");
        }
    }

    @FXML
    public void saveData() {
        System.out.print("Saving data...");
        try {
            todoListView.getSelectionModel().getSelectedItem().setDetails(textAreaCenter1.getText());
            this.todoItems = todoListView.getItems();
            TodoData.getInstance().storeTodoItems(this.todoItems);
            System.out.print("Successful");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println();
        }
    }

    @FXML public void handleKeyPressedListView(KeyEvent keyEvent) {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            if(keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(selectedItem);
            }
        }
    }

    @FXML
    public void deleteItem(TodoItem itemToDelete) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete item: " + itemToDelete.getDescription());
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            TodoData.getInstance().deleteTodoItem(itemToDelete);
        }
    }

}
