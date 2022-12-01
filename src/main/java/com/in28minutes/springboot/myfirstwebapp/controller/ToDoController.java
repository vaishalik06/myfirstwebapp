package com.in28minutes.springboot.myfirstwebapp.controller;

import com.in28minutes.springboot.myfirstwebapp.model.ToDo;
import com.in28minutes.springboot.myfirstwebapp.service.ToDoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {


    private Logger LOGGER = LoggerFactory.getLogger(ToDoController.class);
    @Autowired
    private ToDoService toDoService;
    private ToDo toDo;
    private ModelMap modelMap;
    private BindingResult result;

    /**
     * This method will open the todo page
     *
     * @param modelMap
     * @return
     */
    @GetMapping("/list-todos")
    public String goToToDoPage(ModelMap modelMap) {
        //  toDoService.addToDo();
        List<ToDo> toDoList = toDoService.findToDoByUserName("Vaishali");
        modelMap.put("todos", toDoList);
        return "listTodos";
    }

    /**
     * This method will open the add todo page
     *
     * @param modelMap
     * @return
     */
    @GetMapping("/add-todo")
    public String showNewToDoPage(ModelMap modelMap) {
        String username = (String) modelMap.get("name");
        ToDo todo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);
        return "todo";
    }

    /**
     * Functionality to add new todo in the todo list
     *
     * @param toDo
     * @param modelMap
     * @return
     */
    @PostMapping("/add-todo")
    public String addNewToDo(@Valid @ModelAttribute("todo") ToDo toDo, BindingResult result, ModelMap modelMap) {
        LOGGER.info(String.valueOf(result));
        if (result.hasErrors()) {
            return "todo";
        }
        String username = (String) modelMap.get("name");
        toDoService.addToDo("username", toDo.getDescription(), toDo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @GetMapping("delete-todo")
    public String deleteToDoById(@RequestParam int id) {
        toDoService.deleteTodoById(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String showUpdateToDoPage(@RequestParam int id,ModelMap modelMap) {
        ToDo todo = toDoService.findToDoById(id);
        modelMap.put("todo",todo);
        return "todo";
    }

    @PostMapping("/update-todo")
    public String updateToDo(@Valid @ModelAttribute("todo") ToDo toDo, BindingResult result, ModelMap modelMap) {
        LOGGER.info(String.valueOf(result));
        if (result.hasErrors()) {
            return "todo";
        }
        String username = (String) modelMap.get("name");
       toDoService.updateTodo(toDo);
        return "redirect:list-todos";
    }

}
