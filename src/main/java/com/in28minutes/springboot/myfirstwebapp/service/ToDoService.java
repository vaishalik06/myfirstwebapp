package com.in28minutes.springboot.myfirstwebapp.service;

import com.in28minutes.springboot.myfirstwebapp.model.ToDo;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class ToDoService {
    private static List<ToDo> toDoList = new ArrayList<>();
    private static int todosCount=0;

    static {
        toDoList.add(new ToDo(++todosCount, "in28minutes","Learn AWS",
                LocalDate.now().plusYears(1), false ));
        toDoList.add(new ToDo(++todosCount, "in28minutes","Learn DevOps",
                LocalDate.now().plusYears(2), false ));
        toDoList.add(new ToDo(++todosCount, "in28minutes","Learn Full Stack Development",
                LocalDate.now().plusYears(3), false ));
    }

    public void addToDo(String name, String description, LocalDate targetDate, boolean complete) {
        toDoList.add(new ToDo(++todosCount, name, description, targetDate, complete));
    }
    public List<ToDo> findToDoByUserName(String name) {
        return toDoList;
    }
    public void deleteTodoById(int id){
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        toDoList.removeIf(predicate);
    }
}
