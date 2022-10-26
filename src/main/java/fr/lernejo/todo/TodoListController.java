package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/todo")
public class TodoListController {


    private final ArrayList<Todo> Todolist = new ArrayList<Todo>();

    @PostMapping
    public void AddTodo(@RequestBody Todo todo)
    {
        Todolist.add(todo);
    }
    @GetMapping
    public ArrayList<Todo> GetTodo()
    {
        return Todolist;
    }


}
