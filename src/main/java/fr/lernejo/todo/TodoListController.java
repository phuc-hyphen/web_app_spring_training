package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/todo")
public class TodoListController {

    private final TodoRepository repo;

//    private final ArrayList<Todo> Todolist = new ArrayList<Todo>();

    public TodoListController(TodoRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public void AddTodo(@RequestBody TodoEntity todo) {
        repo.save(todo);
//        repo.add(todo);
    }

    @GetMapping
    public Iterable<TodoEntity> GetTodo() {
        return repo.findAll();
    }


}
