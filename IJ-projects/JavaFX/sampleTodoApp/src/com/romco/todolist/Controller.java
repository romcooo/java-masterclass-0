package com.romco.todolist;

import com.romco.todolist.datamodel.TodoItem;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    public void initiaize() {
        TodoItem item1 = new TodoItem("Mail birthday card",
                "Buy a birthday card for John",
                LocalDate.of(2019, Month.DECEMBER, 25));
        TodoItem item2 = new TodoItem("Doctor's appointment",
                "Visit Dr. House at 123 Hutch Boulevard.",
                LocalDate.of(2019, Month.NOVEMBER, 21));
        TodoItem item3 = new TodoItem("Pick up Doug at train station",
                "  arriving on November 1st, at 11:00",
                LocalDate.of(2019, Month.DECEMBER, 25));
    }
}
